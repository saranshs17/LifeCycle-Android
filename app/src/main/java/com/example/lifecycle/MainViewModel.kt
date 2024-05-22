package com.example.lifecycle

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val TAG = "#MainViewModel"

    init {
        viewModelScope.launch {
            while (true) {
                delay(500)
                Log.d(TAG, "ViewModelRunning...")
            }
        }
    }

    var counter = MutableLiveData<Int>().apply { value = 0 }
    fun increment() {
        counter.value = counter.value?.plus(1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModelStopped!!")
    }
}