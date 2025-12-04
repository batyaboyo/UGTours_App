package com.ugtours.models

data class User(
    val name: String,
    val email: String,
    val password: String // In a real app, never store plain text passwords
)
