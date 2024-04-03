package com.sopt.now

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    fun OnCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            if (binding.etSignUpId.text.length in 6..10 &&
                binding.etSignUpPw.text.length in 8..12 &&
                binding.etSignUpName.text.length >= 1) {
                Snackbar.make(it,"회원가입 완료!",Snackbar.LENGTH_SHORT).show()
            }
            else
                Snackbar.make(it,"회원가입 실패",Snackbar.LENGTH_SHORT).show()
        }
    }

//    1. 모든 정보 입력되지 않았을 시, 회원 가입 불가 (snackbar , toast 등으로 메세지 표시)
//    2. 성공 시 LoginActivity로 화면 전환, 정보도 함께 전달, 회원가입 성공 메세지 표시
//    <회원가입 성공조건>
//    - ID : 6~10 글자
//    - Password : 8~12 글자
//    - 닉네임 : 한 글자 이상, 공백으로만 이루어진 닉네임은 불가
//    - 나머지 조건 : 자유
}