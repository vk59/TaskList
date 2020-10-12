package com.vk59.tasklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk59.tasklist.databinding.ItemListBinding
import com.vk59.tasklist.db.Task

class ItemViewHolder(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    val binding: ItemListBinding = binding

    fun bind(task: Task, itemClickListener: ItemClickListener) {
        binding.task = task
        binding.clickListener = itemClickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ItemViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemListBinding = ItemListBinding.inflate(inflater, parent, false)
            return ItemViewHolder(binding)
        }
    }
}