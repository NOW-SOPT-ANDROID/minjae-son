package com.sopt.now.main.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.now.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "바인딩 객체를 생성해야 합니다."
        }
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeProfiledAdapter = HomeProfileAdapter()
        binding.rvHomeFriendList.run {
            adapter = homeProfiledAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        homeProfiledAdapter.setProfileList(viewModel.mockMyProfile, viewModel.mockFriendProfileList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}