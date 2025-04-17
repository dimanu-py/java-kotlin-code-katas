package org.dimanu.tictactoe

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class GameShould {

    private lateinit var game: Game
    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board()
        game = Game(board)
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

    @Test
    fun `not declare a winner if no player has score three consecutive tiles`() {
        game.play(Tile.TOP_LEFT)
        game.play(Tile.TOP_MIDDLE)
        game.play(Tile.BOTTOM_LEFT)
        game.play(Tile.BOTTOM_MIDDLE)

        val expectedStatus = GameStatus(
            status=Status.PLAYING,
            winner=null,
        )
        assertEquals(expectedStatus, game.status())
    }

    @Test
    fun `declare player X as winner if he scores three consecutive tiles in a row`() {
        game.play(Tile.TOP_LEFT)
        game.play(Tile.MIDDLE_LEFT)
        game.play(Tile.TOP_MIDDLE)
        game.play(Tile.BOTTOM_MIDDLE)
        game.play(Tile.TOP_RIGHT)

        val expectedStatus = GameStatus(
            status=Status.WIN,
            winner=Player.PLAYER_X,
        )
        assertEquals(expectedStatus, game.status())
    }
}