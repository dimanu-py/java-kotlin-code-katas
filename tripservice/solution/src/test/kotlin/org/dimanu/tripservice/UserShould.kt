package org.dimanu.tripservice

import org.junit.jupiter.api.Test

class UserShould {

    @Test
    fun `not have any trips when created`() {
        val user = UserMother.create()

        assert(user.trips.isEmpty())
    }

    @Test
    fun `not have any friends when created`() {
        val user = UserMother.create()

        assert(user.friends.isEmpty())
    }

    @Test
    fun `be able to add trips`() {
        val trip = TripMother.any()
        val user = UserMother.create(trips = listOf(trip))

        assert(user.trips.isNotEmpty())
        assert(user.trips.contains(trip))
    }

    @Test
    fun `be able to add friends`() {
        val friend = UserMother.create()
        val user = UserMother.create(friends = listOf(friend))

        assert(user.friends.isNotEmpty())
        assert(user.friends.contains(friend))
    }

    @Test
    fun `be able to know if user is not a friend`() {
        val user = UserMother.create()
        val friend = UserMother.create()

        assert(!user.isFriendWith(friend))
    }

    @Test
    fun `be able to know if user is a friend`() {
        val friend = UserMother.create()
        val user = UserMother.create(friends = listOf(friend))

        user.addFriend(friend)

        assert(user.isFriendWith(friend))
    }
}