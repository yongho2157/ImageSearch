package com.yh.imagesearch.data.source

import com.yh.imagesearch.data.api.PixaBayDto
import com.yh.imagesearch.data.api.PixaBayService
import com.yh.imagesearch.util.Result
import javax.inject.Inject


class PixaBayRemoteDataSourceImpl @Inject constructor(private val pixaBayService: PixaBayService) : PixaBayRemoteDataSource {

    override suspend fun getImages(searchText: String): Result<PixaBayDto> {
        return try {
            val result = pixaBayService.getImages(key = "27905063-0e6d99ff35ddb4a834e3311fd", searchText, imageType = "photo").execute().body()
            Result.Success(result!!)
        } catch (e: Exception) {
            Result.Error(Exception("에러가 발생"))
        }
    }
}