package org.fpinscala

object FunctionAsData {
  class Cat(val color: Color)

  // We create our bag (a set) of cats. Each cat has a different color.
  // Note the highlighting and suggestions
  val bagOfCats = ???

  // A function which checks if a cat is white go ginger, the `def` syntax
  def isCatWhiteOrGinger(cat: Cat): Boolean = ???

  // Pass the appropriate function into `filter` to create a bag of white cats.
  val bagOfWhiteOrGingerCats = ???

  // The whole "Cat => Boolean" is the type of the function
  val isCatWhiteOrGingerFun: Cat => Boolean = ???

  // We can use it instead of the method version in `filter`
  val bagOfWhiteOrGingerCatsFun = ???

  // or we can use an anonymous function - also called lambdas
  val bagOfWhiteOrGingerCatsAnon = ???

  // Lambdas, just as all functions, can take a value from its scope
  private val color = Color.White
  val numberOfColorCats = ???
}
