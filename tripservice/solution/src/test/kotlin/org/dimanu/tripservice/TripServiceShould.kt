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
    private val applicationUser = User()
    private var loggedUser: User? = null

    @Test
    fun `not logged in user cannot interact with application`() {
        loggedUser = guestUser
        val tripService = SeamTripService(loggedUser)

        assertThrows<UserNotLoggedInException> {
            tripService.getTripsByUser(anyUser)
        }
    }

    @Test
    fun `user gets no trips when is not friend with logged user`() {
        loggedUser = applicationUser
        val tripService = SeamTripService(loggedUser)
        val stranger = User()

        val trips = tripService.getTripsByUser(stranger)

        assert(trips.isEmpty())
    }
}