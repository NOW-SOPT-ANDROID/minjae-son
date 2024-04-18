package com.sopt.now.homeFragment

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
            "바인딩 객체 생성 해라"
        }
    private val viewModel by viewModels<HomeViewModel>()
    //    private var userName: String? = null
    //    private var userPlace: String? = null

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
        homeProfiledAdapter.setProfileList(viewModel.myProfile,viewModel.friendProfileList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}