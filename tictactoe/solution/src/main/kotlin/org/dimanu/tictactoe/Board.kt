package org.dimanu.tictactoe

private const val MAX_SIZE = 9

class Board {
    private var tiles: MutableMap<Tile, Player> = mutableMapOf()

    fun isMarked(tile: Tile): Boolean = tiles.contains(tile)

    fun playOn(tile: Tile, player: Player) = player.also { tiles[tile] = it }

    fun tilesPlayedBy(player: Player): List<Tile> {
        return tiles.filterValues { it == player }.keys.toList()
    }

    fun isFull(): Boolean {
        return tiles.size == MAX_SIZE
    }
}