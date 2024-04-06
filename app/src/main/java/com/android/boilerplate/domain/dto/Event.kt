package com.android.boilerplate.domain.dto

//import com.squareup.moshi.JsonClass
import java.util.Calendar


//@JsonClass(generateAdapter = true)
data class Event(
    val id: String,
    val name: String, val dateTimeUTC: Calendar
)
