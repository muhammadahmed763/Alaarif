package com.example.alaaripatient.retrofit.instance

import com.example.alaaripatient.constantvariables.ConstantVariables
import com.example.alaaripatient.retrofit.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    val api: Api by lazy {
        var retrofit= Retrofit.Builder()
            .baseUrl(
                ConstantVariables.BASEURL
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(Api::class.java)
    }
}