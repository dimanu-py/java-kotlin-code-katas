package org.dimanu.tictactoe

class Game {
    private val tiles: MutableList<Tile> = mutableListOf()
    private var currentPlayer: Player = Player.PLAYER_X

    fun toPlay(): Player {
        return currentPlayer
    }

    fun play(tileToPlay: Tile) {
        if (tiles.contains(tileToPlay)) {
            return
        }
        tiles.add(tileToPlay)
        currentPlayer = currentPlayer.nextPlayertoPlay()
    }

}