/**
  * Created by rs001 on 11/7/2016.
  */

class Decorator(left: String, right: String) {
  def layout[T](x: T) = left + x.toString() + right
}

object HigherOrderFunctionTest extends App {
  def apply(f: Int => String, v: Int) = f(v)

  val decorator = new Decorator("[", "]")
  println(apply(decorator.layout, 7))
}