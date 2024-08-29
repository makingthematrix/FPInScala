package org.fpinscala

object FunctionsReturningFunctions {
  case class Cat(name: String, color: Color)

  val colors = Color.values.toSeq
  val catNames = Seq("Fluff", "Shadow", "Garfield")

  // a cat generator for the same name and random colors

  // a cat generator for the same color and random names
}
