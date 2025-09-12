package com.devjonathancosta.imc_calculator.domain.entities

import org.junit.Test
import kotlin.test.assertEquals

class IMCTest{

    @Test
    fun `should calculate IMC correctly`() {
        val imc = IMC(weight = 70.0F, height = 1.75F)

        val result = imc.calculate()

        assertEquals(22.86F, result, 0.01F)
    }

    @Test
    fun `should throw exception if weight is = 0`() {
        try {
            IMC(weight = 0.0F, height = 1.75F)
            assert(false)
        } catch (e: IllegalArgumentException) {
            assertEquals("Peso inválido: 0.0. Deve estar entre 1 e 400 kg.", e.message)
        }
    }

    @Test
    fun `should throw exception if weight is greater than 400`() {
        try {
            IMC(weight = 401.0F, height = 1.75F)
            assert(false)
        } catch (e: IllegalArgumentException) {
            assertEquals("Peso inválido: 401.0. Deve estar entre 1 e 400 kg.", e.message)
        }
    }

    @Test
    fun `should throw exception if height is = 0`() {
        try {
            IMC(weight = 70.0F, height = 0.0F)
            assert(false)
        } catch (e: IllegalArgumentException) {
            assertEquals("Altura inválida: 0.0. Deve estar entre 0.5 e 3 metros.", e.message)
        }
    }

    @Test
    fun `should throw exception if height is greater than 3`() {
        try {
            IMC(weight = 70.0F, height = 3.1F)
            assert(false)
        } catch (e: IllegalArgumentException) {
            assertEquals("Altura inválida: 3.1. Deve estar entre 0.5 e 3 metros.", e.message)
        }
    }
}