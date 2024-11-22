package org.fpinscala

import cats.effect.{IO, IOApp}
import cats.syntax.all.*

import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.*

// 13.2

object CatsEffectVersion extends IOApp.Simple {
  override def run: IO[Unit] = ???

  private def read(path: Path): IO[List[String]] = ???

  private val askForUpdate: IO[Int] = ???

  private def updateAge(user: UserData, n: Int): IO[UserData] = ???

  private def write(path: Path, lines: List[String]): IO[Unit] = ???
}
