package org.dimanu.tictactoe

class Game {
    private var currentPlayer: Player = Player.PLAYER_X

    fun toPlay(): Player {
        return currentPlayer
    }

    fun play() {
        currentPlayer = currentPlayer.nextPlayertoPlay()
    }

}