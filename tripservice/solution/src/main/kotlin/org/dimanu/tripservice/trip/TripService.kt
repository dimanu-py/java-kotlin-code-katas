package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User
import org.dimanu.tripservice.user.UserSession

open class TripService {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        var loggedUser: User? = getLoggedUser()
        var isFriend: Boolean = false

        if (loggedUser != null) {
            for (friend in user.friends) {
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = getFriendsTrips(user)
            }
            return tripList
        } else {
            throw UserNotLoggedInException()
        }
    }

    protected open fun getFriendsTrips(user: User) = TripDAO.findTripsByUser(user)

    protected open fun getLoggedUser() = UserSession.instance.loggedUser
}