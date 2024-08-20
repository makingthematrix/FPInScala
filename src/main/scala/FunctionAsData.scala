package org.makingthematrix.fpinscala

object FunctionAsData {
  class Cat(val color: Color)

  // We create our bag (a set) of cats. Each cat has a different color.
  // Note the highlighting and suggestions
  val bagOfCats = Set(Cat(Color.White), Cat(Color.Ginger), Cat(Color.Black))

  // A function which checks if a cat is white go ginger, the `def` syntax
  def isCatWhiteOrGinger(cat: Cat): Boolean = cat.color == Color.White || cat.color == Color.Ginger

  // Pass the appropriate function into `filter` to create a bag of white cats.
  val bagOfWhiteOrGingerCats = bagOfCats.filter(isCatWhiteOrGinger)

  // The whole "Cat => Boolean" is the type of the function

  val isCatWhiteOrGingerFun: Cat => Boolean =
    cat => cat.color == Color.White || cat.color == Color.Ginger

  // We can use it instead of the method version in `filter`
  val bagOfWhiteOrGingerCatsFun = bagOfCats.filter(isCatWhiteOrGingerFun)

  // or we can use an anonymous function - also called lambdas
  val bagOfWhiteOrGingerCatsAnon = bagOfCats.filter(cat => cat.color == Color.White || cat.color == Color.Ginger)

  // Lambdas, just as all functions, can take a value from its scope
  private val color = Color.White
  val numberOfColorCats = bagOfCats.filter(_.color == color)
}
