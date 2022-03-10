package com.itigevc.ltwallet.data.repository.Auth

import com.itigevc.ltwallet.util.firebase.Response
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun isUserAuthenticatedInFb() : Boolean

    fun getFbAuthState() : Flow<Boolean>

    fun SignInFb(email: String, password: String) : Flow<Response<Boolean>>

    fun SignOutFb() : Flow<Response<Boolean>>

    fun SignUpFb(
        userName: String,
        email: String,
        password: String
    ) : Flow<Response<Boolean>>

}
