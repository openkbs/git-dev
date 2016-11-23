

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCount {
  def main(args: Array[String]) = {
    //System.setProperty("hadoop.home.dir", "C:\\winutils")
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)
    // -- One-Liner
    val one = sc.textFile("food.txt").cache()
      .flatMap { line => line.split(" ") }
      .map { word => (word, 1) }
      .reduceByKey(_ + _)
      .saveAsTextFile("food_count1.txt")

    //val textFile = sc.textFile("hdfs://...")
    val textFile = sc.textFile("food.txt")
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.saveAsTextFile("food_count2.txt")
  }
}