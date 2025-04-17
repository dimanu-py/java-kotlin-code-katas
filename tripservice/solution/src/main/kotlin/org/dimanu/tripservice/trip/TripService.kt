package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User

open class TripService(private val tripRepository: TripRepository) {

    private val noTrips: List<Trip> = emptyList()

    fun getTripsByUser(loggedUser: User?, requestedUser: User): List<Trip> {
        verifyUserIsLoggedIn(loggedUser)

        if (requestedUser.isFriendWith(loggedUser!!)) {
            return tripRepository.findTripsByUser(requestedUser)
        }
        return noTrips
    }

    private fun verifyUserIsLoggedIn(user: User?) {
        if (user == null) {
            throw UserNotLoggedInException()
        }
    }

}