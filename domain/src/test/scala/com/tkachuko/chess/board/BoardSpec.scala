package com.tkachuko.chess.board

import com.tkachuko.chess.Location
import com.tkachuko.chess.figures._
import org.scalatest.{Matchers, WordSpec}

class BoardSpec extends WordSpec with Matchers {

  "Board" should {

    "have updated position of figures if figure can be put" in {

      val board = Board(2, 2)
      val figureLocation = Location(0, 0)
      val updatedBoard = board.put(Rook, figureLocation)

      updatedBoard.exists(_.figures.contains(figureLocation)) shouldBe true
    }

    "have updated free cells if figure can be put" in {

      val board = Board(2, 2)
      val figureLocation = Location(0, 0)
      val updatedBoard = board.put(King, figureLocation)

      updatedBoard.exists(_.freeCells.isEmpty) shouldBe true
    }

    "not update any values if figure cannot be put" in {

      val board = Board(2, 2)
      val figureLocation = Location(0, 0)
      val updatedBoard = board.put(King, figureLocation).flatMap(_.put(King, figureLocation))


      updatedBoard shouldBe None
    }
  }

}
