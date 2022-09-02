package com.lucasdias.android_core.navigator

import androidx.fragment.app.Fragment

interface FragmentNavigator {
    fun createComicListFragment(): Fragment

    fun createProfileFragment(): Fragment
}
