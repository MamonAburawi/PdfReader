package com.info.pdfreader.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.pdfreader.data.FolderData
import com.info.pdfreader.repository.PdfReaderRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = PdfReaderRepository()

    // life data
//    val folders = repository.observeFolders

    private val _folders = MutableLiveData<List<FolderData>>()
    val folders: LiveData<List<FolderData>> = _folders




    fun getFolders(){
        viewModelScope.launch {
            _folders.value = repository.getFolders()
        }

    }



}