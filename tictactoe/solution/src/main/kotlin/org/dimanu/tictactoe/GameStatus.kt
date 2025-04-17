package org.dimanu.tictactoe

sealed interface GameStatus {
    data class Playing(val playerToPlay: Player): GameStatus
    data object Draw: GameStatus
    data class Win(val winner: Player): GameStatus
}