import java.util.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;

public class exp555 {

    private static final int num_of_reducer = 10;

    public static void main(String[] args) throws Exception {
        String inputpath1="/data6/ip_trace";
        String inputpath2="/data6/raw_block";
        String outputpath1="/labspark/ouput55";
        String outputpath2="/labspark/output56";
        SparkConf sparkConf = new SparkConf().setAppName("exp2");
        //.setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(sparkConf);

        //ip_raw
        JavaRDD<String> file1 = context.textFile(inputpath1);

        //map by (key, value)=(connection_id, line)
        JavaPairRDD<String, String> ip = file1.mapToPair(new PairFunction<String, String, String>() {
            public Tuple2<String, String> call(String s) {
                String[] st = s.split(" ");
                return new Tuple2<String, String>(st[1], s);
            }
        });

        //raw_block
        JavaRDD<String> file2 = context.textFile(inputpath2);

        //map by (key, value)=(connection_id, status)
        JavaPairRDD<String, String> blocks = file2.mapToPair(new PairFunction<String, String, String>() {
            public Tuple2<String, String> call(String s) {
                String[] st = s.split(" ");
                return new Tuple2<String, String>(st[0], st[1]);
            }
        });

        // filter blocks by "Blocked"
        JavaPairRDD<String, String> blocked = blocks.filter(new Function<Tuple2<String, String>, Boolean>() {
            public Boolean call(Tuple2<String, String> t) {
                return t._2.equals("Blocked");
            }
        });

        //join ip and blocked
        JavaPairRDD<String, Tuple2<String, String>> join = ip.join(blocked);

        //map by (key, value)=(source_ip, required_format)
        JavaPairRDD<String, String> firewall = join.mapToPair(new PairFunction<Tuple2<String, Tuple2<String, String>>, String, String>() {
            public Tuple2<String, String> call(Tuple2<String, Tuple2<String, String>> t) throws Exception {
                String[] st = t._2._1.split(" ");
                return new Tuple2<String, String>(st[2], st[0] + " " + st[1] + " " + st[2] + " " + st[4] + " Blocked");
            }
        });

        //save part A
        firewall.values().saveAsTextFile(outputpath1);

        //map by (key, value)=(source_ip, 1)
        JavaPairRDD<String, Integer> temp = firewall.mapToPair(new PairFunction<Tuple2<String, String>, String, Integer>() {
            public Tuple2<String, Integer> call(Tuple2<String, String> t) throws Exception {
                return new Tuple2<String, Integer>(t._1, 1);
            }
        });

        //count each ip
        JavaPairRDD<String, Integer> count = temp.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }
        }, num_of_reducer);

        //swap key and value to sort by key
        JavaPairRDD<Integer, String> swapped = count.mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
            public Tuple2<Integer, String> call(Tuple2<String, Integer> item) throws Exception {
                return item.swap();
            }
        });

        //sort
        JavaPairRDD<Integer, String> sorted = swapped.sortByKey(false);

        sorted.saveAsTextFile(outputpath2);
        context.stop();
        context.close();
    }
}
