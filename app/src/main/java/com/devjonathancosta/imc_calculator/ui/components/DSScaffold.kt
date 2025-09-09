package com.devjonathancosta.imc_calculator.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.devjonathancosta.imc_calculator.ui.theme.Black
import com.devjonathancosta.imc_calculator.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSScaffold(
    title: String = "",
    textAlign: TextAlign = TextAlign.Center,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        textAlign = textAlign,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White,
                    titleContentColor = Black,
                    navigationIconContentColor = Black,
                    actionIconContentColor = Black
                )
            )
        },
        content = content
    )
}
