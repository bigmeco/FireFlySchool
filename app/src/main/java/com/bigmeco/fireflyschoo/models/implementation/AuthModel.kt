package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.models.contracts.IAuthModel
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthModel:IAuthModel {
    private val TAG = "AnonymousAuth"

    override suspend fun getAuth(): String {
        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()


        return suspendCoroutine { continuation ->
            mAuth.signInAnonymously()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInAnonymously:success")
                            val user = mAuth.currentUser
                            if (user != null) {
                                continuation.resume(user.uid)
                                Log.d(TAG, "signInAnonymously:success"+user.uid)

                            } else {
                                Log.d(TAG, "signInAnonymously:else")

                            }

                        } else {
                            Log.w(TAG, "signInAnonymously:failure", task.exception)

                        }

                    }
        }
    }

}