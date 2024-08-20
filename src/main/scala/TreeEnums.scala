package org.makingthematrix.fpinscala

import scala.annotation.tailrec

object TreeEnums {
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
   // print(newTree, _.toString)
  }*/

}
