package org.dimanu.tictactoe

import kotlin.test.Test
import kotlin.test.assertEquals

class GameShould {

    @Test
    fun `wait for player X to play first`() {
        val game = Game()

        assertEquals(Player.PLAYER_X, game.toPlay())
    }
}