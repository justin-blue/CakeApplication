package com.reallyhandyapps.cakeapplication.views

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.reallyhandyapps.cakeapplication.R
import com.reallyhandyapps.domain.CakeDomain

@Composable
fun CakeDialog(
    item: CakeDomain,
    onDialogClosed: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDialogClosed() },
        confirmButton = {
            TextButton(onClick = { onDialogClosed() })
            { Text(text = stringResource(R.string.close_button_text)) }
        },
        title = { Text(text = stringResource(R.string.cake_description_dialog_title_text)) },
        text = { Text(text = item.desc) }
    )
}