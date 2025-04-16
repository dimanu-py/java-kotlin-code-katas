package org.dimanu.tripservice

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.trip.Trip
import org.dimanu.tripservice.trip.TripService
import org.dimanu.tripservice.user.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SeamTripService(private val loggedUser: User?) : TripService() {

    override fun getLoggedUser(): User? {
        return loggedUser
    }

    override fun getFriendsTrips(user: User): List<Trip> {
        return user.trips
    }
}


class TripServiceShould {

    private val guestUser = null
    private val anyUser = User()
    private val applicationUser = User()
    private val canadaTrip = Trip()
    private var loggedUser: User? = null

    @Test
    fun `not logged in user cannot interact with application`() {
        this.loggedUser = guestUser
        val tripService = SeamTripService(loggedUser)

        assertThrows<UserNotLoggedInException> {
            tripService.getTripsByUser(anyUser)
        }
    }

    @Test
    fun `user gets no trips when is not friend with logged user`() {
        this.loggedUser = applicationUser
        val tripService = SeamTripService(loggedUser)
        val stranger = User()

        val trips = tripService.getTripsByUser(stranger)

        assert(trips.isEmpty())
    }

    @Test
    fun `user gets its friends trips`() {
        this.loggedUser = applicationUser
        val tripService = SeamTripService(loggedUser)
        val friend = User()
        friend.addFriend(loggedUser!!)
        friend.addTrip(canadaTrip)

        val trips = tripService.getTripsByUser(friend)

        assert(trips.isNotEmpty())
        assert(trips.contains(canadaTrip))
    }
}