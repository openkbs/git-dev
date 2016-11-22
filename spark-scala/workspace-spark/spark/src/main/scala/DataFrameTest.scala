import org.apache.spark.sql.SparkSession

object DataFrameTest {
  def main(args: Array[String]) = {
    val spark = SparkSession
      .builder()
      .master("local")
      .appName("My Spark Application")
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
    val df = spark.read.json("D:/Tools/spark-2.0.2-bin-hadoop2.7/examples/src/main/resources/people.json")

    // Displays the content of the DataFrame to stdout
    df.limit(10).show()
    
    // Print the schema in a tree format
    df.printSchema()
    
    // Select only the "name" column
    df.select("name").show()
    
    // Select every row but increment each row's age by 1
    df.select($"name", $"age"+1).show()
    
    // Select people older than age 21
    df.filter($"age" > 21).show()
    
    // Count people by age
    df.groupBy("age").count().show()
    
    
    // Stop spark session
    spark.stop()
  }
}