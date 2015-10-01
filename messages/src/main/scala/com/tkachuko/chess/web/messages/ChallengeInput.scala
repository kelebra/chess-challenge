package com.tkachuko.chess.web.messages

import com.tkachuko.chess.figures.ChessFigure

case class ChallengeInput(height: Int, width: Int, figures: List[ChessFigure])
