package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.models.contracts.IAuthModel
import com.bigmeco.fireflyschoo.presenters.presenterLogic.SplashPresenter
import com.google.firebase.auth.FirebaseAuth
import java.net.CacheResponse

class AuthModel:IAuthModel {
    private val TAG = "AnonymousAuth"

    override  fun getAuth(response: (uid: String) -> Unit) {
        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()



            mAuth.signInAnonymously()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInAnonymously:success")
                            val user = mAuth.currentUser
                            if (user != null) {
                                response.invoke(user.uid)
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