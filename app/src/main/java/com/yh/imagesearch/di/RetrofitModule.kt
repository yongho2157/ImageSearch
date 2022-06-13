package com.yh.imagesearch.di

import com.yh.imagesearch.data.api.PixaBayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providePixaBayApi(): PixaBayService {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixaBayService::class.java)
    }
    }
////    fun providePixaBayApi(): PixaBayService {
////        return Retrofit.Builder()
//            .baseUrl("https://pixabay.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(PixaBayService::class.java)
//    }
//}
