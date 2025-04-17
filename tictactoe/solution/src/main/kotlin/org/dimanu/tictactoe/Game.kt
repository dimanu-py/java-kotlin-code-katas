package org.dimanu.tictactoe

class Game(private var board: Board, private var winningRules: WinningRules) {
    private var status: Status = Status.PLAYING
    private var winner: Player? = null
    private var currentPlayer: Player = Player.PLAYER_X

    fun toPlay(): Player {
        return currentPlayer
    }

    fun play(tileToPlay: Tile) {
        if (board.isMarked(tileToPlay)) {
            return
        }
        board.playOn(tileToPlay, currentPlayer)

        if (hasWon()) {
            status = Status.WIN
            winner = currentPlayer
        }

        currentPlayer = currentPlayer.nextPlayerToPlay()

    }

    private fun hasWon(): Boolean {
        val currentPlayerMarkedTiles = board.tilesPlayedBy(currentPlayer)
        return winningRules.matches(currentPlayerMarkedTiles)
    }

    fun status(): GameStatus {
        return GameStatus(
            status = status,
            winner = winner
        )
    }

}