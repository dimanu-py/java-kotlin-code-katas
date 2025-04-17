package org.dimanu.tictactoe

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardShould {

    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board()
    }

    @Test
    fun `detect when a tile is marked`() {
        board.playOn(Tile.TOP_LEFT, Player.PLAYER_X)

        assertTrue(board.isMarked(Tile.TOP_LEFT))
    }

    @Test
    fun `be able to know which player has marked a tile`() {
        board.playOn(Tile.TOP_LEFT, Player.PLAYER_X)

        val playedPositions: List<Tile> = board.tilesPlayedBy(Player.PLAYER_X)
        assertEquals(playedPositions, listOf(Tile.TOP_LEFT))
    }
}