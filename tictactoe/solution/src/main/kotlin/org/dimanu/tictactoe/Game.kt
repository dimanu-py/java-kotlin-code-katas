package org.dimanu.tictactoe

class Game(private var board: Board, private var winningRules: WinningRules) {
    private var status: Status = Status.PLAYING
    private var winner: Player? = null
    private var currentPlayer: Player = Player.PLAYER_X

    fun toPlay(): Player {
        return currentPlayer
    }

    fun play(tileToPlay: Tile) {
        if (isIllegalPlay(tileToPlay)) {
            return
        }
        board.playOn(tileToPlay, currentPlayer)

        if (hasWon()) {
            status = Status.WIN
            winner = currentPlayer
            return
        }

        if (isADraw()) {
            status = Status.DRAW
            winner = null
            return
        }

        currentPlayer = currentPlayer.nextPlayerToPlay()

    }

    private fun isIllegalPlay(tileToPlay: Tile): Boolean = board.isMarked(tileToPlay)

    private fun hasWon(): Boolean {
        val currentPlayerMarkedTiles = board.tilesPlayedBy(currentPlayer)
        return winningRules.matches(currentPlayerMarkedTiles)
    }

    private fun isADraw(): Boolean = board.isFull()

    fun status(): GameStatus {
        return GameStatus(
            status = status,
            winner = winner
        )
    }

}