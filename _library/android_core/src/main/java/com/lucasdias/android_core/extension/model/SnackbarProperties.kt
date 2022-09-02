package com.lucasdias.android_core.extension.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

data class SnackbarProperties(
    @StringRes var textResId: Int,
    @ColorRes var backgroundColorResId: Int,
    @DrawableRes var drawableResId: Int = 0,
    @BaseTransientBottomBar.Duration var duration: Int = Snackbar.LENGTH_LONG
)
