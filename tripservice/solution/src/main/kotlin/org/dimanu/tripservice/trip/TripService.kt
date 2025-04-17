package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User

open class TripService(private val loggedUser: User? = null, private val tripRepository: TripRepository) {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User = loggedUser ?: throw UserNotLoggedInException()

        if (user.isFriendWith(loggedUser)) {
            tripList = tripRepository.findTripsByUser(user)
        }
        return tripList
    }

}