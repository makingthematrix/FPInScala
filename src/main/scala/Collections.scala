package org.makingthematrix.fpinscala

object Collections {
  import Color.*

  case class Cat(name: String, color: Color)

  val felix = Cat("Felix", Black)
  val garfield = Cat("Garfield", Ginger)
  val fluff = Cat("Fluff", White)
  
  // Scala collections: Seq, Set, Map
  val catsSeq = Seq(fluff, garfield, felix)
  val sortedCats1 = catsSeq.sortWith( (c1, c2) => ??? )

  // This won't work because cats don't have an implicit ordering
  //val sortedCats2 = catsSeq.sorted

  // But this will
  val sortedCats3 = catsSeq.sortBy(_.color.toString)

  // maps
  val catsMap = Map(
    "Felix"    -> felix,
    "Garfield" -> garfield,
    "Fluff"    -> fluff
  )

  // tuples
  val catsTuples: Seq[(String, Cat)] = catsMap.toSeq

  // filter - we already discussed it

  // find
  val blackCat: Option[Cat] = catsSeq.find { cat => cat.color == Black }
  val felixTheCat: Option[Cat] = catsSeq.find { cat => cat.name == "Felix" } // also: _.name == "Felix"

  // foreach
  catsSeq.foreach(cat => println(s"This is ${cat.name}"))

  // map
  // Let's create another class
  case class Car(color: Color)
  val cars = catsSeq.map(cat => Car(cat.color)).toSeq
}
