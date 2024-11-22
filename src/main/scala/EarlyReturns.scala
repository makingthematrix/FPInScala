package org.fpinscala

// 8

object EarlyReturns {
  import UserData.database

  // complex conversion

  // complex validation

  // userIds from 1 to 11
  
  private val userIds: Seq[UserId] = 1 to 11


  /**
   * Imperative approach that uses unidiomatic `return`.
   */
  object Imperative {
    // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  /**
   * Naive functional approach: calls `complexConversion` twice on the selected ID.
   */
  object Naive {
    // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  /**
   * A more concise implementation, which uses `collectFirst`.
   */
  object CollectFirst {
    // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  /**
   * The custom `unapply` method runs conversion and validation and only returns valid user data.
   */
  object CustomUnapply {
    object ValidUser {
      // def unapply(userId: UserId): Option[UserData] =
    }

   // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  // safeComplexConversion

  /**
   * Partiality of `safeComplexConversion` trickles into the search function.
   */
  object SafeImperative {
    // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  /**
   * This custom `unapply` method performs the safe conversion and then validation.
   */
  object SafeCollectFirst {
    object ValidUser {
      // def unapply(userId: UserId): Option[UserData] =
    }

    // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  // what if our user can be valid in more than one way?
  object MoreThanOneValidation {
    object ValidUser {
      //def unapply(userId: UserId): Option[UserData] =
    }

    object ValidUserInADifferentWay {
      def otherValidation(userData: UserData): Boolean = false
      //def unapply(userId: UserId): Option[UserData] =
    }

    // def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }

  // Can we abstract away the common parts?
  object Deconstruct {
  }

  // Let's do the same thing but with a lazy collection (an iterator)
  object LazyCollection {
    //def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }


  // last but not least: breaking/boundary
  object BreakingBoundary {
    import scala.util.boundary
    import scala.util.boundary.break
    //def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
  }
}
