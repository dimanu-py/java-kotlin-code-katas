package org.dimanu.tripservice

import org.dimanu.tripservice.user.User

class UserMother {

    companion object {
        fun any(): User {
            return User()
        }
    }
}