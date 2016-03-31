package net.team2xh.deltav
package core

import scala.io._

import java.io._

import com.typesafe.scalalogging.LazyLogging

import org.eclipse.jgit.api._
import org.eclipse.jgit.lib._
import org.eclipse.jgit.util._



object Repository extends LazyLogging {
  def init(path: File): Repository = {
    val gitDirectory = new File(path, ".git")

    if (RepositoryCache.FileKey.isGitRepository(gitDirectory, FS.DETECTED)) {
      logger.debug("CKAN-meta Git repository detected")
      logger.debug("Pulling master...")
      val git = Git.open(gitDirectory)
      val pull = git.pull.call()
      if (pull.isSuccessful)
        logger.debug(s"Pull successful!")
      else {
        logger.error("Error during pull:")
        logger.error(pull.toString)
      }
    } else {
      logger.debug("Cloning CKAN-meta repository...")
      val clone = Git.cloneRepository()
      clone.setURI("https://github.com/KSP-CKAN/CKAN-meta.git")
      clone.setDirectory(path)
      clone.call()
    }

    new Repository(path)
  }
}

class Repository(path: File) {
  def modules: Seq[Module] = {
    path.listFiles
      .toSeq
      .filter(_.isDirectory)
      .flatMap(_.listFiles)
      .filter(_.getName.endsWith(".ckan"))
      .map(moduleFile => Module(Source.fromFile(moduleFile).mkString))
  }

}
