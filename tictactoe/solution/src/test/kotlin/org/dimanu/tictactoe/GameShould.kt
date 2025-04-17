package org.dimanu.tictactoe

import kotlin.test.Test
import kotlin.test.assertEquals

class GameShould {

    @Test
    fun `wait for player X to play first`() {
        val game = Game()

        assertEquals(Player.PLAYER_X, game.toPlay())
    }

    @Test
    fun `wait for player O to play after player X`() {
        val game = Game()

        game.play()

        assertEquals(Player.PLAYER_O, game.toPlay())
    }

    @Test
    fun `wait for player X to play after player O`() {
        val game = Game()

        game.play()
        game.play()

        assertEquals(Player.PLAYER_X, game.toPlay())
    }
}