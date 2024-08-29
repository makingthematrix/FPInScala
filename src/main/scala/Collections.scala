package org.fpinscala

object Collections {
  import Color.*

  case class Cat(name: String, color: Color)

  val felix = Cat("Felix", Black)
  val garfield = Cat("Garfield", Ginger)
  val fluff = Cat("Fluff", White)
  
  // Scala collections: Seq, Set, Map
  val catsSeq = ???
  val sortedCats1 = ???

  // This won't work because cats don't have an implicit ordering
  //val sortedCats2 = catsSeq.sorted

  val sortedCats3 = ???

  // maps
  val catsMap = ???

  // tuples
  val catsTuples = ???

  // filter - we already discussed it

  // find
  val blackCat = ???
  val felixTheCat = ???

  // foreach


  // map
  // Let's create another class
  case class Car(color: Color)
  val cars = ???
}
