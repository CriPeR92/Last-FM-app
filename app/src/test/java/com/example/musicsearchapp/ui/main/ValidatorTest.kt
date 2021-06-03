package com.example.musicsearchapp.ui.main

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whenInputIsValid() {
        val search = "Hello"
        val result = Validator.validateInput(search)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInValid() {
        val search = ""
        val result = Validator.validateInput(search)
        assertThat(result).isEqualTo(false)
    }

}