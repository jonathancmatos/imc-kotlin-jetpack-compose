package com.devjonathancosta.imc_calculator.ui.views.state

import com.devjonathancosta.imc_calculator.core.utils.InputFormField

sealed class IMCState()

data class IMCSuccess(val imc: Float) : IMCState()
data class IMCError(val message: String) : IMCState()

data class IMCFormState(
    val weight: InputFormField = InputFormField(),
    val height: InputFormField = InputFormField()
) : IMCState()
