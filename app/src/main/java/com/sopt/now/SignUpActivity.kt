package com.sopt.now

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {

            //    1. 모든 정보 입력되지 않았을 시, 회원 가입 불가 (snackbar , toast 등으로 메세지 표시)
            //    2. 성공 시 LoginActivity로 화면 전환, 정보도 함께 전달, 회원가입 성공 메세지 표시
            //    <회원가입 성공조건>
            //    - ID : 6~10 글자
            //    - Password : 8~12 글자
            //    - 닉네임 : 한 글자 이상, 공백으로만 이루어진 닉네임은 불가
            //    - 나머지 조건 : 자유

            if (binding.etSignUpId.text.length in 6..10 &&
                binding.etSignUpPw.text.length in 8..12 &&
                binding.etSignUpName.text.isNotEmpty() &&
                binding.etSignUpPlace.text.isNotEmpty()) {

                Toast.makeText(this,"회원가입 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this,LoginActivity::class.java) // 회원가입 성공 시, 로그인 화면으로 이동
                // 회원가입 정보 넘기기
                intent.putExtra("ID",binding.etSignUpId.text.toString())
                intent.putExtra("PW",binding.etSignUpPw.text.toString())
                intent.putExtra("Name",binding.etSignUpName.text.toString())
                intent.putExtra("Place",binding.etSignUpPlace.text.toString())
                startActivity(intent)
            }
            else if (binding.etSignUpId.text.isEmpty() || binding.etSignUpPw.text.isEmpty() ||
                     binding.etSignUpName.text.isEmpty() || binding.etSignUpPlace.text.isEmpty() ) {
                Toast.makeText(this, "입력하지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }

            else
                Toast.makeText(this,"회원가입 실패",Toast.LENGTH_SHORT).show()
        }
    }

}