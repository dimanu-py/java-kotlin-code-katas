package org.dimanu.tictactoe

class Board {
    private var tiles: MutableList<Tile> = mutableListOf()

    fun isMarked(tile: Tile): Boolean = tiles.contains(tile)

    fun playOn(tile: Tile) = tiles.add(tile)
}