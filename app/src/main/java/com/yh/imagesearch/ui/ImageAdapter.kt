package com.yh.imagesearch.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yh.imagesearch.databinding.ItemImagesBinding

class ImageAdapter: RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val dataList = mutableListOf<String>()

    class ImageViewHolder(private val binding: ItemImagesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Log.d("test0608", imageUrl)
            Glide.with(binding.root)
                .load(imageUrl)
                .into(binding.imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {  
        Log.d("test0608", "size " + dataList.size)
        return dataList.size
    }

    fun addAll(imageUrl: ArrayList<String>) {
        dataList.clear()
        dataList.addAll(imageUrl)
        notifyDataSetChanged()
    }
}