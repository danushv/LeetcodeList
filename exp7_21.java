import java.util.*;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

@SuppressWarnings("serial")
public class FS1 {

  public static void main(String[] args) throws Exception {
    final ParameterTool params = ParameterTool.fromArgs(args);

    // set up the execution environment
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    // make parameters available in the web interface
    env.getConfig().setGlobalJobParameters(params);

    // get input data from a specified path to Shakespeare's works
    DataStream<String> text = env.readTextFile("/home/cpre419/Downloads/shakespeare");

    DataStream<Tuple2<String, Integer>> counts =text.flatMap(new Tokenizer()).keyBy(0).sum(1);

  
    counts.print();  

    env.execute("Bigram Counting");  
  }

  public static final class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {

    public void flatMap(String v, Collector<Tuple2<String, Integer>> o) {
   
      v = v.toLowerCase();
      String[] s = v.split("[.?!]");
      for (String sa : s) {
        String[] wa = sa.trim().split("\\s+");
        String pw = null;
        for (String w : wa) {
          if (pw != null && !pw.isEmpty() && !w.isEmpty()) {
            String bigram = pw + " " + w;
            o.collect(new Tuple2<String, Integer>(bigram, 1));  }
          pw = w; 
        }
      }
    }
  }
}
