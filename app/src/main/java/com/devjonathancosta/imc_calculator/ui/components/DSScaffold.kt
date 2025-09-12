package com.devjonathancosta.imc_calculator.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
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
    textAlign: TextAlign = TextAlign.Center,
    content: @Composable (PaddingValues) -> Unit,
    navController: NavController,
    canNavigateBack: Boolean = false
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
                navigationIcon = {
                    if (canNavigateBack){
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
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
