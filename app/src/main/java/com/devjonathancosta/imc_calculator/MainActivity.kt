package com.devjonathancosta.imc_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devjonathancosta.imc_calculator.ui.theme.IMCCalculatorTheme
import com.devjonathancosta.imc_calculator.views.FormIMCView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMCCalculatorTheme {
                FormIMCView()
            }
        }
    }
}