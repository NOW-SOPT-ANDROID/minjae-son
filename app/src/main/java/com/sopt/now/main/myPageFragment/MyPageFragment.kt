package com.sopt.now.main.myPageFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sopt.now.service.ServicePool
import com.sopt.now.main.ResponseUserInfoDto
import com.sopt.now.databinding.FragmentMypageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체를 생성해야 합니다."
        }

    private var memberId: String? = null

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

        memberId = activity?.intent?.getStringExtra("memberId") ?: "0"

        memberId?.let { memberId ->
            ServicePool.userService.getUserInfo(memberId.toInt()).enqueue(object :
                Callback<ResponseUserInfoDto> {
                override fun onResponse(
                    call: Call<ResponseUserInfoDto>,
                    response: Response<ResponseUserInfoDto>
                ) {
                    if (response.isSuccessful) {
                        val userInfo = response.body()?.data

                        userInfo?.let {
                            binding.tvMyPageId.text = " ${it.authenticationId}"
                            binding.tvMyPagePw.text = " ${it.nickname}"
                            binding.tvMyPagePhoneNumber.text = " ${it.phone}"
                        }
                    } else {
                        Toast.makeText(requireContext(), "회원 정보를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<ResponseUserInfoDto>, t: Throwable) {
                    Log.e("MyPageFragment", "Failed to fetch user info: ${t.message}")
                    Toast.makeText(requireContext(), "서버와의 통신 실패", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}