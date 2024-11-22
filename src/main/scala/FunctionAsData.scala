package org.fpinscala

// 1

object FunctionAsData {
  class User(val name: String, val email: String)

  // Let's create a sequence of three users 

  // A function which checks if the user's email is valid

  // Pass the appropriate function into `filter` to create a sequence of users with valid emails.

  // The whole "User => Boolean" is the type of the function

  // We can use it instead of the method version in `filter`

  // or we can use an anonymous function - also called lambdas

  // Lambdas, just as all functions, can take a value from its scope
  private val alwaysValidName = "Maciek"

  // @main def main(): Unit =
}
