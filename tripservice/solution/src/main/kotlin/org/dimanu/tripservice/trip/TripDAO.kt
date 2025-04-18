package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.CollaboratorCallException
import org.dimanu.tripservice.user.User

class TripDAO : TripRepository {
    override fun findTripsByUser(user: User): List<Trip> {
            throw CollaboratorCallException("TripDAO should not be invoked on an unit test.")
        }
}