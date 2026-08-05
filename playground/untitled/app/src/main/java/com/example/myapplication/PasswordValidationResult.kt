package com.example.myapplication

enum class PasswordValidationResult {
    VALID,
    TOO_SHORT,
    NO_UPPERCASE,
    NO_LOWERCASE,
    NO_SPECIAL_CHARACTER,
    EMPTY_STRING
}