package org.dimanu.tripservice

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.trip.TripService
import org.dimanu.tripservice.user.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SeamTripService(private val loggedUser: User?) : TripService() {

    override fun getLoggedUser(): User? {
        return loggedUser
    }
}


class TripServiceShould {

    private val guestUser = null
    private val anyUser = User()
    private var loggedUser: User? = null

    @Test
    fun `not logged in user cannot interact with application`() {
        loggedUser = guestUser
        val tripService = SeamTripService(loggedUser)

        assertThrows<UserNotLoggedInException> {
            tripService.getTripsByUser(anyUser)
        }
    }
}