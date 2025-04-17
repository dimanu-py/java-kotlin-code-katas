package org.dimanu.tictactoe

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
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

    @Test
    fun `detect board is full when all tiles are marked`() {
        board.playOn(Tile.TOP_LEFT, Player.PLAYER_X)
        board.playOn(Tile.TOP_MIDDLE, Player.PLAYER_O)
        board.playOn(Tile.TOP_RIGHT, Player.PLAYER_X)
        board.playOn(Tile.MIDDLE_LEFT, Player.PLAYER_O)
        board.playOn(Tile.MIDDLE_MIDDLE, Player.PLAYER_X)
        board.playOn(Tile.MIDDLE_RIGHT, Player.PLAYER_O)
        board.playOn(Tile.BOTTOM_LEFT, Player.PLAYER_X)
        board.playOn(Tile.BOTTOM_MIDDLE, Player.PLAYER_O)
        board.playOn(Tile.BOTTOM_RIGHT, Player.PLAYER_X)

        assertTrue(board.isFull())
    }

    @Test
    fun `detect board is not full if not all tiles are marked`() {
        board.playOn(Tile.TOP_LEFT, Player.PLAYER_X)
        board.playOn(Tile.TOP_MIDDLE, Player.PLAYER_O)
        board.playOn(Tile.TOP_RIGHT, Player.PLAYER_X)

        assertFalse(board.isFull())
    }
}