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
    ): View { // ? 를 지운이유 : binding.root 가 nullable 하지 않은걸 알아서
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 기존 액티비티의 onCreate에 작성했던 init로직을 이제는 여기에 작성합니다.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}