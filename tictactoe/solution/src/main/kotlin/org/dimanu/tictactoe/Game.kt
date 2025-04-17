package org.dimanu.tictactoe

class Game(private var board: Board) {
    private var currentPlayer: Player = Player.PLAYER_X

    fun toPlay(): Player {
        return currentPlayer
    }

    fun play(tileToPlay: Tile) {
        if (board.isMarked(tileToPlay)) {
            return
        }
        board.playOn(tileToPlay, currentPlayer)
        currentPlayer = currentPlayer.nextPlayertoPlay()
    }

    fun status(): GameStatus {
        return GameStatus(
            status = Status.PLAYING,
            winner = null
        )
    }

}