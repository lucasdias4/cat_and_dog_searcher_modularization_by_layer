package com.lucasdias.breed.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucasdias.breed.view.databinding.ActivityBreedListBinding
import com.lucasdias.breed.view_model.BreedListViewModel
import com.lucasdias.breed.view_model.model.UIBreed
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class BreedListActivity : AppCompatActivity() {

    private val viewModel by viewModel<BreedListViewModel>()
    private val adapter by inject<BreedListAdapter> {
        parametersOf({ breed: UIBreed -> navigateToBreedDetail(breed) })
    }
    private lateinit var binding: ActivityBreedListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
    }

    private fun navigateToBreedDetail(breed: UIBreed) {
        navigateToBreedDetailActivity(this, breed)
    }
}
