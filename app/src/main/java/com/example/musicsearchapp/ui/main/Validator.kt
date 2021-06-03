package com.example.musicsearchapp.ui.main

object Validator {

    /**
     * Function to validate if the input to search the tracks is valid
     */
    fun validateInput(searchInput: String) : Boolean {
        return searchInput.isNotEmpty()
    }
}