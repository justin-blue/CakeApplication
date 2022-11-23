package com.reallyhandyapps.cakeapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.reallyhandyapps.cakeapplication.CakeViewModel
import com.reallyhandyapps.cakeapplication.views.CakeDialog
import com.reallyhandyapps.cakeapplication.views.CakeList
import com.reallyhandyapps.cakeapplication.views.ErrorDialog
import com.reallyhandyapps.cakeapplication.views.RefreshButton

@Composable
fun CakesScreen(
    modifier: Modifier = Modifier,
    cakeViewModel: CakeViewModel = viewModel()
) {
    val list = cakeViewModel.cakesList.collectAsState().value
    val selectedItem = cakeViewModel.selectedItem.collectAsState().value
    val error = cakeViewModel.error.collectAsState().value

    Column(modifier = modifier) {
        CakeList(
            list = list,
            onCakeSelected = { item -> cakeViewModel.onCakeSelected(item) },
            modifier = modifier
        )

        selectedItem?.let {
            CakeDialog(
                item = it,
                onDialogClosed = { cakeViewModel.onDialogClosed() }
            )
        }

        if (error) {
            ErrorDialog(
                onDialogErrorClosed = { cakeViewModel.onErrorDialogClosed() }
            )
        }

        if (!error) {
            RefreshButton(
                onRefresh = { cakeViewModel.onRefreshClicked() },
                modifier = modifier
            )
        }
    }
}