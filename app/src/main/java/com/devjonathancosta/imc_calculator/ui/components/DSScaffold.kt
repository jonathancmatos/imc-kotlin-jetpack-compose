package com.devjonathancosta.imc_calculator.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.devjonathancosta.imc_calculator.ui.theme.Black
import com.devjonathancosta.imc_calculator.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSScaffold(
    title: String = "",
    content: @Composable (PaddingValues) -> Unit,
    navController: NavController,
    canNavigateBack: Boolean = false,
    textAlign: TextAlign = TextAlign.Start
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        color = Black,
                        modifier = if (textAlign != TextAlign.Center) {
                            Modifier.fillMaxWidth()
                        } else {
                            Modifier
                        },
                    )
                },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                tint = Black
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = White
                )
            )
        },
        content = content
    )
}
