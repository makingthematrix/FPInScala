package org.fpinscala

import scala.io.StdIn.readLine

// 12

object OptionEitherTry {
  import UserData.{database, parents}

  object WithExceptions {
    def findParent(name: String): UserData = ???
  }

  object WithOption {
    def findParent(name: String): Option[UserData] = ??? // flatMap

    def findParent2(name: String): Option[UserData] = ??? // for-yield
  }

  object WithEither {
    def findParent(name: String): Either[String, UserData] = ??? //flatMap

    def findParent2(name: String): Either[String, UserData] = ??? //flatMap
  }

/*  @main def main(): Unit = {
    val name = read()
    println(s"name: $name")

    // exception

    // Option


    // Either

    // Try (wrap the exception)

  }*/
  
  // try out with:
  // John Doe (-> Michael Brown),
  // Maciek (-> not in the database),
  // Jane Smith (-> parent not in the database),
  // Emily Johnson (-> invalid parent id)

  private def read(): String = {
    printf("\n> ")
    readLine().trim
  }
}
