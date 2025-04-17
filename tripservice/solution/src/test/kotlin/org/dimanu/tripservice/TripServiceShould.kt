package org.dimanu.tripservice

import io.mockk.every
import io.mockk.mockk
import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.trip.TripRepository
import org.dimanu.tripservice.trip.TripService
import org.dimanu.tripservice.user.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class TripServiceShould {

    private val tripRepository = mockk<TripRepository>()

    private val guestUser = null
    private val anyUser = UserMother.any()
    private val applicationUser = UserMother.any()
    private val canadaTrip = TripMother.any()
    private var loggedUser: User? = null

    @Test
    fun `not logged in user cannot interact with application`() {
        this.loggedUser = guestUser
        val tripService = TripService(tripRepository)

        assertThrows<UserNotLoggedInException> {
            tripService.getTripsByUser(loggedUser, anyUser)
        }
    }

    @Test
    fun `user gets no trips when is not friend with logged user`() {
        this.loggedUser = applicationUser
        val tripService = TripService(tripRepository)
        val stranger = UserMother.any()

        val trips = tripService.getTripsByUser(loggedUser, stranger)

        assert(trips.isEmpty())
    }

    @Test
    fun `user gets its friends trips`() {
        this.loggedUser = applicationUser
        val tripService = TripService(tripRepository)
        val friend = UserMother.withFriendsAndTrips(friends = listOf(loggedUser!!), trips = listOf(canadaTrip))
        every { tripRepository.findTripsByUser(any()) } returns listOf(canadaTrip)

        val trips = tripService.getTripsByUser(loggedUser, friend)

        assert(trips.isNotEmpty())
        assert(trips.contains(canadaTrip))
    }
}