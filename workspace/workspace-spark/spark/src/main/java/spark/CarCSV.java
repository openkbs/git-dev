package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class CarCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkSession spark = SparkSession
				  .builder()
				  .appName("Java Spark SQL basic example")
				  .config("spark.some.config.option", "some-value")
				  .getOrCreate();
		
//		SparkConf conf = new SparkConf().setAppName("Java Spark: word count").setMaster("local");
//		JavaSparkContext sc = new JavaSparkContext(conf);
//		JavaRDD<String> textFile = sc.textFile("food.txt");
//		SQLContext sqlContext = new SQLContext(sc);
//		DataFrame df = sqlContext.read()
//		    .format("com.databricks.spark.csv")
//		    .option("inferSchema", "true")
//		    .option("header", "true")
//		    .load("cars.csv");
//
//		df.select("year", "model").write()
//		    .format("com.databricks.spark.csv")
//		    .option("header", "true")
//		    .save("newcars.csv");
	}

}
