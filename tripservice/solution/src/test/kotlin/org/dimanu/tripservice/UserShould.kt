package org.dimanu.tripservice

import org.junit.jupiter.api.Test

class UserShould {

    @Test
    fun `not have any trips when created`() {
        val user = UserMother.any()

        assert(user.trips.isEmpty())
    }

    @Test
    fun `not have any friends when created`() {
        val user = UserMother.any()

        assert(user.friends.isEmpty())
    }

    @Test
    fun `be able to add trips`() {
        val user = UserMother.any()
        val trip = TripMother.any()

        user.addTrip(trip)

        assert(user.trips.isNotEmpty())
        assert(user.trips.contains(trip))
    }

    @Test
    fun `be able to add friends`() {
        val user = UserMother.any()
        val friend = UserMother.any()

        user.addFriend(friend)

        assert(user.friends.isNotEmpty())
        assert(user.friends.contains(friend))
    }
}