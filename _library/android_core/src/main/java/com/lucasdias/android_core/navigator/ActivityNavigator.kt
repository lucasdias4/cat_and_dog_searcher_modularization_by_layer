package com.lucasdias.android_core.navigator

import android.app.Activity

interface ActivityNavigator {
    fun navigateToLoginActivity(activity: Activity, flags: Int)

    fun navigateToHome(activity: Activity, flags: Int)

    fun navigateToComicDetailActivity(activity: Activity, comicId: String)
}
