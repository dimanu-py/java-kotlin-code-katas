package org.dimanu.tictactoe

class Game(private var board: Board, private var winningRules: WinningRules) {
    private var currentPlayer: Player = Player.PLAYER_X
    private var status: GameStatus = GameStatus.Playing(currentPlayer)

    fun play(tileToPlay: Tile) {
        if (isIllegalPlay(tileToPlay)) return
        board.playOn(tileToPlay, currentPlayer)

        status = when {
            hasWon() -> GameStatus.Win(currentPlayer)
            isADraw() -> GameStatus.Draw
            else -> {
                currentPlayer = currentPlayer.nextPlayerToPlay()
                GameStatus.Playing(currentPlayer)
            }
        }
    }

    private fun isIllegalPlay(tileToPlay: Tile): Boolean = board.isMarked(tileToPlay)

    private fun hasWon(): Boolean {
        val currentPlayerMarkedTiles = board.tilesPlayedBy(currentPlayer)
        return winningRules.matches(currentPlayerMarkedTiles)
    }

    private fun isADraw(): Boolean = board.isFull()

    fun status(): GameStatus = status

}