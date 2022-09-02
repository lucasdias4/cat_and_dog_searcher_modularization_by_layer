package com.lucasdias.catanddogsearcher.di

import com.lucasdias.android_core.navigator.ActivityNavigator
import com.lucasdias.android_core.navigator.FragmentNavigator
import com.lucasdias.android_core.navigator.Navigator
import com.lucasdias.catanddogsearcher.navigator.ActivityNavigatorImpl
import com.lucasdias.catanddogsearcher.navigator.FragmentNavigatorImpl
import com.lucasdias.catanddogsearcher.navigator.NavigatorImpl
import org.koin.dsl.module

@Suppress("RemoveExplicitTypeArguments", "USELESS_CAST")
val appModule = module {
    factory {
        ActivityNavigatorImpl() as ActivityNavigator
    }

    factory {
        FragmentNavigatorImpl() as FragmentNavigator
    }

    factory {
        NavigatorImpl(
            get<ActivityNavigator>(),
            get<FragmentNavigator>()
        ) as Navigator
    }
}
