package com.lucasdias.android_core.extension

import android.view.View
import android.widget.Button
import androidx.lifecycle.LifecycleOwner
import com.lucasdias.android_core.connectivity.Connectivity

fun Connectivity.setUpConnectivityChangeBehavior(
    view: View,
    lifecycleOwner: LifecycleOwner
) {
    getLiveData().observe(lifecycleOwner) { hasInternetConnection ->
        if (hasInternetConnection) {
            view.showWithConnectivitySnackbar()
        } else {
            view.showWithoutConnectivitySnackbar()
        }
    }
}

fun Connectivity.setUpConnectivityChangeBehavior(
    view: View,
    button: Button,
    lifecycleOwner: LifecycleOwner
) {
    getLiveData().observe(lifecycleOwner) { hasInternetConnection ->
        if (hasInternetConnection) {
            button.isEnabled = true
            view.showWithConnectivitySnackbar()
        } else {
            button.isEnabled = false
            view.showWithoutConnectivitySnackbar()
        }
    }
}
