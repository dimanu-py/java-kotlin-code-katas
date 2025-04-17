package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User

open class TripService(private val tripRepository: TripRepository) {

    fun getTripsByUser(loggedUser: User?, requestedUser: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User = loggedUser ?: throw UserNotLoggedInException()

        if (requestedUser.isFriendWith(loggedUser)) {
            tripList = tripRepository.findTripsByUser(requestedUser)
        }
        return tripList
    }

}