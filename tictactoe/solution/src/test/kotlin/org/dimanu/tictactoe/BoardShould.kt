package org.dimanu.tictactoe

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class BoardShould {

    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board()
    }

    @Test
    fun `detect when a tile is marked`() {
        board.playOn(Tile.TOP_LEFT)

        assertTrue(board.isMarked(Tile.TOP_LEFT))
    }
}