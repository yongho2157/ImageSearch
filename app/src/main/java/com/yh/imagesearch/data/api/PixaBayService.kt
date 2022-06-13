package com.yh.imagesearch.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PixaBayService {

    companion object {
        const val baseUrl = "https://pixabay.com/"
    }

    @GET("api/")
    fun getImages(
        @Query("key") key: String,
        @Query("q") searchText: String,
        @Query("image_type") imageType: String
    ): Call<PixaBayDto>

}