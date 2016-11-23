package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SparkTestApp {

	public static void main(String[] args) {

		// Example
		// winutils.exe is copied to C:\winutil\bin\
		// System.setProperty("hadoop.home.dir", "C:\\winutil\\");
		String logFile = "food.txt";
		SparkConf conf = new SparkConf().setAppName("Java Spark: word count")
				.setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> logData = sc.textFile(logFile).cache();

		long numAs = logData.filter(new Function<String, Boolean>() {
			public Boolean call(String s) {
				return s.contains("a");
			}
		}).count();
		sc.close();
		System.out.println("Lines with a: " + numAs);
	}
}