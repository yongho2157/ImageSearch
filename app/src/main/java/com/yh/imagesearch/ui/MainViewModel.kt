package com.yh.imagesearch.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.yh.imagesearch.base.BaseViewModel
import com.yh.imagesearch.data.repo.PixaBayRepository
import com.yh.imagesearch.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val pixaBayRepository: PixaBayRepository,
) : BaseViewModel(app) {

    val inputTextLiveData = MutableLiveData<String>()

    fun images() {
        CoroutineScope(Dispatchers.IO).launch {
            if (!inputTextLiveData.value.isNullOrEmpty()) {
                when (val result = pixaBayRepository.getImages(inputTextLiveData.value!!)) {
                    is Result.Success ->
                        viewStateChange(MainViewState.GetImages(result.data.hits))
                    is Result.Error ->
                        viewStateChange(MainViewState.Error(result.exception.message
                            ?: "데이터를 가져오지 못했습니다."))
                }
            } else {
                viewStateChange(MainViewState.Error("데이터가 없습니다."))
            }
        }
    }

}