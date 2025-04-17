package org.dimanu.tictactoe

class Game {
    private var currentPlayer: Player = Player.PLAYER_X

    fun toPlay(): Player {
        return currentPlayer
    }

    fun play() {
        currentPlayer = alternatePlayers()
    }

    private fun alternatePlayers() = if (currentPlayer == Player.PLAYER_X) Player.PLAYER_O else Player.PLAYER_X
}