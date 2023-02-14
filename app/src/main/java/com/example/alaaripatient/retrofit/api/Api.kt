package com.example.alaaripatient.retrofit.api

import com.example.alaaripatient.activity.allcustomerrecyler.CustomerResponse
import com.example.alaaripatient.booking.fragment.durationresponse.DurationResponse
import com.example.alaaripatient.editprofile.EditProfileResponse
import com.example.alaaripatient.loginacitivity.mvvm.LoginDataClass
import com.example.alaaripatient.profile.fragment.profileresponse.ProfileResonse
import com.example.alaaripatient.home.fragement.retrofitmvvm.CousellingResponse
import com.example.alaaripatient.profile.fragment.retrofituserprofile.UserProfileDataClass
import com.example.alaaripatient.home.fragement.reyleronlinefaq.ServiserResponse
import com.example.alaaripatient.signupresponsedata.RegisterResponse
import com.example.alaaripatient.usersigndataclass.LoginResponse
import com.example.alaaripatient.usersigndataclass.SignupResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("v1/auth/signup")
    suspend fun userregister(@Body modal:SignupResponse):Response<RegisterResponse>

    @POST("v1/auth/login")
    suspend fun login(@Body login:LoginResponse):Response<LoginDataClass>

    @Headers("Content-Type: application/json")
    @GET("v1/topic/getAllTopics")
    suspend fun getalltopices(@Header("Authorization")token:String): Response<CousellingResponse>

    @Headers("Content-Type: application/json")
    @GET("v1/services/getservices")
    fun services(@Header("Authorization")token:String): Call<ServiserResponse>

    @Headers("Content-Type: application/json")
    @PUT("v1/doctor/updatePersonalInformation")
    suspend fun editUserProfile(@Header("Authorization")token:String,@Body editProfile: UserProfileDataClass): Response<EditProfileResponse>

    @Headers("Content-Type: application/json")
    @GET("v1/doctor/dataByConsultantId")
    suspend fun getUserProfile(@Header("Authorization")token: String):Response<ProfileResonse>

    @Headers("Content-Type: application/json")
    @GET("v1/contacts")
    suspend fun getAllCustomer():Response<CustomerResponse>

    @GET("v1/duration")
    suspend fun getDuration(@Header("Authorization")token: String):Response<DurationResponse>

}