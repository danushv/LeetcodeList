import java.util.*;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamUtils;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

@SuppressWarnings("serial")
public class EXPLAB71 {

  public static void main(String[] args) throws Exception {
    final ParameterTool params = ParameterTool.fromArgs(args);

    // set up the execution environment
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

 
    env.getConfig().setGlobalJobParameters(params);

    
    // <PATH_TO_DATA>: The path to input data, e.g., "/home/cpre419/Downloads/shakespeare"
    DataStream<String> text = env.readTextFile("/home/cpre419/Downloads/shakespeare");

    DataStream<Tuple2<String, Integer>> counts =text.flatMap(new Tokenizer()) .keyBy(0).sum(1);

   

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    Iterator<Tuple2<String, Integer>> output = DataStreamUtils.collect(counts);
    while (output.hasNext()) {
      Tuple2<String, Integer> temp = output.next();
      map.put(temp.f0, temp.f1);
    }

   
    List<Map.Entry<String, Integer>> l = new LinkedList<Map.Entry<String, Integer>>( map.entrySet());


    Collections.sort(l,new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> value1,Map.Entry<String, Integer> value2) {
        	
       
          return value2.getValue().compareTo(value1.getValue());
        }
      }
    );
    int max = Math.min(l.size(), 10);
    for (int iterator = 0; iterator < max; iterator++) {
      System.out.println("(" + l.get(iterator).getKey() + "," + l.get(iterator).getValue() + ")");
    }
  }

  public static final class Tokenizer
    implements FlatMapFunction<String, Tuple2<String, Integer>> {

    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
      String[] t = value.toLowerCase().split("\\W+");
      for (String t1 : t) {if (t1.length() > 0) {out.collect(new Tuple2<String, Integer>(t1, 1));
        }
      }
    }
  }
}
