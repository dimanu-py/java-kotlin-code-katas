package org.dimanu.tictactoe

class WinningRules {
    private val winningRules: List<List<Tile>> = listOf(
        listOf(Tile.TOP_LEFT, Tile.TOP_RIGHT, Tile.TOP_MIDDLE),
    )

    fun matches(markedTiles: List<Tile>): Boolean {
        for (rule in winningRules) {
            if (markedTiles.containsAll(rule)){
                return true
            }
        }
        return false
    }
}
