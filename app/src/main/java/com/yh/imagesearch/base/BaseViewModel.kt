package com.yh.imagesearch.base

import android.app.Application
import androidx.annotation.MainThread
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    private val _viewStateLiveData = MutableLiveData<ViewState>()
    val viewStateLiveData: LiveData<ViewState>
        get() = _viewStateLiveData

    @MainThread
    protected fun viewStateChange(viewState: ViewState) {
        viewModelScope.launch {
            _viewStateLiveData.value = viewState
        }
    }

}

interface ViewState