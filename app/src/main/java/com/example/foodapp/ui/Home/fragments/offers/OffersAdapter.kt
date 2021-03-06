package com.example.foodapp.ui.Home.fragments.offers

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

class OffersAdapter(val listener: OnItemPressListener) :
    ListAdapter<OfferItem, OffersAdapter.OffersViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val binding = ItemOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OffersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null)
            holder.bind(currentItem)
    }


    inner class OffersViewHolder(private val binding: ItemOfferBinding) :
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
                tvRatingsNumber.text = "(${item.numOfRatings} ratings)"
                tvDesc.text = item.location
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