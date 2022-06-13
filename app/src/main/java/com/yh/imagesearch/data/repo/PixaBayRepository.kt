package com.yh.imagesearch.data.repo

import com.yh.imagesearch.data.api.PixaBayDto
import com.yh.imagesearch.util.Result

interface PixaBayRepository {

    suspend fun getImages(searchText: String) : Result<PixaBayDto>

}