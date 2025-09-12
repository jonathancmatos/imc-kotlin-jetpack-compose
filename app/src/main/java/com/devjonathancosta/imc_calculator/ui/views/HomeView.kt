package com.devjonathancosta.imc_calculator.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devjonathancosta.imc_calculator.R
import com.devjonathancosta.imc_calculator.ui.components.DSElevatedButton
import com.devjonathancosta.imc_calculator.ui.components.DSScaffold
import com.devjonathancosta.imc_calculator.ui.components.DSTextFormField
import com.devjonathancosta.imc_calculator.ui.theme.White

@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    DSScaffold(
        title = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        navController = navController!!,
        content = { padding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
                    .padding(padding)
                    .padding(
                        vertical = 24.dp,
                        horizontal = 16.dp
                    )
            ){
                Text(
                    text = stringResource(id = R.string.weight_label),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                DSTextFormField(
                    initialValue = weight,
                    onValueChange = { v -> weight = v},
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.Number,
                    textAlign = TextAlign.End,
                    sufixText = stringResource(R.string.weight_simbols),
                    placeholder = stringResource(R.string.ex_weight)

                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))
                Text(
                    text = stringResource(id = R.string.height_label),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                DSTextFormField(
                    initialValue = height,
                    onValueChange = { v -> height = v},
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.NumberPassword,
                    textAlign = TextAlign.End,
                    sufixText = stringResource(R.string.height_simbols),
                    placeholder = stringResource(R.string.ex_height)
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp))
                DSElevatedButton(
                    text = stringResource(id = R.string.btn_calculate_text),
                    onClick = {
                        navController.navigate("result");
                    }
                )
            }
        }
    )
}

@Preview
@Composable
fun HomeViewPreview(){
    val fakeNavController = rememberNavController()
    HomeView(fakeNavController)
}