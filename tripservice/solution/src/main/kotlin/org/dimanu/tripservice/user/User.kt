package org.dimanu.tripservice.user

import org.dimanu.tripservice.trip.Trip

class User {
    private val _trips: MutableList<Trip> = ArrayList()
    val trips: List<Trip>
        get() = _trips

    private val _friends: MutableList<User> = ArrayList()
    val friends: List<User>
        get() = _friends

    fun addFriend(user: User) {
        _friends.add(user)
    }

    fun addTrip(trip: Trip) {
        _trips.add(trip)
    }

    fun isFriendWith(user: User): Boolean {
        return _friends.contains(user)
    }
}