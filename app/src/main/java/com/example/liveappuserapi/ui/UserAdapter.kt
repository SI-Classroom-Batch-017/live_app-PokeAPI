package com.example.liveappuserapi.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.liveappuserapi.R
import com.example.liveappuserapi.data.model.User
import com.example.liveappuserapi.databinding.UserItemBinding

class UserAdapter(
    val dataset: List<User>
) : RecyclerView.Adapter<UserAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = dataset[position]

        holder.binding.userNameTV.text = user.name
        holder.binding.userMailTV.text = user.email

        if(user.liked){
            holder.binding.userCV.setCardBackgroundColor(holder.binding.root.context.getColor(R.color.green))
        } else {
            holder.binding.userCV.setCardBackgroundColor(Color.TRANSPARENT)

        }

        holder.binding.userCV.setOnClickListener {
            user.liked = !user.liked
            notifyDataSetChanged()
        }

    }
}