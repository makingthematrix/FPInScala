package org.fpinscala

// 2.1

object CollectionsFlatMap {
  case class Cat(name: String, color: Color)

  import Color.*

  val felix = Cat("Felix", Black)
  val shadow = Cat("Shadow", Black)
  val snowball = Cat("Snowball", White)
  val garfield = Cat("Garfield", Ginger)

  // We put them all in a sequence
  val cats = ???

  case class Car(brand: CarBrand, color: Color)

  import CarBrand.*
  // We define a function that takes a cat and produces a list of cars
  def catToCars(cat: Cat): Seq[Car] = ???

  // and now let's flatmap cats to cars
  val cars = ???
}
