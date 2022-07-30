package com.info.pdfreader.screens.folder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.pdfreader.data.FolderData
import com.info.pdfreader.repository.PdfReaderRepository
import kotlinx.coroutines.launch

class FolderViewModel : ViewModel() {

    private val repository = PdfReaderRepository()


    private val _folder = MutableLiveData<FolderData>()
    val folder: LiveData<FolderData> = _folder



    fun getFolder(id: String){
        viewModelScope.launch {
            _folder.value = repository.getFolderById(id)
        }
    }



}