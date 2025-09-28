package com.devjonathancosta.imc_calculator.core.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import kotlin.test.Test

class InputFormFieldTest {

    @Test
    fun `should create InputFormField with default values`() {
        val field = InputFormField()
        assertNull(field.value)
        assertNull(field.error)
    }

    @Test
    fun `should create InputFormField with only value`() {
        val field = InputFormField(value = "80")
        assertEquals("80", field.value)
        assertNull(field.error)
    }

    @Test
    fun `should create InputFormField with only error`() {
        val field = InputFormField(error = "Campo obrigatório")
        assertNull(field.value)
        assertEquals("Campo obrigatório", field.error)
    }

    @Test
    fun `should create InputFormField with value and error`() {
        val field = InputFormField(value = "170", error = "Formato inválido")
        assertEquals("170", field.value)
        assertEquals("Formato inválido", field.error)
    }

    @Test
    fun `should copy InputFormField and change only value`() {
        val field = InputFormField(value = "70", error = "Inválido")
        val updated = field.copy(value = "75")
        assertEquals("75", updated.value)
        assertEquals("Inválido", updated.error)
    }

    @Test
    fun `should copy InputFormField and clear error`() {
        val field = InputFormField(value = "100", error = "Inválido")
        val updated = field.copy(error = null)
        assertEquals("100", updated.value)
        assertNull(updated.error)
    }

    @Test
    fun `should be equal when value and error are the same`() {
        val f1 = InputFormField(value = "50", error = "Inválido")
        val f2 = InputFormField(value = "50", error = "Inválido")
        assertEquals(f1, f2)
    }

    @Test
    fun `should not be equal when value differs`() {
        val f1 = InputFormField(value = "50")
        val f2 = InputFormField(value = "51")
        assertNotEquals(f1, f2)
    }

    @Test
    fun `should not be equal when error differs`() {
        val f1 = InputFormField(value = "50", error = "A")
        val f2 = InputFormField(value = "50", error = "B")
        assertNotEquals(f1, f2)
    }

}