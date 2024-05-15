package com.sopt.now.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sopt.now.R
import com.sopt.now.databinding.ActivityMainBinding
import com.sopt.now.main.homeFragment.HomeFragment
import com.sopt.now.main.myPageFragment.MyPageFragment
import com.sopt.now.main.searchFragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val memberId = intent.getStringExtra("memberId")
        Log.e("MainActivity", "memberId: ${memberId}")

        val currentFragment = supportFragmentManager.findFragmentById(binding.fcvMain.id)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvMain.id, HomeFragment())
                .commit()
        }
        clickBottomNavigation(memberId)
    }

    private fun clickBottomNavigation(memberId: String?) {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val homeFragment = HomeFragment.newInstance(memberId)
                    replaceFragment(homeFragment)
                    true
                }

                R.id.menu_search -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.menu_mypage -> {
                    val myPageFragment = MyPageFragment.newInstance(memberId)
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