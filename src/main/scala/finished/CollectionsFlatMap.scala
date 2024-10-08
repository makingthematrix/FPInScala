package org.fpinscala.finished

import org.fpinscala.{CarBrand, Color}
import Color.*
import CarBrand.*
// 2.1

object CollectionsFlatMap {
  case class Cat(name: String, color: Color)

  val felix = Cat("Felix", Black)
  val shadow = Cat("Shadow", Black)
  val snowball = Cat("Snowball", White)
  val garfield = Cat("Garfield", Ginger)

  // We put them all in a list
  val cats = Seq(felix, shadow, snowball, garfield)

  case class Car(brand: CarBrand, color: Color)

  // We define a function that takes a cat and produces a list of cars
  def catToCars(cat: Cat): Seq[Car] =
    Seq(
      Car(Volkswagen, cat.color),
      Car(Mercedes, cat.color),
      Car(Toyota, cat.color)
    )

  val cars = cats.flatMap(catToCars)

/*  @main def main(): Unit = {
    println(s"Number of cars: ${cars.size}")
    cars.foreach(car => println(s"${car.color} ${car.brand}"))
  }*/
}
