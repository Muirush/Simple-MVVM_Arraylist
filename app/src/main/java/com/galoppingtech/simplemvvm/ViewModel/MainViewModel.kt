package com.galoppingtech.simplemvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.galoppingtech.simplemvvm.Model.model

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<model>>()
    var newlist = arrayListOf<model>()
    fun add(blog: model){
        newlist.add(blog)
        lst.value=newlist
    }
}