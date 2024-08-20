package org.makingthematrix.fpinscala

object XRay {

  // Type hints
  private val foo = 1 + 2            // Field
  Seq(1, 2, 3).map(x => x + 1)       // Lambda parameter
  Seq(1, 2, 3).map(_ + 1)            // Lambda placeholder
  private val (x, y) = (1, 2)        // Variable pattern
  val sum: Int = (foo, x, y) match { // Pattern matching
    case (a, b, c) => a + b + c
  }

  private val words = Seq("a", "sequence", "of", "words")

  words
    .view
    .map(_.length)
    .filter(_ > XRay.sum)
    .toSeq
    .distinct
    .headOption
    .getOrElse(0)

  // Implicit hints (conversions, arguments)
  "abc".take(2).sorted

  // By-name argument hints
  private def inReadAction[A](code: => A): A = code
  inReadAction(println("foo"))

  // Parameter name hints
  def parameter(enabled: Boolean): Unit =
    setParameterInDB(Map(("enabled", enabled)))

  parameter(true)
  parameter(false)

  private def setParameterInDB(map: Map[String, Boolean]): Unit =
    map.foreach {
      (name, b) => println(s"$name -> $b")
    }
}

