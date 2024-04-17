package com.sopt.now

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
            "바인딩 객체 생성 해라"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = arguments?.getString("ID")
        val userPw = arguments?.getString("PW")
        val userName = arguments?.getString("Name")
        val userPlace = arguments?.getString("Place")

        binding.tvMyPageId.text = userId
        binding.tvMyPagePw.text = userPw
        binding.tvMyPageName.text = userName
        binding.tvMyPagePlace.text = userPlace
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}