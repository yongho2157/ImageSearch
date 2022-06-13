package com.yh.imagesearch.ui

import com.yh.imagesearch.base.ViewState
import com.yh.imagesearch.data.api.PixaBayModel

sealed class MainViewState : ViewState {
    data class GetImages(val data: List<PixaBayModel>): MainViewState()
    data class Error(val message: String): MainViewState()
}
