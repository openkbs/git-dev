/**
  * Created by rs001 on 11/6/2016.
  */
object ImplictHelper {
  implicit class IntTimes(x: Int) {
    def times [A](f: =>A): Unit = {
      def loop(current: Int): Unit =
        if(current > 0){
          f
          loop(current - 1)
        }
      loop(x)
    }
  }
}

import ImplictHelper._

object ImplictTimes {
  def main(args: Array[String]) {
    // 4 times(println("hello"))
    4 times println("hello")
  }
}
