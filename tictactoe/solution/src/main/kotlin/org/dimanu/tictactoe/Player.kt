package org.dimanu.tictactoe

enum class Player {
    PLAYER_X,
    PLAYER_O;

    fun nextPlayerToPlay() = if (this == PLAYER_X) PLAYER_O else PLAYER_X
}