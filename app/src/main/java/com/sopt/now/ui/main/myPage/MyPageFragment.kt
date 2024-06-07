package com.sopt.now.ui.main.myPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sopt.now.databinding.FragmentMypageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체를 생성해야 합니다."
        }

    private val viewModel by viewModels<MyPageViewModel>()

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
        val memberId: String? = activity?.intent?.getStringExtra("memberId") ?: "0"
        fetchUserInfo(memberId)
        observeUserInfo()
    }

    private fun fetchUserInfo(memberId: String?) {
        viewModel.fetchUserInfo(memberId?.toInt() ?: 0)
    }

    private fun observeUserInfo() {
        with(binding) {
            viewModel.userInfo.observe(viewLifecycleOwner) {
                it?.let {
                    tvMyPageShowName.text = it.data.nickname
                    tvMyPageShowId.text = it.data.authenticationId
                    tvMyPageShowPhoneNumber.text = it.data.phone
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(memberId: String?): MyPageFragment {
            val fragment = MyPageFragment()
            val args = Bundle().apply {
                putString("memberId", memberId)
            }
            fragment.arguments = args
            return fragment
        }
    }
}