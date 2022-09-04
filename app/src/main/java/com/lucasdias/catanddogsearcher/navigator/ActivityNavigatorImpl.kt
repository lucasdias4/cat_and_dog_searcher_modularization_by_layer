package com.lucasdias.catanddogsearcher.navigator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.lucasdias.android_core.navigator.ActivityNavigator
import com.lucasdias.breed.view.list.ANIMAL_TYPE_KEY
import com.lucasdias.breed.view.list.BREED_NAME_KEY
import com.lucasdias.breed.view.list.BreedListActivity
import com.lucasdias.search.view.SearchActivity

class ActivityNavigatorImpl : ActivityNavigator {

    override fun navigateToSearch(activity: Activity, flags: Int) {
        Intent(activity, SearchActivity::class.java).run {
            addFlags(flags)
            activity.startActivity(this)
        }
    }

    override fun navigateToBreedList(
        breedName: String,
        animalTypeName: String,
        activity: Activity
    ) {
        Intent(activity, BreedListActivity::class.java).run {
            Bundle().also {
                it.putString(BREED_NAME_KEY, breedName)
                it.putString(ANIMAL_TYPE_KEY, animalTypeName)
                putExtras(it)
                activity.startActivity(this)
            }
        }
    }
}
