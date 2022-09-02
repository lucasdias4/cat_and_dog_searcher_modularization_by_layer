package com.lucasdias.catanddogsearcher.navigator

import android.app.Activity
import android.content.Intent
import com.lucasdias.android_core.navigator.ActivityNavigator
import com.lucasdias.search.view.SearchActivity

class ActivityNavigatorImpl : ActivityNavigator {

    override fun navigateToSearch(activity: Activity, flags: Int) {
        Intent(activity, SearchActivity::class.java).run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            activity.startActivity(this)
        }
    }
}
