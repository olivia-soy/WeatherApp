package com.olivia.weatherapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olivia.weatherapp.databinding.ItemWeatherBinding
import com.olivia.weatherapp.databinding.ItemWeatherHeaderBinding
import com.olivia.weatherapp.domain.model.LocationModel

/**
 * WeatherApp
 * WeatherAdapter
 * @author leesoyoung
 * @since 2022/05/06
 */
class WeatherAdapter : ListAdapter<ListItem, RecyclerView.ViewHolder>(
    diffUtil
) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ListItem.HeaderItem -> ITEM_VIEW_TYPE_HEADER
            is ListItem.DataItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> {
                HeaderViewHolder(
                    ItemWeatherHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                WeatherViewHolder(
                    ItemWeatherBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is WeatherViewHolder -> {
                holder.bind((getItem(position) as ListItem.DataItem).locationModel)
            }
        }
    }

    class WeatherViewHolder(
        private val binding: ItemWeatherBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: LocationModel?) {
            model?.let {
                binding.model = model
            }
        }
    }

    class HeaderViewHolder(
        binding: ItemWeatherHeaderBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
    }


    companion object {
        private const val ITEM_VIEW_TYPE_HEADER = 0
        private const val ITEM_VIEW_TYPE_ITEM = 1
        val diffUtil = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(
                oldItem: ListItem,
                newItem: ListItem
            ) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ListItem,
                newItem: ListItem
            ) =
                oldItem == newItem

        }
    }
}

sealed class ListItem {
    abstract val id: Int

    data class DataItem(
        val locationModel: LocationModel
    ) : ListItem() {
        override val id: Int
            get() = locationModel.id
    }

    object HeaderItem : ListItem() {
        override val id: Int
            get() = 0
    }
}