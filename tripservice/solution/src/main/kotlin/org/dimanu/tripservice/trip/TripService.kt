package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User
import org.dimanu.tripservice.user.UserSession

open class TripService {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User = getLoggedUser() ?: throw UserNotLoggedInException()

        if (user.isFriendWith(loggedUser)) {
            tripList = getFriendsTrips(user)
        }
        return tripList
    }

    protected open fun getFriendsTrips(user: User) = TripDAO.findTripsByUser(user)

    protected open fun getLoggedUser() = UserSession.instance.loggedUser
}