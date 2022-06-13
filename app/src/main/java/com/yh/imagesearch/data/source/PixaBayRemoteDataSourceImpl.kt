package com.yh.imagesearch.data.source

import android.util.Log
import com.yh.imagesearch.data.api.PixaBayDto
import com.yh.imagesearch.data.api.PixaBayService
import com.yh.imagesearch.util.Result
import com.yh.imagesearch.util.RetrofitClient
import java.lang.Exception
import javax.inject.Inject

class PixaBayRemoteDataSourceImpl @Inject constructor() : PixaBayRemoteDataSource {

    private val pixaBayService = RetrofitClient.create<PixaBayService>(PixaBayService.baseUrl)

    override suspend fun getImages(searchText: String): Result<PixaBayDto> {
        return try {
            Log.d("test0608", "datasourceImpl")
            val result = pixaBayService.getImages(key = "27905063-0e6d99ff35ddb4a834e3311fd", searchText, imageType = "photo").execute().body()
            Log.d("test0608", "datasourceImpl1")
            Result.Success(result!!)
        } catch (e: Exception) {
            Log.d("test0608", e.toString())
            Result.Error(Exception("에러가 발생"))
        }
    }
}