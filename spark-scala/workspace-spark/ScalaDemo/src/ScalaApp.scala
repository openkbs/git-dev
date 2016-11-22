/**
  * Created by rs001 on 11/4/2016.
  */

import scala.math._

object ScalaApp {
  def main(args: Array[String]): Unit = {
    println("Hello");
    var i = 0;
    while (i <= 10) {
      println(i);
      i += 1;
    }
    println("--------- Print 1 2 3 4 5 -------")
    var aList = List(1, 2, 3, 4, 5)
    for (j <- aList) {
      println("List items: " + j)
    }
    aList.foreach {
      println
    }

    println("--------- Print Even number -------")
    var evenList = for {k <- 1 to 20
                        if (k % 2) == 0} yield (k)

    for (n <- evenList)
      println(n)

    println("--------- Print 1..5 x 5 ..10 -------")
    for (i <- 1 to 5; j <- 6 to 10) {
      println("iter", i, j)
    }

    println("--------- Print Vector: Names -------")
    val names = Vector("Bob", "Fred", "Joe", "Julia", "Kim")
    for (name <- names if name.startsWith("J")) {
      println("vector: Name=" + name)

    }

    println("--------- zipWithIndex or Zip -------")
    // you can print the elements in the collection with a counter using the zipWithIndex and foreach methods:
    val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    days.zipWithIndex.foreach {
      case (day, count) => println(s"$count is $day")
    }

    println("--------- Array Range - Fruits example -------")
    val fruits = Array("apple", "banana", "kiwi", "orange", "pipleapple")
    for (i <- 0 until fruits.size) {
      println(s"element $i is ${fruits(i)}")
    }

    println("--------- Type & Polymorphism -------")
    def drop1[A](l: List[A]) = l.tail
    drop1(List(1, 2, 3))

    println("--------- Print Map : employees' Manager -------")
    // Create a Map that can't be changed (Immutable)
    val employees = Map("Manager" -> "Bob Smith", "Secretary" -> "Sue Brown")

    // Get value using the key after checking that it exists
    if (employees.contains("Manager"))
      printf("Manager : %s\n", employees("Manager"))


    println("---------- HIGHER ORDER FUNCTIONS ----------")
    // Functions can be passed like any other variable
    // You need the _ after the function to state you meant the function
    val log10Func = log10 _

    println(log10Func(1000))

    println("---------- apply log10Func as argument ----------")
    // You can apply a function to all items of a list with map
    List(10.0, 100.0, 1000.0, 10000.0, 100000.0).map(log10Func).foreach(println)

    println("---------- map using a new inline function as argument ----------")
    // You can use an anonymous function with map as well
    // Receives an Int x and multiplies every x by 50
    List(1, 2, 3, 4, 5).map((x: Int) => x * 50).foreach(println)

    println("---------- filter using a new inline function as argument ----------")
    // Filter will pass only those values that meet a condition
    List(1, 2, 3, 4, 5, 6).filter(_ % 2 == 0).foreach(println)

    println("---------- define times3, times4 functions ----------")
    // Pass different functions to a function=
    def times3(num: Int) = num * 3
    def times4(num: Int) = num * 4

    println("---------- Define the function parameter type and return type ----------")
    // Define the function parameter type and return type
    def multIt(func: (Int) => Double, num: Int) = {
      func(num)
    }

    println("---------- Appy Function 'times3', 'times4' as the function parameter type and return type ----------")
    printf("3 * 100 = %.1f)\n", multIt(times3, 100))
    printf("3 * 100 = %.1f)\n", multIt(times4, 100))

    println("---------- A closure is a function that depends on a variable declared outside of the function ----------")
    // A closure is a function that depends on a variable declared outside
    // of the function
    val divisorVal = 5
    val divisor5 = (num: Double) => num / divisorVal
    println("5 / 5 = " + divisor5(5.0))



//    println("---------- Operator overloading ----------")
//    def +(that: Int): Rational =
//      this + (new Rational(that, 1))
  }

}
