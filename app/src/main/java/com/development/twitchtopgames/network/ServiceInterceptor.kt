package com.development.twitchtopgames.network

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor(private val clientId: String) : Interceptor {
    private val ACCEPT_HEADER = "application/vnd.twitchtv.v5+json"

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Client-ID", clientId)
            .addHeader("Accept", ACCEPT_HEADER)
            .build()

        return chain.proceed(request)
    }
}