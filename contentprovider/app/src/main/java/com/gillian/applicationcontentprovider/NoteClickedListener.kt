package com.gillian.applicationcontentprovider

import android.database.Cursor

interface NoteClickedListener {
    fun notClickedItem(cursor: Cursor)
    fun noteRemoveItem(cursor: Cursor?)
}