package org.dimanu.tictactoe

sealed interface GameStatus {
    data object Playing: GameStatus
    data object Draw: GameStatus
    data class Win(val winner: Player): GameStatus
}