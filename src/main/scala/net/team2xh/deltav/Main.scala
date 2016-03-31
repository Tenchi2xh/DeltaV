package net.team2xh
package deltav

import scalafx.application._
import scalafx.application.JFXApp._
import scalafx.geometry._
import scalafx.scene._
import scalafx.scene.control._
import scalafx.scene.layout._

object Main extends JFXApp {
  stage = new PrimaryStage {
    title.value = "DeltaV"
    scene = new Scene {
      root = new BorderPane {
        padding = Insets(25)
        center = new Label("Hello SBT")
      }
    }
  }
}
