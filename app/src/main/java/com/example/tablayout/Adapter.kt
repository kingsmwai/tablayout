package com.example.tablayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
internal class Adapter (
    var context:Context,
    fm:FragmentManager,
    var totalsTabs: Int
):
        FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                Fragment_football()
            }
            1->{
                cricket()
            }
            2->{
                vollyball()
            }
            else->getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalsTabs
    }
}