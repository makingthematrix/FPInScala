package org.fpinscala

import Color.*

object Apply {
  case class Cat (name: String, color: Color, age: Int)

  object Cat {
    def apply(name: String, color: Color, age: Int): Cat = ???
  }

  val fluffy = Cat("Fluffy", Ginger, -5) // the age of Fluffy should be 0, not -5
  val mittens = Cat("Mittens", Black, 2)
  val ginger = Cat("Ginger", Ginger, 3)
  val snowy = Cat("Snowy", White, 1)
  val midnight = Cat("Midnight", Black, 4)

/*  @main def main(): Unit = {
    val cats = Seq(mittens, fluffy, ginger, snowy, midnight)
    cats.foreach {
      case Cat(name, _, 2)                  => println(s"$name is exactly two years old")
      case Cat(name, color, age) if age > 1 => println(s"This is a $color adult cat called $name")
      case Cat(name, color, age)            => println(s"This is a $color kitten called $name (age: $age)")
    }
  }*/
}