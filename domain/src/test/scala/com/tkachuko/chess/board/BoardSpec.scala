package com.tkachuko.chess.board

import com.tkachuko.chess.Location
import com.tkachuko.chess.figures.Rook
import org.scalatest.{Matchers, WordSpec}

class BoardSpec extends WordSpec with Matchers {

  "Board" should {

    "be updated in case if cell is empty" in {

      val board = Board(2, 2)
      board.put(Rook, Location(0, 0))

      val cellFigure = board.cells(0)(0)
      cellFigure shouldBe 'defined
      cellFigure shouldBe Some(Rook)
    }

    "not be updated if cell is not empty" in {

      val board = Board(2, 2)
      board.put(Rook, Location(0, 0))
      intercept[IllegalStateException] {
        board.put(Rook, Location(0, 0))
      }
    }
  }

}
