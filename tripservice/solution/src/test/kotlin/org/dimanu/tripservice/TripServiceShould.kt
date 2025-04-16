package org.dimanu.tripservice

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.trip.TripService
import org.dimanu.tripservice.user.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class TripServiceShould {

    @Test
    fun `not logged in user cannot interact with application`() {
        val tripService = TripService()
        val guestUser = User()

        assertThrows<UserNotLoggedInException> {
            tripService.getTripsByUser(guestUser)
        }
    }
}