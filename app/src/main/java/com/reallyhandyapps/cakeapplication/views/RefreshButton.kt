package com.reallyhandyapps.cakeapplication.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.reallyhandyapps.cakeapplication.R

@Composable
fun RefreshButton(onRefresh: ()->Unit, modifier: Modifier){
    Row(modifier = modifier.padding( 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = { onRefresh() }) {
            Text(stringResource(R.string.refresh_button_text))
        }
    }
}