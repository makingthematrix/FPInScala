package org.fpinscala.finished

import Color.*

object Apply {
  case class Cat /*private*/ (name: String, color: Color,age: Int)

  enum CatType {
    case Adult, Kitten
  }

  object Cat {/*
    def apply(name: String, color: Color, age: Int): Cat =
      if (age < 0)
        new Cat(name, color, 0)
      else
        new Cat(name, color, age)
        */
/*
    def unapply(cat: Cat): CatType =
      if (cat.age > 1) CatType.Adult else CatType.Kitten
      */
  }

  val fluffy = Cat("Fluffy", Ginger, -5) // the age of Fluffy is set to 0, not -5
  val mittens = Cat("Mittens", Black, 2)
  val ginger = Cat("Ginger", Ginger, 3)
  val snowy = Cat("Snowy", White, 1)
  val midnight = Cat("Midnight", Black, 4)

/*  @main def main(): Unit = {
    val cats = Seq(mittens, fluffy, ginger, snowy, midnight)
    cats.foreach {
      case Cat(name, _, 2) =>
        println(s"$name is exactly two years old")
      case Cat(name, color, age) if age > 1 =>
        println(s"This is a $color adult cat called $name")
      case Cat(name, color, age) =>
        println(s"This is a $color kitten called $name (age: $age)")
    }
  }*/
}
