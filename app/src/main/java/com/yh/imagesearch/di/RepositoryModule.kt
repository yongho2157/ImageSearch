package com.yh.imagesearch.di

import com.yh.imagesearch.data.repo.PixaBayRepository
import com.yh.imagesearch.data.repo.PixaBayRepositoryImpl
import com.yh.imagesearch.data.source.PixaBayRemoteDataSource
import com.yh.imagesearch.data.source.PixaBayRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPixaBayRepository(pixaBayRepositoryImpl: PixaBayRepositoryImpl) : PixaBayRepository

    @Binds
    @Singleton
    abstract fun bindPixaBatRemoteDataSource(pixaBayRemoteDataSourceImpl: PixaBayRemoteDataSourceImpl) : PixaBayRemoteDataSource

}