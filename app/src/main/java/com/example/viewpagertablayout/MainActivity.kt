package com.example.viewpagertablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.model_3,
            R.drawable.model_s,
            R.drawable.model_x,
            R.drawable.cybertruck,
            R.drawable.semi
        )

        val adapter = ViewPagerAdapter(images)
        viewpager.adapter = adapter

        //connecting the tablayout with the viewpager, also setting up the names for each tab.

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->

            when (position) {

                0 -> tab.text = "Model 3"
                1 -> tab.text = "Model S"
                2 -> tab.text = "Model X"
                3 -> tab.text = "Cyber Truck"
                4 -> tab.text = "Semi"

            }

        }.attach()

        // setting up a listener for each tab, basically we can put here any tasks we need to be executed when we click on that tab.
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })



    }
}