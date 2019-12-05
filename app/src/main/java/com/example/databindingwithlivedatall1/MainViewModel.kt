package com.example.databindingwithlivedatall1

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    @Bindable
    val editTextContent = MutableLiveData<String>()

    //Update LiveData

    //hien thi gtri edt
    private val _showEdt = MutableLiveData<String>()
    val showEdt : LiveData<String>
        get() = _showEdt

    //hien thi thay doi tung gtri cua edt
    private val _changeValueEditText = MutableLiveData<String>()
    val changeValueEditText : LiveData<String>
        get() = _changeValueEditText
}

//LiveData con co them:
//Transformations.map()
//Transformations.switchMap()