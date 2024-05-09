import java.util.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;
import scala.Tuple3;

public class Exp2 {

    // private static final int numOfReducer = 10;

    @SuppressWarnings("serial")
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage <input> <output>");
            System.exit(1);
        }
        SparkConf sparkConf = new SparkConf().setAppName("Lab6 exp2");
        // .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(sparkConf);

        // Read edges and remove empty lines
        JavaRDD<String> file = context.textFile(args[0]);
        JavaRDD<String> cleaned = file.filter(
                new Function<String, Boolean>() {
                    public Boolean call(String line) {
                        return !line.isEmpty();
                    }
                });

        // Store edges with both directions because this is an undirected graph
        JavaPairRDD<Long, Long> edges = cleaned.flatMapToPair(
                new PairFlatMapFunction<String, Long, Long>() {
                    @SuppressWarnings("unchecked")
                    public Iterator<Tuple2<Long, Long>> call(String line) {
                        String[] parts = line.trim().replaceAll("\\s+", " ").split(" ");
                        return Arrays
                                .asList(
                                        new Tuple2<Long, Long>(
                                                Long.parseLong(parts[0]),
                                                Long.parseLong(parts[1])),
                                        new Tuple2<Long, Long>(
                                                Long.parseLong(parts[1]),
                                                Long.parseLong(parts[0])))
                                .iterator();
                    }
                });

        // Group edges by start node
        JavaPairRDD<Long, Iterable<Long>> groupedEdges = edges.groupByKey();

        // Populate the record with (key, value) = (the neighbor of the key, input
        // tuple)
        JavaPairRDD<Long, Tuple2<Long, Iterable<Long>>> neighborPairs = groupedEdges.flatMapToPair(
                new PairFlatMapFunction<Tuple2<Long, Iterable<Long>>, Long, Tuple2<Long, Iterable<Long>>>() {
                    public Iterator<Tuple2<Long, Tuple2<Long, Iterable<Long>>>> call(
                            Tuple2<Long, Iterable<Long>> pair) {
                        Iterable<Long> values = pair._2;
                        List<Tuple2<Long, Tuple2<Long, Iterable<Long>>>> output = new ArrayList<>();

                        for (Long value : values) {
                            output.add(new Tuple2<Long, Tuple2<Long, Iterable<Long>>>(value, pair));
                        }

                        return output.iterator();
                    }
                });

        // Group them by key
        JavaPairRDD<Long, Iterable<Tuple2<Long, Iterable<Long>>>> groupedPairs = neighborPairs.groupByKey();

        // Find the triangles
        JavaRDD<Tuple3<Long, Long, Long>> triangles = groupedPairs.flatMap(
                new FlatMapFunction<Tuple2<Long, Iterable<Tuple2<Long, Iterable<Long>>>>, Tuple3<Long, Long, Long>>() {
                    public Iterator<Tuple3<Long, Long, Long>> call(
                            Tuple2<Long, Iterable<Tuple2<Long, Iterable<Long>>>> pair) {
                        long key = pair._1;
                        Iterable<Tuple2<Long, Iterable<Long>>> values = pair._2;
                        HashSet<Long> reachableNodes = new HashSet<>();

                        for (Tuple2<Long, Iterable<Long>> value : values) {
                            reachableNodes.add(value._1);
                        }

                        List<Tuple3<Long, Long, Long>> output = new ArrayList<>();
                        for (Tuple2<Long, Iterable<Long>> value : values) {
                            for (Long neighbor : value._2) {
                                if (reachableNodes.contains(neighbor)) {
                                    Long[] triangle = { key, value._1, neighbor };
                                    Arrays.sort(triangle);
                                    output.add(new Tuple3<Long, Long, Long>(triangle[0], triangle[1], triangle[2]));
                                }
                            }
                        }
                        return output.iterator();
                    }
                });

        // Eliminate duplicate triangles
        JavaRDD<Tuple3<Long, Long, Long>> distinctTriangles = triangles.distinct();

        // Store the number of triangles
        List<Long> triangleCountList = new ArrayList<>();
        triangleCountList.add(distinctTriangles.count());
        JavaRDD<Long> triangleCountRDD = context.parallelize(triangleCountList);

        // Save
        triangleCountRDD.saveAsTextFile(args[1]);
        context.stop();
        context.close();
    }
}
