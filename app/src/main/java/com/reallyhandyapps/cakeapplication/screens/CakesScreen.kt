package com.reallyhandyapps.cakeapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.reallyhandyapps.cakeapplication.CakeViewModel
import com.reallyhandyapps.cakeapplication.views.CakeDialog
import com.reallyhandyapps.cakeapplication.views.CakeList
import com.reallyhandyapps.cakeapplication.views.ErrorDialog

@Composable
fun CakesScreen(
    modifier: Modifier = Modifier,
    cakeViewModel: CakeViewModel = viewModel()
) {
    Column(modifier = modifier) {
        cakeViewModel.cakesList.value?.let {
            CakeList(
                list = it,
                onCakeSelected = { item -> cakeViewModel.onCakeSelected(item) },
                modifier = modifier
            )
            cakeViewModel.selectedItem.value?.let { it1 ->
                CakeDialog(
                    item = it1,
                    onDialogClosed = { cakeViewModel.onDialogClosed() }
                )
            }
            if (cakeViewModel.error.value) {
                ErrorDialog(
                    onDialogErrorClosed = { cakeViewModel.onErrorDialogClosed() }
                )
            }
        }
    }
}
