package com.devjonathancosta.imc_calculator.core.utils

object Utils {
    fun converttedToFloat(value: String): Float {
        if (value.endsWith(",") || value.endsWith(".")) return 0f
        return value.replace(",", ".").toFloatOrNull() ?: 0f
    }
}