package com.example.supabase_example

import kotlinx.serialization.Serializable

@Serializable
data class Instrument(
    val id: Int? = null,
    val name: String,
)