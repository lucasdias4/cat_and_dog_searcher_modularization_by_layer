package com.lucasdias.android_core.extension

import android.view.inputmethod.EditorInfo
import android.widget.EditText

fun EditText.onImeActionGo(callback: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_GO) {
            callback.invoke()
            return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
    }
}
