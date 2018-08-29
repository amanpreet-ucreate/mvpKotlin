package com.aman.user.mvpkotlin.Utilities.api

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by Amanpreet Singh on 28 Aug 2018.
 */
interface WebserviceMethods {

    @GET("api.php")
    fun getData(@Query("action") action: String,
                @Query("format") format: String,
                @Query("list") list: String,
                @Query("srsearch") srsearch: String) : Observable<com.aman.user.mvpkotlin.Models.Pojos.Result>

    /**
     * Companion object to create the WebserviceMethods
     * @see https://medium.com/@agrawalsuneet/companion-object-in-kotlin-5251e03d6423
     */
    companion object Factory {

        fun create(): WebserviceMethods {
            val client  = OkHttpClient()
            client.newBuilder().connectTimeout(30,TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .readTimeout(30,TimeUnit.SECONDS)
            val retrofit = Retrofit.Builder().client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(UtilRes.BASE_URL)
                    .build()

            return retrofit.create(WebserviceMethods::class.java);
        }
    }

}