package com.greate43.sk.optussenerio2.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.greate43.sk.optussenerio2.BR
import com.greate43.sk.optussenerio2.R
import com.greate43.sk.optussenerio2.databinding.ListAlbumBinding
import com.greate43.sk.optussenerio2.databinding.ListUsersBinding
import com.greate43.sk.optussenerio2.services.model.Photos
import com.greate43.sk.optussenerio2.services.model.Users
import java.util.*

class AlbumAdapter(val onClickCallback: (photo : Photos) -> Unit) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    private var items: List<Photos> = Collections.emptyList()
    fun setData(photos: List<Photos>) {
        items = photos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListAlbumBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_album,
            parent, false
        )

        return AlbumViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            onClickCallback(items[position])
        }
    }

    class AlbumViewHolder(private val binding: ListAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photos: Photos) {
            binding.apply {
                binding.setVariable(BR.photos, photos)
                binding.executePendingBindings()
            }
        }
    }

}