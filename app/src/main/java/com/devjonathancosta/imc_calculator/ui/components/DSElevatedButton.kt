@file:Suppress("UNCHECKED_CAST")

package com.devjonathancosta.imc_calculator.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devjonathancosta.imc_calculator.ui.theme.Green500
import com.devjonathancosta.imc_calculator.ui.theme.White

@Composable
fun DSElevatedButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    return ElevatedButton(
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Green500
        ),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.fillMaxWidth().height(56.dp),
        onClick = onClick,
    ) {
        Text(text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = White
            )
        )
    }
}