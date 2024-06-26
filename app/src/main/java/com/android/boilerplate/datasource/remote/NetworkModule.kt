package com.android.boilerplate.datasource.remote

//import com.squareup.moshi.FromJson
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.ToJson
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import retrofit2.converter.moshi.MoshiConverterFactory
//import java.util.Calendar
import com.android.boilerplate.config.AppConfig
import com.android.boilerplate.datasource.local.SharedPrefKeys
import com.android.boilerplate.datasource.local.SharedPreferenceManager
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { APIClient.createClient(get()) }
}

private object APIClient {
    fun createClient(sharedPreferenceManager: SharedPreferenceManager): APIService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val retrofit = Retrofit.Builder()
            .baseUrl(AppConfig.apiEndpoint)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HeaderInterceptor(sharedPreferenceManager))
                    .addInterceptor(logging)
                    .build()
            )
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            )
            .build()
        return retrofit.create(APIService::class.java)
    }

}
/*
private class DateTimeAdapter {

    @ToJson
    fun toJson(card: Calendar): String {
        return AppConfig.dateTimeFormat.format(card.time)
    }

    @FromJson
    fun fromJson(timeString: String): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = AppConfig.dateTimeFormat.parse(timeString) ?: Date()
        return calendar
    }

}*/

private class HeaderInterceptor(private val sharedPreferenceManager: SharedPreferenceManager) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authToken = sharedPreferenceManager.readString(SharedPrefKeys.AUTHORIZATION)
        if (authToken.isNotEmpty())
            chain.run {
                request.newBuilder().addHeader("authorization-header", authToken)
            }
        return chain.proceed(request)
    }

}