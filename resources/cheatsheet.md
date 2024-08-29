### Part #1 - Introduction

1. Title, logo, introduce yourself
2. Agenda: Introduce main FP concepts, implement examples with Scala, showcase Scala plugin
3. Why FP? Discuss how FP concepts help each other
4. Why Scala? Discuss how the user can start with imperative code and move towards FP gradually, what is JVM, and how other programming languages compare to Scala
5. Why Scala Plugin? Discuss what is an IDE, what is the position of IntelliJ IDEA on the market, how Scala Plugin supports Scala. 
6. Learning materials: Talk about the Academy plugin, the interactive course, IntelliJ Scala Bundle + onboarding tips, and the most popular places in the internet to learn Scala (also the main Scala webpage)

### Part #2 - Functions as Data

Showcase: type inference, "Can Be Private" inspection, "Unused Element" inspection, enums import, method names suggestion (for collections), "remove expression" action for unused elements, match/case code completion (in fizzBuzz). Inlay hints and X-Ray.

Ctrl + Shift + Enter -> Complete current statement

Option + Shift + Space -> Type-Matching

1. What is a function
2. Anonymous functions
3. Passing functions as arguments
4. Case class

```scala
object FunctionAsData {
  class Cat(val color: Color)

  // We create our bag (a set) of cats. Each cat has a different color.
  // Note the highlighting and suggestions
  val bagOfCats = Set(Cat(Color.White), Cat(Color.Ginger), Cat(Color.Black))

  // A function which checks if a cat is white go ginger, the `def` syntax
  def isCatWhiteOrGinger(cat: Cat): Boolean = cat.color == Color.White || cat.color == Color.Ginger

  // Pass the appropriate function into `filter` to create a bag of white cats.
  val bagOfWhiteOrGingerCats = bagOfCats.filter(isCatWhiteOrGinger)

  // The whole "Cat => Boolean" is the type of the function

  val isCatWhiteOrGingerFun: Cat => Boolean =
    cat => cat.color == Color.White || cat.color == Color.Ginger

  // We can use it instead of the method version in `filter`
  val bagOfWhiteOrGingerCatsFun = bagOfCats.filter(isCatWhiteOrGingerFun)

  // or we can use an anonymous function - also called lambdas
  val bagOfWhiteOrGingerCatsAnon = bagOfCats.filter(cat => cat.color == Color.White || cat.color == Color.Ginger)

  // Lambdas, just as all functions, can take a value from its scope
  private val color = Color.White
  val numberOfColorCats = bagOfCats.filter(_.color == color)
}
```



Scala collections: filter, find, foreach, map, flatMap

```scala
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
```

FlatMap

```scala
object CollectionsFlatMap {
  case class Cat(name: String, color: Color)

  import Color.*

  val felix = Cat("Felix", Black)
  val shadow = Cat("Shadow", Black)
  val snowball = Cat("Snowball", White)
  val garfield = Cat("Garfield", Ginger)

  // We put them all in a list
  val cats = Seq(felix, shadow, snowball, garfield)

  case class Car(brand: CarBrand, color: Color)

  import CarBrand.*
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
```



X-Ray



Total and partial functions (and traits)

```scala
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
 
}
```



Functions returning functions

```scala
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
```



### Part #3 - The type system and recursion

Showcase the debugger, enum suggestions, enum imports, match/case exhaustive, the recursion icon, "the recursive call requires the return type", "cannot rewrite recursive call in tail position".

1. Enums
2. Traits hierarchies, case objects
3. Unapply
4. Recursion
5. tailrec

Follow with using/given in Part #7.

```scala
import scala.annotation.tailrec

object Recursion {
  def factorial(n: BigInt): BigInt =
    if (n <= 0) 1
    else n * factorial(n - 1)

  /*
  ```scala
  factorial(3)
  3 * factorial(2)
  3 * 2 * factorial(1)
  3 * 2 * 1 * factorial(0)
  3 * 2 * 1 * 1
  3 * 2 * 1
  3 * 2
  6
  ```
   */

  def tailFactorial(n: Int): BigInt = {
    @tailrec
    def go(n: Int, accumulator: BigInt): BigInt =
      if (n <= 0) accumulator
      else go(n - 1, n * accumulator)

    go(n, 1)
  }

  def fibonacci(n: Int): BigInt =
    if (n == 0) 0
    else if (n == 1) 1
    else fibonacci(n - 2) + fibonacci(n - 1)

  def tailFibonacci(n: Int): BigInt = {
    @tailrec
    def go(currentN: Int, currentSum: BigInt, previousSum: BigInt): BigInt = {
      if (currentN < 0) -1
      else if (currentN == 0) previousSum
      else go(currentN - 1, currentSum + previousSum, currentSum)
    }

    go(n, 1, 1)
  }

  private val fib: LazyList[BigInt] =
    BigInt(0) #::
      BigInt(1) #::
      fib.zip(fib.tail).map { case (a, b) => a + b }

  def fibonacciLazyList(n: Int): BigInt = fib.take(n).last

/*  @main def main(): Unit = {
    //val res = factorial(10000)
    //val res = fibonacci(40)
    val res = fibonacciLazyList(80)
    println(res)
  }*/
}
```



