package com.reallyhandyapps.cakeapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reallyhandyapps.domain.CakeDomain
import com.reallyhandyapps.domain.GetCakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CakeViewModel @Inject constructor(
    private val getCakesUseCase: GetCakesUseCase
) : ViewModel() {

    //TODO encapsulate UI state in one object
    private val _cakesList = MutableStateFlow<List<CakeDomain>>(emptyList())
    val cakesList = _cakesList.asStateFlow()

    private val _selectedItem = MutableStateFlow<CakeDomain?>(null)
    val selectedItem = _selectedItem.asStateFlow()

    private val _error = MutableStateFlow(false)
    val error = _error.asStateFlow()

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