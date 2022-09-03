package com.lucasdias.breed.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucasdias.breed.view_model.model.UIBreed

private const val BREED_KEY = "BREED_KEY"

fun navigateToBreedDetailActivity(activity: Activity, breed: UIBreed) {
    Intent(activity, BreedDetailActivity::class.java).run {
        Bundle().also {
            it.putParcelable(BREED_KEY, breed)
            putExtras(it)
            activity.startActivity(this)
        }
    }
}

class BreedDetailActivity : AppCompatActivity() {

    private val breed: UIBreed? by lazy { intent?.getParcelableExtra(BREED_KEY) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_detail)
    }
}
