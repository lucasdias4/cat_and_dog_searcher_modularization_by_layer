package com.lucasdias.android_core.ui_state

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * observe all
 */
fun <T> LiveData<UIState<T>>.observeState(
    owner: LifecycleOwner,
    success: ((T) -> Unit),
    error: ((Throwable?) -> Unit),
    loading: (() -> Unit)
) {
    val observer = UiStateObserver<T>(
        loading = loading,
        success = success,
        error = error
    )
    observe(owner, observer)
}

/**
 * observe success only
 */
fun <T> LiveData<UIState<T>>.observeState(owner: LifecycleOwner, success: (T?) -> Unit) {
    val observer = UiStateObserver<T>(success = success)
    observe(owner, observer)
}