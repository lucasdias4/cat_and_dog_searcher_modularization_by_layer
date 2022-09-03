package com.lucasdias.android_core.extension

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.showSuccess() {
    editText?.background = ResourcesCompat.getDrawable(resources, com.lucasdias.resource.R.drawable.default_input_text_shape, null)
    editText?.setTextColor(context.getColor(com.lucasdias.resource.R.color.nero))
    setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(context, com.lucasdias.resource.R.color.nero)))
    defaultHintTextColor = ColorStateList.valueOf(ContextCompat.getColor(context, com.lucasdias.resource.R.color.bilbao))
}

fun TextInputLayout.showError() {
    editText?.background = ResourcesCompat.getDrawable(resources, com.lucasdias.resource.R.drawable.error_input_text_shape, null)
    editText?.setTextColor(context.getColor(com.lucasdias.resource.R.color.nero))
    setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(context, com.lucasdias.resource.R.color.red_pigment)))
    defaultHintTextColor = ColorStateList.valueOf(ContextCompat.getColor(context, com.lucasdias.resource.R.color.red_pigment))
}
