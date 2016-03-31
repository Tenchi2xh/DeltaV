package net.team2xh.deltav
package core

import java.io._

import com.typesafe.config._
import com.typesafe.scalalogging._

object Storage extends LazyLogging {
  private val storageDirectory = new File(System.getProperty("user.home"), ".deltav")
  private val repositoryDirectory = new File(storageDirectory, "repository")
  private val configFile = new File(storageDirectory, "deltav.conf")

  if (!storageDirectory.exists) {
    storageDirectory.mkdir()
  }
  if (!repositoryDirectory.exists) {
    repositoryDirectory.mkdir()
  }
  if (!configFile.exists) {
    configFile.createNewFile()
  }

  logger.debug(s"Reading configuration file from user settings... (${configFile.getPath})")
  val config = ConfigFactory.parseFile(configFile)
  logger.debug(s"Initializing local repository... (${repositoryDirectory.getPath})")
  val repository = Repository.init(repositoryDirectory)

  def main (args: Array[String]): Unit = {
    println(repository.modules.head.raw)
  }
}
