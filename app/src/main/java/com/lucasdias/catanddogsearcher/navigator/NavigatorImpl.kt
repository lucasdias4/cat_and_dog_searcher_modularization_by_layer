package com.lucasdias.catanddogsearcher.navigator

import com.lucasdias.android_core.navigator.ActivityNavigator
import com.lucasdias.android_core.navigator.FragmentNavigator
import com.lucasdias.android_core.navigator.Navigator

class NavigatorImpl(
    activityNavigator: ActivityNavigator,
    fragmentNavigator: FragmentNavigator
) : Navigator,
    ActivityNavigator by activityNavigator,
    FragmentNavigator by fragmentNavigator
