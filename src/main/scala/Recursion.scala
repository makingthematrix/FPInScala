package org.fpinscala

// 10

import scala.annotation.tailrec
import scala.util.control.TailCalls.*

object Recursion {
  /*
  factorial(3)
  3 * factorial(2)
  3 * 2 * factorial(1)
  3 * 2 * 1 * factorial(0)
  3 * 2 * 1 * 1
  3 * 2 * 1
  3 * 2
  6
   */

  def factorial(n: Int): BigInt = ???

  def tailFactorial(n: Int): BigInt = ???


  // 1 -> 1, 2 -> 1, 3 -> 2, 4 -> 3, 5 -> 5, 6 -> 8

  def fibonacci(n: Int): BigInt = ???

  def trampolineFibonacci(n: Int): BigInt = ???

  private val fib: LazyList[BigInt] = ???
  def fibonacciLazyList(n: Int): BigInt = ???
}