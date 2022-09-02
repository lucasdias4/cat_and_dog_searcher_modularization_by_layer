package com.lucasdias.android_core.extension

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

fun Fragment.setupBackButton(action: () -> Unit) {
    val backButtonCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                action()
            }
        }
    if (isAdded) {
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), backButtonCallback)
    }
}
