package org.dimanu.tripservice

import org.dimanu.tripservice.trip.Trip
import org.dimanu.tripservice.user.User

class UserMother {

    companion object {
        fun any(): User {
            return User()
        }

        fun withTrips(trips: List<Trip>): User {
            val user = User()
            trips.forEach { user.addTrip(it) }
            return user
        }

        fun withFriends(friends: List<User>): User {
            val user = User()
            friends.forEach { user.addFriend(it) }
            return user
        }

        fun withFriendsAndTrips(friends: List<User>, trips: List<Trip>): User {
            val user = User()
            friends.forEach { user.addFriend(it) }
            trips.forEach { user.addTrip(it) }
            return user
        }
    }
}