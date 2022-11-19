package com.reallyhandyapps.cakeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reallyhandyapps.domain.CakeDomain
import com.reallyhandyapps.domain.GetCakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CakeViewModel(
    private val getCakesUseCase: GetCakesUseCase
) : ViewModel() {
    private val _cakesList = MutableLiveData<List<CakeDomain>>()
    val cakesList = _cakesList

    private val _selectedItem = MutableLiveData<CakeDomain>()
    val selectedItem = _selectedItem

    private val _error = MutableStateFlow(false)
    val error: StateFlow<Boolean> = _error.asStateFlow()

    init {
        loadCakesList()
    }

    fun onCakeSelected(item: CakeDomain) {
        _selectedItem.value = item
    }

    fun onDialogClosed() {
        _selectedItem.value = null
    }

    fun onErrorDialogClosed() {
        _error.value = false
        loadCakesList()
    }

    private fun loadCakesList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getCakesUseCase()
            if (response.isEmpty().not()) {
                _cakesList.value = response
            } else {
                _error.value = true
            }

        }
    }
}