Tree Enum

```scala
object Enums {
  enum Tree[+T] { // The + in +T is here because of covariance. 
    case Branch(left: Tree[T], value: T, right: Tree[T])
    case Leaf(value: T)
    case Stump
  }

  import Tree.*

  /*
      3
     / \
    2   5
   /   / \
  1   4   6
  */

  val intTree: Tree[Int] =
    Branch(
      Branch(Leaf(1), 2, Stump),
      3,
      Branch(Leaf(4), 5, Leaf(6))
    )
  
  //@tailrec
  def print[T](tree: Tree[T], toString: T => String, level: Int = 0): Unit = {
    val prefix = Seq.fill(level)('-').mkString
    tree match { // show match exhaustive!
      case Branch(left, value, right) =>
        println(s"$prefix${toString(value)}")
        print(left, toString, level + 1)
        print(right, toString, level + 1)
      case Leaf(value) =>
        println(s"$prefix${toString(value)}")
      case Stump =>
        println(s"${prefix}X")
    }
  }

  def add[T](tree: Tree[T], t: T, compare: (T, T) => Int): Tree[T] = tree match {
    case Branch(left, value, right) if compare(t, value) < 0 =>
      val newLeft = add(left, t, compare)
      Branch(newLeft, value, right)
    case Branch(left, value, right) if compare(t, value) > 0 =>
      val newRight = add(right, t, compare)
      Branch(left, value, newRight)
    case branch@Branch(_, _, _) =>
      branch // no changes
    case Leaf(value) if compare(t, value) < 0 =>
      Branch(Leaf(t), value, Stump)
    case Leaf(value) if compare(t, value) > 0 =>
      Branch(Stump, value, Leaf(t))
    case leaf@Leaf(_) =>
      leaf // no changes
    case Tree.Stump =>
      Leaf(t)
  }

  def add[T](tree: Tree[T], values: Seq[T], compare: (T, T) => Int): Tree[T] =
    values.foldLeft[Tree[T]](tree) { (tree, t) => add(tree, t, compare) }

  def create[T](values: Seq[T], compare: (T, T) => Int): Tree[T] = add(Stump, values, compare)

/*  @main def main(): Unit = {
    //print(intTree, _.toString)
    val compare = (a: Int, b: Int) => a - b
    val newTree: Tree[Int] =
      Seq(10, 5, 15, 2, 8)
        .foldLeft[Tree[Int]](Stump) { (tree, t) => add(tree, t, compare) }
   // val newTree = create(Seq(10, 5, 15, 2, 8), compare)
    print(newTree, (n: Int) => n.toString)
  }*/

}

```



Tree traits

```scala
package org.fpinscala.finished

object Traits {
  sealed trait Tree[+T]
  case class Branch[T](left: Tree[T], value: T, right: Tree[T]) extends Tree[T]
  case class Leaf[T](value: T) extends Tree[T]
  case object Stump extends Tree[Nothing]

  /*
      3
     / \
    2   5
   /   / \
  1   4   6
  */

  val intTree: Tree[Int] =
    Branch(
      Branch(Leaf(1), 2, Stump),
      3,
      Branch(Leaf(4), 5, Leaf(6))
    )

  // print out the tree
  def print[T](tree: Tree[T], toString: T => String, level: Int = 0): Unit = {
    val prefix = Seq.fill(level)('-').mkString
    tree match { // show match exhaustive!
      case Branch(left, value, right) =>
        println(s"$prefix${toString(value)}")
        print(left, toString, level + 1)
        print(right, toString, level + 1)
      case Leaf(value) =>
        println(s"$prefix${toString(value)}")
      case Stump =>
        println(s"${prefix}X")
    }
  }

  def add[T](tree: Tree[T], t: T, compare: (T, T) => Int): Tree[T] = tree match {
    case Branch(left, value, right) if compare(t, value) < 0 =>
      val newLeft = add(left, t, compare)
      Branch(newLeft, value, right)
    case Branch(left, value, right) if compare(t, value) > 0 =>
      val newRight = add(right, t, compare)
      Branch(left, value, newRight)
    case branch@Branch(_, _, _) =>
      branch // no changes
    case Leaf(value) if compare(t, value) < 0 =>
      Branch(Leaf(t), value, Stump)
    case Leaf(value) if compare(t, value) > 0 =>
      Branch(Stump, value, Leaf(t))
    case leaf@Leaf(_) =>
      leaf // no changes
    case _ =>
      Leaf(t)
  }

  def add[T](tree: Tree[T], values: Seq[T], compare: (T, T) => Int): Tree[T] =
    values.foldLeft[Tree[T]](tree) { (tree, t) => add(tree, t, compare) }

  def create[T](values: Seq[T], compare: (T, T) => Int): Tree[T] = add(Stump, values, compare)

/*  @main def main(): Unit = {
    val compare = (a: Int, b: Int) => a - b
    val toString = (n: Int) => n.toString
    print(intTree, toString)
    val newTree = create(Seq(10, 5, 15, 2, 8), compare)
    print(newTree, toString)
  }*/
}

```



### 