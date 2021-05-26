package com.example.sd2.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sd2.databinding.GridItemUserBinding
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso


class GridListAdapter(var context: Context) : RecyclerView.Adapter<GridListAdapter.ViewHolder>() {


    private  var list: List<String> = emptyList<String>()
//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: GridItemUserBinding = GridItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    fun setAdapterList(list: List<String> ){
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = list.size

   inner class ViewHolder(val binding: GridItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
       var picasso: Picasso
       init {
           val downloader = OkHttp3Downloader(context)
            picasso =    Picasso.Builder(context).downloader(downloader).build()
       }
        fun bind(data: String) {

            picasso.load(data).into(binding.image)

        }
    }
}
