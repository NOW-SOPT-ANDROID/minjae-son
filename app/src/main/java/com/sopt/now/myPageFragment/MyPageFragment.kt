package com.sopt.now.myPageFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sopt.now.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체를 생성해야 합니다."
        }

    private var userId: String? = null
    private var userPw: String? = null
    private var userName: String? = null
    private var userPhoneNumber: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        userId = arguments?.getString("ID")
        userPw = arguments?.getString("PW")
        userName = arguments?.getString("Name")
        userPhoneNumber = arguments?.getString("PhoneNumber")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvMyPageShowId.text = userId
        binding.tvMyPageShowPw.text = userPw
        binding.tvMyPageShowName.text = userName
        binding.tvMyPageShowPhoneNumber.text = userPhoneNumber
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}