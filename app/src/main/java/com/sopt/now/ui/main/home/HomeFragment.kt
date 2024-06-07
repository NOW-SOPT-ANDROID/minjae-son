package com.sopt.now.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.now.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        val memberId = activity?.intent?.getStringExtra("memberId") ?: "0"
        fetchUserInfo(memberId)
        fetchFriendsInfo()
        observeInfoList()
    }

    private fun fetchUserInfo(memberId: String?) {
        viewModel.fetchUserInfo(memberId?.toInt() ?: 0)
    }

    private fun fetchFriendsInfo() {
        viewModel.fetchFriendsInfo()
    }

    private fun observeInfoList() {
        val homeProfiledAdapter = HomeViewAdapter()
        binding.rvHomeFriendList.run {
            adapter = homeProfiledAdapter
            layoutManager = LinearLayoutManager(requireContext())
            homeProfiledAdapter.setUserProfileList(viewModel.userInfo.value)
            homeProfiledAdapter.setFriendProfileList(viewModel.friendsInfo.value)

            viewModel.userInfo.observe(viewLifecycleOwner, Observer { userProfile ->
                userProfile?.let { viewModel.updateUserProfileUI(this, it) }
            })
            viewModel.friendsInfo.observe(viewLifecycleOwner, Observer { friendProfiles ->
                friendProfiles?.let { viewModel.updateFriendProfilesUI(this, it) }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(memberId: String?): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle().apply {
                putString("memberId", memberId)
            }
            fragment.arguments = args
            return fragment
        }
    }
}