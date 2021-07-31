package com.example.foodapp.ui.Home.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.foodapp.R
import com.example.foodapp.data.models.OfferItem
import com.example.foodapp.databinding.ItemOfferBinding
import com.example.foodapp.databinding.ItemRecentItemsBinding

class RecentItemsAdapter(val listener: OnItemPressListener) :
    ListAdapter<OfferItem, RecentItemsAdapter.RecentItemsViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentItemsViewHolder {
        val binding =
            ItemRecentItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecentItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentItemsViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null)
            holder.bind(currentItem)
    }


    inner class RecentItemsViewHolder(private val binding: ItemRecentItemsBinding) :
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

        fun bind(item: OfferItem) {
            binding.apply {
                if (item.url == "")
                    Glide.with(itemView)
                        .load(item.photoDrawable)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.photo_pizza)
                        .into(binding.ivPhoto)
                else
                    Glide.with(itemView)
                        .load(item.url)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.photo_pizza)
                        .into(binding.ivPhoto)

                tvCategory.text = item.category
                tvRating.text = item.rating.toString()
                tvTitle.text = item.title
                tvRatingsNumber.text = "(${item.numOfRatings} ratings)"
                tvLocation.text = item.location
            }
        }
    }


    interface OnItemPressListener {
        fun OnItemClick(item: OfferItem)
    }

    object DIFF_CALLBACK : DiffUtil.ItemCallback<OfferItem>() {
        override fun areItemsTheSame(oldItem: OfferItem, newItem: OfferItem): Boolean =
            newItem.id == oldItem.id


        override fun areContentsTheSame(oldItem: OfferItem, newItem: OfferItem): Boolean =
            newItem == oldItem

    }
}