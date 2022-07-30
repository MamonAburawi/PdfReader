package com.info.pdfreader.screens.home

import com.airbnb.epoxy.TypedEpoxyController
import com.info.pdfreader.data.FolderData
import com.info.pdfreader.folder


class FolderController() : TypedEpoxyController<List<FolderData>>() {

    companion object{
        private const val TAG = "Controller"
    }

    interface ClickListener {
        fun onClick(folder: FolderData)
    }

    lateinit var clickListener: ClickListener


    override fun buildModels(data: List<FolderData>?) {
        data?.forEachIndexed { index, folder ->

            folder {
                id(folder.id)
                folder(folder)
                onClick { v->
                    clickListener.onClick(folder)
                }
            }


        }
    }



}