package com.example.sd2.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sd2.R
import com.example.sd2.State
import com.example.sd2.databinding.ItemUserBinding
import com.example.sd2.di.network.User


class PageListAdapter()
    : PagedListAdapter<User, PageListAdapter.ViewHolder>(NewsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageListAdapter.ViewHolder {

        val binding: ItemUserBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)    }

    override fun onBindViewHolder(holder: PageListAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    companion object {
        val NewsDiffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.equals( newItem)
            }
        }
    }

    var onItemClick: ((User)->Unit) ?= null


    inner class ViewHolder(val binding:ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User?) {
            binding.userTitle.text = item?.name
            binding.root.setOnClickListener {
                item?.let { it1 -> onItemClick?.invoke(it1) }
            }
        }

    }
}