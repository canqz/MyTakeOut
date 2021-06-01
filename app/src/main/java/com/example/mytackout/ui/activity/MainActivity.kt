package com.example.mytackout.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mytackout.R
import com.example.mytackout.ui.fragment.HomeFragment
import com.example.mytackout.ui.fragment.MoreFragment
import com.example.mytackout.ui.fragment.OrderFragment
import com.example.mytackout.ui.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragments = listOf(HomeFragment(),OrderFragment(),MoreFragment(),UserFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomBar()
    }

    private fun initBottomBar() {
        for (i in 0 until main_bottom_bar.childCount) {
            main_bottom_bar.getChildAt(i).setOnClickListener {
                changeIndex(i)
            }
        }
    }

    private fun changeIndex(index: Int) {
        for (i in 0 until main_bottom_bar.childCount) {
            val child = main_bottom_bar.getChildAt(i)
            if (i == index) {
                setViewEnable(child, false)
            } else {
                setViewEnable(child, true)
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.main_content,fragments[index]).commit()
    }

    private fun setViewEnable(child: View, isEnable: Boolean) {
        child.isEnabled = isEnable
        if (child is ViewGroup) {
            for (i in 0 until child.childCount) {
                child.getChildAt(i).isEnabled = isEnable
            }
        }
    }
}