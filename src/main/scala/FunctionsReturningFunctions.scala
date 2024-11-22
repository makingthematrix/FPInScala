package org.fpinscala

// 7

object FunctionsReturningFunctions {
  val colors: Seq[Color] = Color.values.toSeq
  val catNames: Seq[String] = Seq("Fluff", "Shadow", "Garfield")

  // a cat generator for the same name and random colors

  // a cat generator for the same color and random names

  // partial application
  def createBlackCat: String => Cat = ???

  /*
  Currying is the process of converting a function with multiple arguments into a sequence
  of functions that take one argument. Each function returns another function that consumes
  the following argument.

  Partial application is the process of reducing the number of arguments by applying some
  of them when the method or function is created.

  More:
   1. https://www.baeldung.com/scala/currying
   2. https://en.wikipedia.org/wiki/Currying
   */

  /*  @main def main(): Unit = {
      //println(gen1())
      //println(gen2())
      //println(increment(3))
    }*/
}
