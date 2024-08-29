package org.fpinscala.finished

// 3

object PartialFunctions {
  enum Color {
    case Black, White, Ginger
  }
  
  import Color.*

  // traits!
  trait Animal {
    def name: String
    def color: Color
  }
  
  case class Cat(name: String, color: Color) extends Animal
  case class Dog(name: String, color: Color) extends Animal

  // We create three instances of cats
  val felix = Cat("Felix", Black)
  val garfield = Cat("Garfield", Ginger)
  val shadow = Cat("Shadow", Black)

  // and two instances of dogs
  val fido = Dog("Fido", Black)
  val snowy = Dog("Snowy", White)

  // We put all cats and dogs in a sequence of type Seq[Animal]
  val animals: Seq[Animal] = Seq(felix, garfield, shadow, fido, snowy)

  // Using the collect method, we create a new sequence containing only black cats
  val blackCats: Seq[Cat] = animals.collect {
    case cat: Cat if cat.color == Black => cat
  }
  
  // We will come back to `collect` in the part about early returns
}
