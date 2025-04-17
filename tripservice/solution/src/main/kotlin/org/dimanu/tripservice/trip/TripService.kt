package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User

open class TripService(private val tripRepository: TripRepository) {

    fun getTripsByUser(loggedUser: User?, requestedUser: User): List<Trip> {
        val loggedUser: User = loggedUser ?: throw UserNotLoggedInException()

        if (requestedUser.isFriendWith(loggedUser)) {
            return tripRepository.findTripsByUser(requestedUser)
        }
        return ArrayList<Trip>()
    }

}