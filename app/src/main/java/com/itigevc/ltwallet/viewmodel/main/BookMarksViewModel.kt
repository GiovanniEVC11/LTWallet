package com.itigevc.ltwallet.viewModel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookMarksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is BookMarks Fragment"
    }

    val text: LiveData<String> = _text

}