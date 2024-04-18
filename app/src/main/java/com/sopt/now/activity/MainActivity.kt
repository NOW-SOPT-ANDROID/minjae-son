package com.sopt.now.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sopt.now.homeFragment.HomeFragment
import com.sopt.now.myPageFragment.MyPageFragment
import com.sopt.now.R
import com.sopt.now.searchFragment.SearchFragment
import com.sopt.now.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("ID")
        val userPw = intent.getStringExtra("PW")
        val userName = intent.getStringExtra("Name")
        val userPlace = intent.getStringExtra("Place")

        val currentFragment = supportFragmentManager.findFragmentById(binding.fcvMain.id)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvMain.id, HomeFragment())
                .commit()
        }
        clickBottomNavigation(userId,userPw,userName,userPlace)
    }

    private fun clickBottomNavigation(userId:String?,userPw:String?,userName:String?,userPlace:String?) {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val homeFragment = HomeFragment().apply {
                        arguments = Bundle().apply {
                            putString("Name", userName)
                            putString("Place", userPlace)
                        }
                    }
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_search -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.menu_mypage -> {
                    val myPageFragment = MyPageFragment().apply {
                        arguments = Bundle().apply {
                            putString("ID", userId)
                            putString("PW", userPw)
                            putString("Name", userName)
                            putString("Place", userPlace)
                        }
                    }
                    replaceFragment(myPageFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fcvMain.id, fragment)
            .commit()
    }
}