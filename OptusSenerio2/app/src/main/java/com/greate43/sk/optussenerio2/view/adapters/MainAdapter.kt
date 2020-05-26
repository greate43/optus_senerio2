package com.greate43.sk.optussenerio2.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.greate43.sk.optussenerio2.BR
import com.greate43.sk.optussenerio2.R
import com.greate43.sk.optussenerio2.databinding.ListUsersBinding
import com.greate43.sk.optussenerio2.services.model.Users
import java.util.*

class MainAdapter(val onClickCallback: (user : Users) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var items: List<Users> = Collections.emptyList()
    fun setData(users: List<Users>) {
        items = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListUsersBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_users,
            parent, false
        )

        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            onClickCallback(items[position])
        }
    }

    class MainViewHolder(private val binding: ListUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(users: Users) {
            binding.apply {
                binding.setVariable(BR.user, users)
                binding.executePendingBindings()
//                userId.text = users.id.toString()
//                userEmail.text = users.email
//                userName.text = users.name
//                userPhoneNumber.text = users.phone
            }
        }
    }

}