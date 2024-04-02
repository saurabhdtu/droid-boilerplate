package com.android.boilerplate.config

import java.text.SimpleDateFormat

object AppConfig {
    private const val apiVersion = "v2"
    const val apiEndpoint = "https://dogapi.dog/api/${apiVersion}/"
    val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
}