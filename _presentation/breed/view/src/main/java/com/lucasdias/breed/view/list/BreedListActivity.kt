package com.lucasdias.breed.view.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucasdias.android_core.extension.gone
import com.lucasdias.android_core.extension.visible
import com.lucasdias.android_core.ui_state.observeState
import com.lucasdias.breed.view.databinding.ActivityBreedListBinding
import com.lucasdias.breed.view.detail.navigateToBreedDetailActivity
import com.lucasdias.breed.view_model.BreedListViewModel
import com.lucasdias.breed.view_model.model.UIBreed
import com.lucasdias.common_model.UIAnimalType
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

const val BREED_NAME_KEY = "BREED_NAME_KEY"
const val ANIMAL_TYPE_KEY = "ANIMAL_TYPE_KEY"

class BreedListActivity : AppCompatActivity() {

    private val viewModel by viewModel<BreedListViewModel>()
    private val adapter by inject<BreedListAdapter> {
        parametersOf({ breed: UIBreed -> navigateToBreedDetail(breed) })
    }
    private lateinit var binding: ActivityBreedListBinding
    private val animalTypeName: String by lazy { intent?.getStringExtra(ANIMAL_TYPE_KEY).orEmpty() }
    private val breedName: String by lazy { intent?.getStringExtra(BREED_NAME_KEY).orEmpty() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()
        getBreeds()
    }

    private fun getBreeds() {
        if (adapter.currentList.isEmpty()) {
            viewModel.getBreeds(breedName, animalType = UIAnimalType.valueOf(animalTypeName))
        }
    }

    private fun setUpRecyclerView() = with(binding.recyclerView) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        this.layoutManager = layoutManager
        this.adapter = this@BreedListActivity.adapter
    }

    private fun setUpObservers() {
        viewModel.requestLiveData.observeState(
            this,
            success = { osRequestSuccess(it) },
            empty = { osRequestEmpty() },
            error = { osRequestError() },
            loading = { osRequestLoading() }
        )
    }

    private fun osRequestSuccess(list: List<UIBreed>) = with(binding) {
        recyclerView.visible()
        loadingView.root.gone()
        emptyView.root.gone()
        errorView.root.gone()
        adapter.update(list)
    }

    private fun osRequestEmpty() = with(binding) {
        recyclerView.gone()
        loadingView.root.gone()
        emptyView.root.visible()
        errorView.root.gone()
    }

    private fun osRequestLoading() = with(binding) {
        recyclerView.gone()
        loadingView.root.visible()
        emptyView.root.gone()
        errorView.root.gone()
    }

    private fun osRequestError() = with(binding) {
        recyclerView.gone()
        loadingView.root.gone()
        emptyView.root.gone()
        errorView.root.visible()
    }

    private fun navigateToBreedDetail(breed: UIBreed) {
        navigateToBreedDetailActivity(this, breed)
    }
}
