package com.sopt.now

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sopt.now.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체 생성 해라"
        }

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // ? 를 지운이유 : binding.root 가 nullable 하지 않은걸 알아서
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    //    onViewCreated는 생성된 뷰 구조를 활용하여 Fragment에 사용자 인터랙션을 구현하는 구현부입니다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friendAdapter = FriendAdapter(requireContext())
        binding.rvFriends.adapter = friendAdapter
        friendAdapter.setFriendList(viewModel.mockFriendList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}