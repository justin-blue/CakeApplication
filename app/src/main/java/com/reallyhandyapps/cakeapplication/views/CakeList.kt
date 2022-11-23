package com.reallyhandyapps.cakeapplication.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.reallyhandyapps.cakeapplication.screens.CakeItem
import com.reallyhandyapps.domain.CakeDomain

@Composable
fun CakeList(
    list: List<CakeDomain>,
    onCakeSelected: (item: CakeDomain) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { cake ->
            Divider()
            CakeItem(
                cake = cake,
                onCakeSelected = { onCakeSelected(cake) }
            )
        }
    }
}