package com.yh.imagesearch.data.source

import com.nhaarman.mockitokotlin2.mock
import com.yh.imagesearch.data.api.PixaBayDto
import com.yh.imagesearch.data.api.PixaBayModel
import com.yh.imagesearch.data.api.PixaBayService
import com.yh.imagesearch.util.Result
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import okhttp3.Request
import okio.Timeout
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class PixaBayRemoteDataSourceImplTest {

    private lateinit var pixaBayRemoteDataSource: PixaBayRemoteDataSource
    private val pixaBatService: PixaBayService = mock()

    @Before
    fun setUp() {
        initMockPixaBayApi()
        pixaBayRemoteDataSource = PixaBayRemoteDataSourceImpl(pixaBatService)
    }

    @Test
    fun getImagesSuccessTest() = runBlocking {
        assertEquals((pixaBayRemoteDataSource.getImages(searchText = "고양이") as Result.Success).data, pixaBayDto)
    }

    @Test
    fun getImagesFailureTest() = runBlocking {
        val failResult = Result.Error(Exception("에러가 발생"))
        Mockito.`when`(pixaBatService.getImages(key = "27905063-0e6d99ff35ddb4a834e3311fd", searchText = "고양이", imageType = "photo")).then {failResult}
        assertEquals((pixaBayRemoteDataSource.getImages("ㅂ") as Result.Error).exception.message, failResult.exception.message)
    }

    private fun initMockPixaBayApi() {
        val call = object : Call<PixaBayDto> {
            override fun execute(): Response<PixaBayDto> {
                return Response.success(pixaBayDto)
            }

            override fun clone(): Call<PixaBayDto> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<PixaBayDto>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

        }

        Mockito.`when`(pixaBatService.getImages(key = "27905063-0e6d99ff35ddb4a834e3311fd", searchText="고양이", imageType = "photo")).thenReturn(call)
    }

    companion object {
        val pixaBayDto = PixaBayDto(
            listOf(
                PixaBayModel(
                    collections = 2043,
                    comments = 469,
                    downloads = 454264,
                    id = 735877,
                    imageHeight = 1282,
                    imageSize = 97150,
                    imageWidth = 1920,
                    largeImageURL = "https://pixabay.com/get/g1b5b03a98c2a3370818e207ac85262ee44055dee07775637b0ce78b715a88d311cd4a21e95e6f149ed9731776509e64a9f6f741d3b398ff9a59d00f4dcdbc982_1280.jpg",
                    likes = 2477,
                    pageURL = "https://pixabay.com/photos/tree-cat-silhouette-moon-full-moon-736877/",
                    previewHeight = 150,
                    previewURL = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877_150.jpg",
                    previewWidth = 640,
                    tags = "tree, cat, silhouette",
                    type = "photo",
                    user = "Bessi",
                    userImageURL = "https://cdn.pixabay.com/user/2019/04/11/22-45-05-994_250x250.jpg",
                    user_id = 909086,
                    views = 951782,
                    webformatHeight = 427,
                    webformatURL = "https://pixabay.com/get/g01fac8edad9074a0a546afa74caef3c3e27e826117946a411b75316537eeffad01bda2b109e83d8707fde33bddc0d02b_640.jpg",
                    webformatWidth = 640
                )
            ), 26959, 500
        )

    }

}