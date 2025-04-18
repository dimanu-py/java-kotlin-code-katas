package org.dimanu.tripservice

import org.dimanu.tripservice.trip.Trip
import org.dimanu.tripservice.user.User

object UserMother {

    fun create(trips: List<Trip> = emptyList(), friends: List<User> = emptyList()): User {
        val user = User()
        trips.forEach { user.addTrip(it) }
        friends.forEach { user.addFriend(it) }
        return user
    }

}