package org.dimanu.tripservice.trip

import org.dimanu.tripservice.user.User

interface TripRepository {
    fun findTripsByUser(user: User): List<Trip>
}