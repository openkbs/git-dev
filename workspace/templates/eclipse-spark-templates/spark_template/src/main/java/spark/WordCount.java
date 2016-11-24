package spark;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class WordCount {

	// Java 7
	public static void wordCountJava7(String filename) {
		SparkConf conf = new SparkConf().setAppName("Java Spark: word count").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> textFile = sc.textFile(filename);
		JavaRDD<String> words = textFile
				.flatMap(new FlatMapFunction<String, String>() {
					public Iterator<String> call(String s) {
						return Arrays.asList(s.split(" ")).iterator();
					}
				});
		JavaPairRDD<String, Integer> pairs = words
				.mapToPair(new PairFunction<String, String, Integer>() {
					public Tuple2<String, Integer> call(String s) {
						return new Tuple2<String, Integer>(s, 1);
					}
				});
		JavaPairRDD<String, Integer> counts = pairs
				.reduceByKey(new Function2<Integer, Integer, Integer>() {
					public Integer call(Integer a, Integer b) {
						return a + b;
					}
				});
		counts.saveAsTextFile("food_count_java.out");
		sc.close();
	}

	public static void wordCountJava8(String filename) {
		// Define a configuration to use to interact with Spark
		SparkConf conf = new SparkConf().setMaster("local").setAppName("Work Count App");

		// Create a Java version of the Spark Context from the configuration
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Load the input data, which is a text file read from the command line
		JavaRDD<String> input = sc.textFile(filename);

		// Java 8 with lambdas: split the input string into words
		JavaRDD<String> words = input
				.flatMap(s -> (Arrays.asList(s.split(" "))).iterator());

		// Java 8 with lambdas: transform the collection of words into pairs
		// (word and 1) and then count them
		JavaPairRDD<String, Integer> counts = words
				.mapToPair(t -> new Tuple2<String, Integer>(t, 1))
				.reduceByKey((x, y) -> (int) x + (int) y);

		// Save the word count back out to a text file, causing evaluation.
		counts.saveAsTextFile(filename + "output-Java8");
		sc.close();
	}

	public static void main(String[] args) throws Exception {

	}
}