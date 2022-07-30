package com.info.pdfreader.screens.add_pdf

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.pdfreader.utils.FileType
import com.info.pdfreader.data.PdfData
import com.info.pdfreader.repository.PdfReaderRepository
import com.info.pdfreader.utils.DataState
import com.info.pdfreader.utils.generateId
import kotlinx.coroutines.launch
import java.util.*

class AddPdfViewModel : ViewModel() {

    private val repository = PdfReaderRepository()

    val folders = repository.observeFolders

    private val _inProgress = MutableLiveData<DataState?>()
    val inProgress: LiveData<DataState?> = _inProgress



    private fun upload(pdfData: PdfData) {
        viewModelScope.launch {
            repository.addPdf(pdfData)
                .addOnSuccessListener {
                    _inProgress.value = DataState.SUCCESS
                }
                .addOnFailureListener {
                    _inProgress.value = DataState.ERROR
                }

        }
    }



    // upload the pdf file then upload pdf data.
    fun uploadPdf(pdfData:PdfData, uri: Uri?) {
        _inProgress.value = DataState.LOADING
        viewModelScope.launch {
            /** the image will suspend until uploaded then it will store in this imageUri after that the novel data it will uploaded **/
            val fileType = FileType.FILE.name.lowercase(Locale.ROOT)
            val pdfUri = repository.uploadFile(uri!!,pdfData.title, fileType)
            pdfData.url = pdfUri.toString()
            upload(pdfData)
        }
    }


    fun resetState(){
        _inProgress.value = null
    }





}