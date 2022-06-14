package com.yh.imagesearch.data.repo

import com.nhaarman.mockitokotlin2.mock
import com.yh.imagesearch.data.api.PixaBayService
import com.yh.imagesearch.data.source.PixaBayRemoteDataSource
import com.yh.imagesearch.data.source.PixaBayRemoteDataSourceImplTest.Companion.pixaBayDto
import com.yh.imagesearch.util.Result
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

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

    @Test
    fun getImagesFailureTest() = runBlocking {
        val failResult = Result.Error(Exception("에러가 발생"))

        Mockito.`when`(pixaBayRemoteDataSource.getImages("고양이")).then{ failResult }
        assertEquals(pixaBayRepository.getImages("고양이") as Result.Error, pixaBayRemoteDataSource.getImages("고양이"))
//        Mockito.`when`(kakaoService.getLanguage(query = "안드로이드", srcLang = "kr", targetLang = "en")).then { failResult }
//        assertEquals((remoteDataSource.getText(query = "안드", srcLang = "k", targetLang = "e") as kotlin.Result.Error).exception.message, failResult.exception.message)
    }

}