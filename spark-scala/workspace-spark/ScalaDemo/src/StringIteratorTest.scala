/**
  * Created by rs001 on 11/6/2016.
  */
abstract class AbstractIterator {
  type T

  def hasNext: Boolean

  def next: T
}

trait RichIterator extends AbstractIterator {
  def foreach(f: T => Unit) {
    while (hasNext) f(next)
  }
}

class StringIterator(s: String) extends AbstractIterator {
  type T = Char
  private var i = 0

  def hasNext = i < s.length()

  def next = {
    val ch = s charAt i; i += 1; ch
  }
}

object StringIteratorTest {
  def main(args: Array[String]) {
    //class Iter extends StringIterator(args(0)) with RichIterator
    class Iter extends StringIterator("abcdf") with RichIterator
    val iter = new Iter
    iter foreach println
  }
}
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