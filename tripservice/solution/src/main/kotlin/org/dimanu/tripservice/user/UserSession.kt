package org.dimanu.tripservice.user

import org.dimanu.tripservice.exception.CollaboratorCallException

class UserSession {
    private constructor()

    companion object {
        @JvmStatic val instance = UserSession()
    }

    val loggedUser: User?
        get() = throw CollaboratorCallException("UserSession.getLoggedUser() should not be called in an unit test")
}