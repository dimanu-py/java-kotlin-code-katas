package org.dimanu.tictactoe

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertTrue

class WinningRulesShould {

    @ParameterizedTest
    @MethodSource("horizontalWinningRules")
    fun `detect horizontal rows wins`(markedTiles: List<Tile>) {
        val winningRules = WinningRules()

        assertTrue(winningRules.matches(markedTiles))

    }

    companion object {
        @JvmStatic
        fun horizontalWinningRules() = listOf(
            listOf(Tile.TOP_LEFT, Tile.TOP_MIDDLE, Tile.TOP_RIGHT),
            listOf(Tile.MIDDLE_LEFT, Tile.MIDDLE_MIDDLE, Tile.MIDDLE_RIGHT),
        )
    }
}