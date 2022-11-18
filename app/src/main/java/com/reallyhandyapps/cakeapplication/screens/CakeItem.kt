package com.reallyhandyapps.cakeapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.reallyhandyapps.domain.CakeDomain

@Composable
fun CakeItem(
    cake: CakeDomain,
    onCakeSelected: (cake: CakeDomain) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCakeSelected(cake) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = cake.imageURL,
            contentDescription = cake.desc,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = cake.title, style = TextStyle(fontSize = 20.sp))

    }
}
