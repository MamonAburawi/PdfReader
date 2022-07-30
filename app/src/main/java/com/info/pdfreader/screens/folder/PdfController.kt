package com.info.pdfreader.screens.folder

import com.airbnb.epoxy.TypedEpoxyController
import com.info.pdfreader.data.PdfData
import com.info.pdfreader.pdf


class PdfController() : TypedEpoxyController<List<PdfData>>() {

    companion object{
        private const val TAG = "Controller"
    }

    interface ClickListener {
        fun onClick(pdf: PdfData)
    }

    lateinit var clickListener: ClickListener

    override fun buildModels(data: List<PdfData>?) {
        data?.forEachIndexed { index, pdf ->

            pdf {
                id(pdf.id)
                pdf(pdf)
                onClick { v->
                    clickListener.onClick(pdf)
                }
            }

        }
    }



}