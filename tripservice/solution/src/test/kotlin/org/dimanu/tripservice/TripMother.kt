package org.dimanu.tripservice

import org.dimanu.tripservice.trip.Trip

class TripMother {
    companion object {
        fun any(): Trip {
            return Trip()
        }
    }
}