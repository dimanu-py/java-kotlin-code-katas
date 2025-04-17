package org.dimanu.tictactoe

class Board {
    private var tiles: MutableMap<Tile, Player> = mutableMapOf()

    fun isMarked(tile: Tile): Boolean = tiles.contains(tile)

    fun playOn(tile: Tile, player: Player) = player.also { tiles[tile] = it }

    fun tilesPlayedBy(player: Player): List<Tile> {
        return tiles.filterValues { it == player }.keys.toList()
    }
}