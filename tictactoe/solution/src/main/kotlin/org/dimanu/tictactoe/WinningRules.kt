package org.dimanu.tictactoe

class WinningRules {
    private val winningRules: List<List<Tile>> = listOf(
        listOf(Tile.TOP_LEFT, Tile.TOP_RIGHT, Tile.TOP_MIDDLE),
        listOf(Tile.MIDDLE_LEFT, Tile.MIDDLE_MIDDLE, Tile.MIDDLE_RIGHT),
        listOf(Tile.BOTTOM_LEFT, Tile.BOTTOM_MIDDLE, Tile.BOTTOM_RIGHT),
        listOf(Tile.TOP_LEFT, Tile.MIDDLE_LEFT, Tile.BOTTOM_LEFT),
        listOf(Tile.TOP_MIDDLE, Tile.MIDDLE_MIDDLE, Tile.BOTTOM_MIDDLE),
        listOf(Tile.TOP_RIGHT, Tile.MIDDLE_RIGHT, Tile.BOTTOM_RIGHT),
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
