package org.makingthematrix.fpinscala

import scala.util.Random

object FunctionsReturningFunctions {
  case class Cat(name: String, color: Color)

  import Color.*

  val colors = Color.values.toSeq
  val catNames = Seq("Fluff", "Shadow", "Garfield")

  def catGenerator(name: String): () => Cat = {
    val color = colors(Random.nextInt(colors.size))
    () => Cat(name, color)
  }

  def catGenerator(color: Color): () => Cat = {
    val name = catNames(Random.nextInt(catNames.size))
    () => Cat(name, color)
  }

  val gen1 = catGenerator("Fluff")
  val gen2 = catGenerator(Black)

/*  @main def main(): Unit = {
    println(gen1())
    println(gen2())
  }*/
}
