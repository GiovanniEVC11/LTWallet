package com.itigevc.ltwallet.data.repository.Auth
/*
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
//import com.itigevc.ltwallet.domain.model.user.User
import com.itigevc.ltwallet.util.Constants
import com.itigevc.ltwallet.util.firebase.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
//import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth : FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    var operationSuccessful : Boolean = false

    override fun isUserAuthenticatedInFb(): Boolean {
        return auth.currentUser != null
    }

    override fun getFbAuthState(): Flow<Boolean> = callbackFlow {

        val authStateListener = FirebaseAuth.AuthStateListener {
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose{
            auth.removeAuthStateListener(authStateListener)
        }

    }

    override fun SignInFb(email: String, password: String) : Flow<Response<Boolean>> = flow {
        operationSuccessful = true
        try {
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener{
                operationSuccessful = true
            }
            Log.i("Exelent: ", Response.Success(operationSuccessful).toString())
        } catch (e: Exception){
            Log.e("Error: ",
                Response.Error(e.localizedMessage?:"An unexpected Error Sign In").toString()
            )
        }
    }

    override fun SignOutFb(): Flow<Response<Boolean>> = flow {

        try{
            auth.signOut()
        } catch(e: Exception){
            Log.e("Error: ", Response.Error(e.localizedMessage?:"An unexpected Error").toString())
        }

    }

    override fun SignUpFb(
        userName: String,
        email: String,
        password: String
    ): Flow<Response<Boolean>> = flow {

        operationSuccessful = false

        try {
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                operationSuccessful = true
            }

            if(operationSuccessful){
                val userId = auth.currentUser?.uid!!
                val obj = User(
                    userName = userName,
                    userId = userId,
                    password = password,
                    email = email
                )

                firestore.collection(Constants.COLLECTION_USERS)
                    .document(userId)
                    .set(obj)
                    .addOnSuccessListener {  }
            }

        } catch (e: Exception){
            Log.e("Error: ", Response.Error(e.localizedMessage?:"An unexpected Error").toString())
        }

    }
}

 */