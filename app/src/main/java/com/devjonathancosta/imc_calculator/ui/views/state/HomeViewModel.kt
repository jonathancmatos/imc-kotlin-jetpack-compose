package com.devjonathancosta.imc_calculator.ui.views.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.devjonathancosta.imc_calculator.domain.entities.IMC

class HomeViewModel : ViewModel() {
    private val _imcState = mutableStateOf<IMCState>(IMCFormState())
    private val getCurrentState: IMCFormState get() = _imcState.value as? IMCFormState ?: IMCFormState()
    val imcState: State<IMCState> get() = _imcState

    fun onWeightChange(value: String) {
        _imcState.value = getCurrentState.copy(
            weight = getCurrentState.weight.copy(value = value, error = null)
        )
    }

    fun onHeightChange(value: String) {
        _imcState.value = getCurrentState.copy(
            height = getCurrentState.height.copy(value = value, error = null)
        )
    }

    fun calculateIMC(weight: Float, height: Float) {
        try {
            val imc  = IMC(weight, height)
            val result = imc.calculate()
            _imcState.value = IMCSuccess(imc = result)

        }catch (e: Exception) {
            _imcState.value = IMCError(message = e.message ?: "Unknown error")
        }
    }
}
