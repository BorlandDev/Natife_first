package com.borlanddev.natife_first.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.databinding.ItemListBinding

class ItemsAdapter(private var onItemClick: (Item) -> Unit) :
    RecyclerView.Adapter<ItemHolder>() {

    private var items: List<Item> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    fun upDateItemsList(_items: List<Item>) {
        items = _items
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemClick)
    }
}

class ItemHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item, onItemClick: (Item) -> Unit) {
        binding.recyclerItemTextView.text = item.name
        binding.recyclerItemTextView.setOnClickListener {
            onItemClick.invoke(item)
        }
    }
}