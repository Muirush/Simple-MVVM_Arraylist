package com.galoppingtech.simplemvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Factory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}