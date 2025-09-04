package com.devjonathancosta.imc_calculator.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.devjonathancosta.imc_calculator.ui.theme.Green400
import com.devjonathancosta.imc_calculator.ui.theme.White
import com.devjonathancosta.imc_calculator.R

class FormIMCView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormView(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Green400,
                    titleContentColor = White
                )
            )
        }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ){

        }
    }
}

@Preview
@Composable
fun FormViewPreview(){
    FormView()
}