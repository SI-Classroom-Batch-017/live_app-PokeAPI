package com.example.liveappuserapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.liveappuserapi.MainViewModel
import com.example.liveappuserapi.data.model.Pokemon
import com.example.liveappuserapi.data.model.PokemonDetailResponse
import com.example.liveappuserapi.databinding.ListItemBinding

class ItemAdapter(
    val dataset: List<PokemonDetailResponse>,
    val viewModel: MainViewModel
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.nameTV.text = item.name

        val imageUrl = item.sprites.front_default

        holder.binding.imageIV.load(imageUrl)

        holder.itemView.setOnClickListener {
            viewModel.setPokemon(item)
            holder.itemView.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }
    }
}