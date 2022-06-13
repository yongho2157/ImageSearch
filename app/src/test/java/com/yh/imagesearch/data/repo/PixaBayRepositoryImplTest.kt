package com.yh.imagesearch.data.repo

import com.nhaarman.mockitokotlin2.mock
import com.yh.imagesearch.data.source.PixaBayRemoteDataSource
import com.yh.imagesearch.data.source.PixaBayRemoteDataSourceImplTest.Companion.pixaBayDto
import com.yh.imagesearch.util.Result
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PixaBayRepositoryImplTest {

    private lateinit var pixaBayRepository: PixaBayRepository
    private val pixaBayRemoteDataSource: PixaBayRemoteDataSource = mock()

    @Before
    fun setUp() {
        pixaBayRepository = PixaBayRepositoryImpl(pixaBayRemoteDataSource)
    }

    @Test
    fun getImagesSuccessTest() = runBlocking {
        Mockito.`when`(pixaBayRemoteDataSource.getImages("고양이")).thenReturn(Result.Success(
            pixaBayDto))

        assertEquals((pixaBayRepository.getImages("고양이") as Result.Success), pixaBayRemoteDataSource.getImages("고양이"))
    }

}