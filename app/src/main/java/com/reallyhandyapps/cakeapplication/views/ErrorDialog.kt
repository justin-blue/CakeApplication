package com.reallyhandyapps.cakeapplication.views

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.reallyhandyapps.cakeapplication.R


@Composable
fun ErrorDialog(
    onDialogErrorClosed: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDialogErrorClosed() },
        confirmButton = {
            TextButton(onClick = { onDialogErrorClosed() })
            { Text(text = stringResource(R.string.retry_button_text)) }
        },
        title = { Text(text = stringResource(R.string.generic_error_dialog_title)) },
        text = { Text(text = stringResource(R.string.error_dialog_message) ) }
    )
}