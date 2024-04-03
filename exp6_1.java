import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

public class exp6_1 {

  //private static final int numOfReducers = 2;\
    private static final String INPUT_PATH = "/data6/github.csv";
    private static final String OUTPUT_PATH = "/labspark/output6";

  @SuppressWarnings("serial")
  public static void main(String[] args) throws Exception {
   // if (args.length != 2) {
   //   System.err.println("Usage: <input> <output>");
  //    System.exit(1);
   // }
    SparkConf sparkConf = new SparkConf().setAppName("Lab6 exp1");
    //.setMaster("local[*]");
    JavaSparkContext context = new JavaSparkContext(sparkConf);

    //githuv.csv
    JavaRDD<String> file = context.textFile(INPUT_PATH);

    //map by (key, value)=(language, line)
    JavaPairRDD<String, String> git = file.mapToPair(
      new PairFunction<String, String, String>() {
        public Tuple2<String, String> call(String s) {
          String[] st = s.split(",");
          return new Tuple2<String, String>(st[1], s);
        }
      }
    );

    //group by language
    JavaPairRDD<String, Iterable<String>> grouped = git.groupByKey();

    //for each language return the info with given format
    JavaPairRDD<Long, String> output = grouped.mapToPair(
      new PairFunction<Tuple2<String, Iterable<String>>, Long, String>() {
        public Tuple2<Long, String> call(
          Tuple2<String, Iterable<String>> values
        ) {
    
          long c = 0;
    
          long m = 0;
        
          String r = "";
       
          String l = "";
          for (String s : values._2) {
            String[] sta = s.split(",");
            c++;
            if (Long.valueOf(sta[12]) > m) {
              m = Long.valueOf(sta[12]);
     r = sta[0];
              l = sta[1];
            }
          }
          return new Tuple2<Long, String>(c, l + " " + c + " " + r + " " + m);
        }
      }
    );

    //sort
    JavaPairRDD<Long, String> sorted = output.sortByKey(false);

    //save
    sorted.values().saveAsTextFile(OUTPUT_PATH);
    context.stop();
    context.close();
  }
}
