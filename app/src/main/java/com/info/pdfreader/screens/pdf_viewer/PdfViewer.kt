package com.info.pdfreader.screens.pdf_viewer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.info.pdfreader.R
import com.info.pdfreader.databinding.PdfViewerBinding


class PdfViewer: Fragment() {

    private lateinit var viewModel: PdfViewerViewModel
    private lateinit var binding: PdfViewerBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =   DataBindingUtil.inflate(inflater, R.layout.pdf_viewer, container, false)
        viewModel = ViewModelProvider(this)[PdfViewerViewModel::class.java]


        setViews()

        setObserves()




        return binding.root



    }


    private fun setObserves() {

    }

    private fun setViews() {

    }



}