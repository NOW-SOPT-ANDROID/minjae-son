package com.sopt.now

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    val ID_MIN_LENGTH = 6
    val ID_MAX_LENGTH = 10
    val PW_MIN_LENGTH = 8
    val PW_MAX_LENGTH = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUpSignUp.setOnClickListener {
            if (isSignUpValid())
                navigateToSignInActivity()
        }
    }

    private fun isSignUpValid(): Boolean {

        val id = binding.etSignUpId.text.toString()
        val pw = binding.etSignUpPw.text.toString()
        val name = binding.etSignUpName.text.toString()
        val place = binding.etSignUpPlace.text.toString()

        return when {
            id.isEmpty() || pw.isEmpty() || name.isEmpty() || place.isEmpty() -> {
                showToast(R.string.toast_SignUpActivity_InvalidSignUp_Blank.toString())
                false
            }

            id.length !in ID_MIN_LENGTH..ID_MAX_LENGTH || pw.length !in PW_MIN_LENGTH..PW_MAX_LENGTH -> {
                showToast(R.string.toast_SignUpActivity_InvalidSignUp_Blank.toString())
                false
            }

            else -> {
                showToast(R.string.toast_SignUpActivity_ValidSignUp.toString())
                true
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToSignInActivity() {
        val intent = Intent(this, SignInActivity::class.java)
        intent.putExtra("ID", binding.etSignUpId.text.toString())
        intent.putExtra("PW", binding.etSignUpPw.text.toString())
        intent.putExtra("Name", binding.etSignUpName.text.toString())
        intent.putExtra("Place", binding.etSignUpPlace.text.toString())
        startActivity(intent)
    }
}