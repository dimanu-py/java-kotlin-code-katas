package org.dimanu.tictactoe

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class WinningRulesShould {

    @Test
    fun `detect horizontal rows wins`() {
        val winningRules = WinningRules()
        val markedTiles = listOf(Tile.TOP_LEFT, Tile.TOP_MIDDLE, Tile.TOP_RIGHT)

        assertTrue(winningRules.matches(markedTiles))

    }
}