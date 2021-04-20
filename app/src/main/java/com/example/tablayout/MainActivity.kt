package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="kotlinApp"
        tabLayout=findViewById(R.id.tablayout)
        viewPager=findViewById(R.id.viewpager)
        tabLayout.addTab(tabLayout.newTab().setText("football"))
        tabLayout.addTab(tabLayout.newTab().setText("cricket"))
        tabLayout.addTab(tabLayout.newTab().setText("vollyball"))
//        tabLayout.addTab(tabLayout.newTab().setText("handball"))
        tabLayout.tabGravity=TabLayout.GRAVITY_FILL
        val adapter = Adapter(this,supportFragmentManager,tabLayout.tabCount)
        viewPager.adapter=adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem= tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })
    }
}