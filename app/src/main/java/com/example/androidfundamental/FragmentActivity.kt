package com.example.androidfundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragment1 = fragment1()
        val fragment = fragmentManager.findFragmentByTag(fragment1::class.java.simpleName)

        if (fragment !is fragment1){
            fragmentManager.beginTransaction().add(R.id.container, fragment1, fragment1::class.java.simpleName).commit()
        }
    }
}