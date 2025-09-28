package com.devjonathancosta.imc_calculator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjonathancosta.imc_calculator.ui.theme.Black
import com.devjonathancosta.imc_calculator.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSScaffold(
    title: String = "",
    textAlign: TextAlign = TextAlign.Start,
    content: @Composable (PaddingValues) -> Unit,
    navController: NavController,
    canNavigateBack: Boolean = false
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = title,
                            textAlign = textAlign,
                            style = MaterialTheme.typography.titleLarge,
                            color = Black,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(
                            onClick = { navController.navigateUp() },
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar",
                                tint = Black
                            )
                        }
                    }
                },
                actions = {
                    if (!canNavigateBack) {
                        Spacer(modifier = Modifier.size(48.dp))
                    }
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
