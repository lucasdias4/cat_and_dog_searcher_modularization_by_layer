package com.lucasdias.search.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucasdias.android_core.extension.animateGoneToVisible
import com.lucasdias.android_core.extension.animateVisibleToGone
import com.lucasdias.android_core.extension.hideKeyBoard
import com.lucasdias.android_core.extension.onImeActionDone
import com.lucasdias.android_core.extension.setUp
import com.lucasdias.android_core.extension.showError
import com.lucasdias.android_core.extension.showSuccess
import com.lucasdias.android_core.navigator.Navigator
import com.lucasdias.common_model.UIRequestType
import com.lucasdias.common_model.UIRequestType.CAT
import com.lucasdias.common_model.UIRequestType.CAT_AND_DOG
import com.lucasdias.common_model.UIRequestType.DOG
import com.lucasdias.core.timber.logWithTimber
import com.lucasdias.search.view.databinding.ActivitySearchBinding
import org.koin.android.ext.android.inject

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var requestType: UIRequestType
    private val navigator by inject<Navigator>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpSpinner()
        setUpInputText()
        setUpSearchButton()
    }

    private fun setUpSpinner() {
        val options = listOf(CAT.description, DOG.description, CAT_AND_DOG.description)
        binding.requestTypeSpinner.setUp(this, options) { selectedOptionText ->
            requestType = getRequestTypeByDescription(selectedOptionText)
        }
    }

    private fun getRequestTypeByDescription(description: String): UIRequestType {
        return when (description) {
            CAT.description -> CAT
            DOG.description -> DOG
            CAT_AND_DOG.description -> CAT_AND_DOG
            else -> CAT
        }
    }
    private fun setUpInputText() = with(binding) {
        searchTextInputEditText.onImeActionDone { searchButton.performClick() }
    }

    private fun setUpSearchButton() = with(binding) {
        searchButton.setOnClickListener {
            val searchText = searchTextInputEditText.text.toString()
            hideKeyBoard()
            if (searchText.isNotEmpty()) {
                initiateSearch(searchText)
            } else {
                showSearchErrorState()
            }
        }
    }

    private fun initiateSearch(searchText: String) = with(binding) {
        emptySearchMessage.animateVisibleToGone()
        searchTextInputLayout.showSuccess()
        logWithTimber("searchText.isNotEmpty()")
    }

    private fun showSearchErrorState() = with(binding) {
        searchTextInputLayout.showError()
        emptySearchMessage.animateGoneToVisible()
        logWithTimber("!searchText.isNotEmpty()")
    }
}
