package com.example.lifecycle

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var mainViewModel: MainViewModel
    var TAG = "#MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d(TAG, "onCreate() called")
        textView = findViewById(R.id.tv_ctr)
//        lifecycle.addObserver(Observer())
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        mainViewModel.counter.observe(this){
//            textView.text=it.toString()
//        }
        CoroutineScope(Dispatchers.IO).launch {
            if (isTaskComlpted()) {
                finish()
            }
        }
    }

    suspend fun isTaskComlpted(): Boolean {
        delay(3000)
        return true
    }
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("ctr",counter)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        counter=savedInstanceState.getInt("ctr")
//        textView.text=counter.toString()
//    }


    //    fun setText(){
//        textView.text=mainViewModel.counter.toString()
//    }
//    fun onClick(view: View) {
//        mainViewModel.increment()
//    }
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
}