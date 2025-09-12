package com.devjonathancosta.imc_calculator.domain.entities

class IMC(
    val weight: Float,
    val height: Float
){
    init {
        require(weight > 0f && weight <= 400f){
            "Peso inválido: $weight. Deve estar entre 1 e 400 kg."
        }
        require(height > 0f && height <= 3f){
            "Altura inválida: $height. Deve estar entre 0.5 e 3 metros."
        }
    }

    fun calculate(): Float{
        return weight / (height * height)
    }
}
