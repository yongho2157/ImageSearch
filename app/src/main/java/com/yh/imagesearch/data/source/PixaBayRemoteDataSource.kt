package com.yh.imagesearch.data.source

import com.yh.imagesearch.data.api.PixaBayDto
import com.yh.imagesearch.util.Result

interface PixaBayRemoteDataSource {

    suspend fun getImages(searchText: String) : Result<PixaBayDto>

}