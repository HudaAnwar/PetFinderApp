package com.huda.data.common

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder(private val sharedPreferencesManager: SharedPreferencesManager) {

    private val BASE_URL = Constants.BASE_API_URL
    var retrofit: Retrofit? = null

    fun start(): Retrofit? {
        if (retrofit == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY


            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                        .addHeader("Authorization", "Bearer "+sharedPreferencesManager.getToken())
                        .addHeader("Accept", "application/json")
                       .addHeader("Api-Version", "v1")
                        .method(original.method, original.body)
                        .build()
                    chain.proceed(request)
                }
                .build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

              retrofit = Retrofit.Builder().apply {
                baseUrl(BASE_URL)
                addConverterFactory(GsonConverterFactory.create(gson))
                addConverterFactory(ScalarsConverterFactory.create())
            }.client(okHttpClient).build()


        }
        return retrofit
    }

}