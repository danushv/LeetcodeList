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

public class Exp1 {

	// private static final int numOfReducers = 2;

	@SuppressWarnings("serial")
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: <input> <output>");
			System.exit(1);
		}
		SparkConf sparkConf = new SparkConf().setAppName("Lab5 exp1");
		// .setMaster("local[*]");
		JavaSparkContext context = new JavaSparkContext(sparkConf);

		// Read input file
		JavaRDD<String> file = context.textFile(args[0]);

		// Map each line to (key, value)=(language, line)
		JavaPairRDD<String, String> git = file.mapToPair(
				new PairFunction<String, String, String>() {
					public Tuple2<String, String> call(String line) {
						String[] parts = line.split(",");
						return new Tuple2<String, String>(parts[1], line);
					}
				});

		// Group by language
		JavaPairRDD<String, Iterable<String>> grouped = git.groupByKey();

		// For each language, return the info with given format
		JavaPairRDD<Long, String> output = grouped.mapToPair(
				new PairFunction<Tuple2<String, Iterable<String>>, Long, String>() {
					public Tuple2<Long, String> call(
							Tuple2<String, Iterable<String>> values) {
						long count = 0; // Number of records
						long maxStars = 0; // Maximum stars
						String repoWithMaxStars = ""; // Repository with maximum stars
						String language = ""; // Name of language
						for (String line : values._2) {
							String[] parts = line.split(",");
							count++;
							if (Long.valueOf(parts[12]) > maxStars) {
								maxStars = Long.valueOf(parts[12]);
								repoWithMaxStars = parts[0];
								language = parts[1];
							}
						}
						return new Tuple2<Long, String>(
								count,
								language + " " + count + " " + repoWithMaxStars + " " + maxStars);
					}
				});

		// Sort
		JavaPairRDD<Long, String> sortedOutput = output.sortByKey(false);

		// Save
		sortedOutput.values().saveAsTextFile(args[1]);
		context.stop();
		context.close();
	}
}
