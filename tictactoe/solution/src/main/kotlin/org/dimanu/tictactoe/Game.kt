package org.dimanu.tictactoe

class Game(private var board: Board) {
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
        val playerMarkedTiles = board.tilesPlayedBy(Player.PLAYER_X)
        val playerHasMarkedTopRow = playerMarkedTiles.containsAll(listOf(Tile.TOP_LEFT, Tile.TOP_RIGHT, Tile.TOP_MIDDLE))
        return playerHasMarkedTopRow
    }

    fun status(): GameStatus {
        return GameStatus(
            status = status,
            winner = winner
        )
    }

}