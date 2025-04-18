package org.dimanu.tripservice

import org.dimanu.tripservice.trip.Trip

object TripMother {
    fun any(): Trip {
        return Trip()
    }
}