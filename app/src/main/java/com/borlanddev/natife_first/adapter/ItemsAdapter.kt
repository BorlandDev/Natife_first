package com.borlanddev.natife_first.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.databinding.ItemListBinding
import com.borlanddev.natife_first.screens.ListFragmentDirections

class ItemsAdapter(private var items: List<Item>) :
    RecyclerView.Adapter<ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)

        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        with(holder.binding) { recyclerItemTextView.text = item.name }
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}

class ItemHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.recyclerItemTextView.setOnClickListener {

            val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)
            itemView.findNavController().navigate(
                direction,
                navOptions {
                    anim {
                        enter = R.anim.enter
                        exit = R.anim.exit
                        popEnter = R.anim.pop_enter
                        popExit = R.anim.pop_exit
                    }
                })
            }
        }

}