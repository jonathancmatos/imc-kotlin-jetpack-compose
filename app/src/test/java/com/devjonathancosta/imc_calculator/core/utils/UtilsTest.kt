package com.devjonathancosta.imc_calculator.core.utils

import com.devjonathancosta.imc_calculator.domain.entities.IMC
import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest{

    @Test
    fun `should convert valid float with dot`() {
        val result = Utils.converttedToFloat("12.5")
        assertEquals(12.5f, result)
    }

    @Test
    fun `should convert valid float with comma`() {
        val result = Utils.converttedToFloat("12,5")
        assertEquals(12.5f, result)
    }

    @Test
    fun `should return 0f for empty string`() {
        val result = Utils.converttedToFloat("")
        assertEquals(0f, result)
    }

    @Test
    fun `should return 0f for invalid string`() {
        val result = Utils.converttedToFloat("abc")
        assertEquals(0f, result)
    }

    @Test
    fun `should return 0f for number with trailing comma`() {
        val result = Utils.converttedToFloat("123,")
        assertEquals(0f, result)
    }

    @Test
    fun `should return 0f for number with trailing dot`() {
        val result = Utils.converttedToFloat("123.")
        assertEquals(0f, result)
    }
}