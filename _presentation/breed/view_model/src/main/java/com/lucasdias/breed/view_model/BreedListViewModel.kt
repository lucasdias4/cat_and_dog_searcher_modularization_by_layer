package com.lucasdias.breed.view_model

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasdias.android_core.ui_state.UIState
import com.lucasdias.android_core.ui_state.mapToUIState
import com.lucasdias.breed.view_model.mapper.toDomain
import com.lucasdias.breed.view_model.mapper.toUI
import com.lucasdias.breed.view_model.model.UIBreed
import com.lucasdias.common_model.UIAnimalType
import com.lucasdias.domain.use_case.GetBreedByNameAndAnimalTypeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BreedListViewModel(
    private val getBreedByNameAndAnimalTypeUseCase: GetBreedByNameAndAnimalTypeUseCase
) : ViewModel() {

    @VisibleForTesting
    internal var _requestLiveData: MutableLiveData<UIState<List<UIBreed>>> = MutableLiveData()
    val requestLiveData: LiveData<UIState<List<UIBreed>>> by lazy { _requestLiveData }

    fun getBreeds(name: String, animalType: UIAnimalType, isScreenEmpty: Boolean) {
        if (shouldNotRequestData(isScreenEmpty)) {
            return
        }
        _requestLiveData.value = UIState.Loading()
        viewModelScope.launch(Dispatchers.Main) {
            val state = getBreedByNameAndAnimalTypeUseCase(name, animalType.toDomain()).mapToUIState {
                UIState.Success(it.toUI())
            }
            _requestLiveData.value = state
        }
    }

    private fun shouldNotRequestData(isScreenEmpty: Boolean) =
        _requestLiveData.value is UIState.Loading || isScreenEmpty.not()
}
