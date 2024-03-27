package com.android.boilerplate.datasource.remote

import retrofit2.HttpException

sealed class APIResult<out T> {
    data class Success<T>(val data: T) : APIResult<T>()
    data class Error(
        val errorMessage: String?,
        val statusCode: Int?,
        val exception: Throwable?
    ) : APIResult<Nothing>()
}

suspend fun <T> safeApiCall(apiCall: suspend () -> T): APIResult<T> {
    return try {
        val response = apiCall.invoke()
        APIResult.Success(response)
    } catch (ex: Exception) {
        when (ex) {
            is HttpException -> {
                val errorBody = parseErrorBody(ex)
                APIResult.Error(errorBody, 500, ex)
            }

            else -> {
                APIResult.Error(ex.message, 500, ex)
            }
        }
    }
}

private fun parseErrorBody(exception: HttpException): String? {
    val errorBody = exception.response()?.errorBody()
    return errorBody?.string()
}