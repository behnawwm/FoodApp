package com.example.foodapp.ui.Home.fragments.menu.menuPreview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.foodapp.R
import com.example.foodapp.data.models.MenuPreviewItem
import com.example.foodapp.databinding.ItemMenuPreviewBinding

class MenuPreviewItemsAdapter(val listener: OnItemPressListener) :
    ListAdapter<MenuPreviewItem, MenuPreviewItemsAdapter.MenuPreviewItemsViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuPreviewItemsViewHolder {
        val binding =
            ItemMenuPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MenuPreviewItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuPreviewItemsViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null)
            holder.bind(currentItem)
    }


    inner class MenuPreviewItemsViewHolder(private val binding: ItemMenuPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                var position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    var item = getItem(position)
                    if (item != null) {
                        listener.OnItemClick(item)
                    }
                }
            }
        }

        fun bind(item: MenuPreviewItem) {
            binding.apply {
                if (item.url == "")
                    Glide.with(itemView)
                        .load(item.photoDrawable)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.photo_pizza)
                        .into(binding.imageView)
                else
                    Glide.with(itemView)
                        .load(item.url)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.photo_pizza)
                        .into(binding.imageView)


                tvCategory.text = item.category
                tvRatings.text = item.rating.toString()
                tvTitle.text = item.title
                tvDesc.text = item.location
            }
        }
    }


    interface OnItemPressListener {
        fun OnItemClick(item: MenuPreviewItem)
    }

    object DIFF_CALLBACK : DiffUtil.ItemCallback<MenuPreviewItem>() {
        override fun areItemsTheSame(oldItem: MenuPreviewItem, newItem: MenuPreviewItem): Boolean =
            newItem.id == oldItem.id


        override fun areContentsTheSame(
            oldItem: MenuPreviewItem,
            newItem: MenuPreviewItem
        ): Boolean =
            newItem == oldItem

    }
}