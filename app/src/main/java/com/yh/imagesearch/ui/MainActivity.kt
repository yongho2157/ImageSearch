package com.yh.imagesearch.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yh.imagesearch.R
import com.yh.imagesearch.base.BaseActivity
import com.yh.imagesearch.data.api.PixaBayModel
import com.yh.imagesearch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val itemAdapter by lazy { ImageAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        initViewModel()
    }

    private fun initUi() {
        with(binding) {
            viewModel = mainViewModel
            rv.adapter = itemAdapter
            rv.layoutManager = GridLayoutManager(this@MainActivity, 3)
        }
    }

    private fun initViewModel() {
        mainViewModel.viewStateLiveData.observe(this) { viewState->
            when (viewState) {
                is MainViewState.GetImages ->
                    getImage(viewState.data)
            }
        }
    }

    private fun getImage(images: List<PixaBayModel>) {
        val mockList = ArrayList<String>().apply {
            for (i in images.indices) {
                this.add(images[i].previewURL)
            }
        }

        itemAdapter.addAll(mockList)

    }

}