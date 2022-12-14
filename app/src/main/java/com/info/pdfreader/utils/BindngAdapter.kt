package com.info.pdfreader.utils

import android.text.format.DateFormat
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.info.pdfreader.data.FolderData
import java.util.*



@BindingAdapter("setDate")
fun setDate(tv: TextView, date: Date?) {
    tv.text = DateFormat.format("yyyy-MM-dd",date)
}



@BindingAdapter("setCount")
fun setPdfCount(tv: TextView, folder: FolderData){
    tv.text = "Files: ${folder.pdfsCount}"
}