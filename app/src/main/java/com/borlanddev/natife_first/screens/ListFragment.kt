package com.borlanddev.natife_first.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.databinding.FragmentListBinding
import com.borlanddev.natife_first.viewModels.ListViewModel

class ListFragment: Fragment(R.layout.fragment_list)  {

    private lateinit var binding: FragmentListBinding
    private val listViewModel by viewModels<ListViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация биндинга
        binding = FragmentListBinding.bind(view)

        // Конфигурируем recycler отображать данные в виде списка
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // Обновляем данные в ресайклере
        binding.recyclerView.adapter = ItemAdapter(ItemList.items)
    }



    private class ItemHolder(view: View): RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private lateinit var item: Item
        val itemTextView: TextView = itemView.findViewById(R.id.recycler_item_text_view)

        init { // ставим слушателя на каждую вьюшку вьюХолдера
            itemView.setOnClickListener(this)
        }

        // Связываем данные с view
        fun bind(item: Item) {

            this.item = item
            itemTextView.text = this.item.name
        }


        override fun onClick(v: View?) {

            // Указываем экшен и передаем в рагмуентах ID
            val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)

            // реализовать передачу ID и сохранение его в Shared preferences
                v?.findNavController()?.navigate(

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




    private inner class ItemAdapter(var items: List<Item>):
            RecyclerView.Adapter<ItemHolder>() {

        // Функция отвечает за создание вьюХолдера на дисплее
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

            // Передаем макет для каждой однотипной вью в ресайклере
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)

            return ItemHolder(view)
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            val item = items[position]

            holder.bind(item)
        }

        override fun getItemCount(): Int = items.size

    }

}





