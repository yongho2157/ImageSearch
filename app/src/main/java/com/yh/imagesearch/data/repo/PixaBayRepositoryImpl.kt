package com.yh.imagesearch.data.repo

import com.yh.imagesearch.data.api.PixaBayDto
import com.yh.imagesearch.data.source.PixaBayRemoteDataSource
import com.yh.imagesearch.util.Result
import javax.inject.Inject

class PixaBayRepositoryImpl @Inject constructor(val pixaBayRemoteDataSource: PixaBayRemoteDataSource) :
    PixaBayRepository {
    override suspend fun getImages(searchText: String): Result<PixaBayDto> =
        pixaBayRemoteDataSource.getImages(searchText)

}