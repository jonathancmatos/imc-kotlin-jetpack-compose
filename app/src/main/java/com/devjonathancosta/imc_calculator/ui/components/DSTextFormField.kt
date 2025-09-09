package com.devjonathancosta.imc_calculator.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devjonathancosta.imc_calculator.ui.theme.Gray900
import com.devjonathancosta.imc_calculator.ui.theme.Green300

@Composable
fun DSTextFormField(
    initialValue: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean,
    maxLines: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    textAlign: TextAlign = TextAlign.Start,
    sufixText: String? = null,
){
    return OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = initialValue,
        onValueChange = onValueChange,
        singleLine = singleLine,
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        shape = RoundedCornerShape(16.dp),
        textStyle = TextStyle(
            textAlign = textAlign,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
        ),
        suffix = {
            Text(sufixText ?: "",
                style = MaterialTheme.typography.bodySmall,
                color = Gray900
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Green300,
            unfocusedContainerColor = Green300,
            disabledContainerColor = Green300,
            cursorColor = Gray900,
            focusedTextColor = Gray900,
            unfocusedTextColor = Gray900,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        )
    );
}