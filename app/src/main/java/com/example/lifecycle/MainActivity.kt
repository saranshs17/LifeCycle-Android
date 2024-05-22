package com.example.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lifecycle.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private val TAG = "#MainActivity"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replacewithFragment(FirstFragment()) // root fragment
        Log.d(TAG, "onCreate() called")
        binding.btnToFragment1.setOnClickListener {
            replacewithFragment(FirstFragment())
        }
        binding.btnToFragment2.setOnClickListener {
            replacewithFragment(SecondFragment())
        }
    }

    private fun replacewithFragment(fragment: Fragment, name: String? = null) {
        val fragmentManager = supportFragmentManager
        if (fragment is FirstFragment) fragmentManager.popBackStack(
            name,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(name).commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() called")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.d(TAG, "hasFocus: $hasFocus")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState() called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState() called")
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else super.onBackPressed()
    }
}