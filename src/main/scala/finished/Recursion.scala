package org.fpinscala.finished

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
