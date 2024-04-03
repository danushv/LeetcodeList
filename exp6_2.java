import java.util.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;
import scala.Tuple3;

public class exp6_2 {

  //private static final int numOfReducer = 10;
	private static final String INPUT_PATH = "/data6/patents_small.txt";
    private static final String OUTPUT_PATH = "/labspark/output6_2";
  @SuppressWarnings("serial")
  public static void main(String[] args) throws Exception {
   // if (args.length != 2) {
   //   System.err.println("Usage <input> <output>");
   //   System.exit(1);
  //  }
    SparkConf sparkConf = new SparkConf().setAppName("Lab6");
    //.setMaster("local[*]");
    JavaSparkContext context = new JavaSparkContext(sparkConf);

 
    JavaRDD<String> file = context.textFile(INPUT_PATH);
    JavaRDD<String> cleaned = file.filter(
      new Function<String, Boolean>() {
        public Boolean call(String s) {
          return !s.isEmpty();
        }
      }
    );

    JavaPairRDD<Long, Long> ext = cleaned.flatMapToPair(
      new PairFlatMapFunction<String, Long, Long>() {
        @SuppressWarnings("unchecked")
        public Iterator<Tuple2<Long, Long>> call(String s) {
          String[] str = s.trim().replaceAll("\\s+", " ").split(" ");
          return Arrays.asList(new Tuple2<Long, Long>(Long.parseLong(str[0]), Long.parseLong(str[1])),
              new Tuple2<Long, Long>(
                Long.parseLong(str[1]),
                Long.parseLong(str[0])
              )
            )
            .iterator();
        }
      }
    );

    
    JavaPairRDD<Long, Iterable<Long>> tri = ext.groupByKey();

    
    JavaPairRDD<Long, Tuple2<Long, Iterable<Long>>> temp = tri.flatMapToPair(
      new PairFlatMapFunction<Tuple2<Long, Iterable<Long>>, Long, Tuple2<Long, Iterable<Long>>>() {
        public Iterator<Tuple2<Long, Tuple2<Long, Iterable<Long>>>> call(
          Tuple2<Long, Iterable<Long>> s
        ) {
          Iterable<Long> values = s._2;
          List<Tuple2<Long, Tuple2<Long, Iterable<Long>>>> output = new ArrayList<Tuple2<Long, Tuple2<Long, Iterable<Long>>>>();

          for (Long value : values) {
            output.add(new Tuple2<Long, Tuple2<Long, Iterable<Long>>>(value, s) );
          }

          return output.iterator();
        }
      }
    );

    JavaPairRDD<Long, Iterable<Tuple2<Long, Iterable<Long>>>> grouped = temp.groupByKey();

    
    JavaRDD<Tuple3<Long, Long, Long>> t2 = grouped.flatMap(
      new FlatMapFunction<Tuple2<Long, Iterable<Tuple2<Long, Iterable<Long>>>>, Tuple3<Long, Long, Long>>() {
        public Iterator<Tuple3<Long, Long, Long>> call(Tuple2<Long, Iterable<Tuple2<Long, Iterable<Long>>>> s) {
          HashSet<Long> s = new HashSet<Long>();
          long key = s._1;
       
          Iterable<Tuple2<Long, Iterable<Long>>> values = s._2;
       
          for (Tuple2<Long, Iterable<Long>> value : values) {
            s.add(value._1);
          }
          List<Tuple3<Long, Long, Long>> output = new ArrayList<Tuple3<Long, Long, Long>>();
          for (Tuple2<Long, Iterable<Long>> value : values) {
            for (Long x : value._2) {
              if (s.contains(x)) {
                Long[] tria = { key, value._1, x }; Arrays.sort(tria);
                output.add(new Tuple3<Long, Long, Long>(tria[0], tria[1], tria[2]) );}
            }
          }
          return output.iterator();
        }
      }
    );
    JavaRDD<Tuple3<Long, Long, Long>> t3 = t2.distinct();

    List<Long> list = new ArrayList<Long>();
    list.add(t3.count());
    JavaRDD<Long> result = context.parallelize(list);

    result.saveAsTextFile(OUTPUT_PATH);
    context.stop();
    context.close();
  }
}
