package org.dimanu.tictactoe

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class GameShould {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @Test
    fun `wait for player X to play first`() {
        assertEquals(Player.PLAYER_X, game.toPlay())
    }

    @Test
    fun `wait for player O to play after player X`() {
        game.play(Tile.TOP_LEFT)

        assertEquals(Player.PLAYER_O, game.toPlay())
    }

    @Test
    fun `wait for player X to play after player O`() {
        game.play(Tile.TOP_LEFT)
        game.play(Tile.TOP_MIDDLE)

        assertEquals(Player.PLAYER_X, game.toPlay())
    }

    @Test
    fun `not allow players to play on already marked tiles`() {
        game.play(Tile.TOP_LEFT)
        game.play(Tile.TOP_LEFT)

        assertEquals(Player.PLAYER_O, game.toPlay())
    }
}