package com.lucasdias.breed.view_model

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
import kotlinx.coroutines.launch

class BreedListViewModel(
    private val getBreedByNameAndAnimalTypeUseCase: GetBreedByNameAndAnimalTypeUseCase
) : ViewModel() {

    private val _requestLiveData: MutableLiveData<UIState<List<UIBreed>>> = MutableLiveData()
    val requestLiveData: LiveData<UIState<List<UIBreed>>> by lazy { _requestLiveData }

    fun getBreeds(name: String, animalType: UIAnimalType) {
        if (_requestLiveData.value is UIState.Loading) {
            return
        }
        _requestLiveData.value = UIState.Loading()
        viewModelScope.launch {
            val value = getBreedByNameAndAnimalTypeUseCase(name, animalType.toDomain()).mapToUIState {
                UIState.Success(it.toUI())
            }
            _requestLiveData.value = value
        }
    }
}
