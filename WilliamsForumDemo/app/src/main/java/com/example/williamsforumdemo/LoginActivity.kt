package com.example.williamsforumdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest


class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()

        /* Registration Activity if we want to get more data from our users.
        *
        *   btnRegister.setOnClickListener {
        *       startActivity(Intent(this,RegistrationActivity::class.java))
        *   }
        */
    }

    fun loginClick(v: View) {


        if (!isFormValid()) {
            return
        }

        btnLogin.visibility = View.INVISIBLE
        pbLogin.visibility = View.VISIBLE

        FirebaseAuth.getInstance().signInWithEmailAndPassword(
            etEmailAddress.text.toString(), etPassword.text.toString()
        ).addOnSuccessListener {
            Toast.makeText(
                this@LoginActivity, "Welcome back ${FirebaseAuth.getInstance().currentUser?.displayName}" ,
                Toast.LENGTH_LONG
            ).show()

            // open Forum Activity
            startActivity(
                Intent(
                    this@LoginActivity,
                    MainActivity::class.java
                )
            )

        }.addOnFailureListener {
            Toast.makeText(
                this@LoginActivity, "Error: ${it.message}",
                Toast.LENGTH_LONG
            ).show()
            btnLogin.visibility = View.VISIBLE
            pbLogin.visibility = View.INVISIBLE
        }

    }

    fun registerClick(v: View) {
        if (!isFormValid()) {
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            etEmailAddress.text.toString(), etPassword.text.toString()
        ).addOnSuccessListener {
            val user = it.user

            user.updateProfile(
                UserProfileChangeRequest.Builder()
                    .setDisplayName(userNameFromEmail(etEmailAddress.text.toString()))
                    .build()
            )

            Toast.makeText(
                this@LoginActivity, "Success! Welcome to Ride Forum",
                Toast.LENGTH_LONG
            ).show()

            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }.addOnFailureListener {
            Toast.makeText(
                this@LoginActivity, "Error: ${it.message}",
                Toast.LENGTH_LONG
            ).show()
        }

    }


    private fun userNameFromEmail(email: String) = email.substringBefore("@")

    private fun isFormValid(): Boolean {
        return when {
            etEmailAddress.text.isEmpty() -> {
                etEmailAddress.error = "This field can not be empty"
                false
            }
            etPassword.text.isEmpty() -> {
                etPassword.error = "This field can not be empty"
                false
            }
            else -> true
        }

    }
    fun passwordReset(v:View){
        Toast.makeText(this@LoginActivity, "This functionality has not been implemented yet...", Toast.LENGTH_LONG).show()
    }
}
