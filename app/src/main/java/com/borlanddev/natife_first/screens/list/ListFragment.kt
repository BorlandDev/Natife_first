package com.borlanddev.natife_first.screens.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.adapter.ItemsAdapter
import com.borlanddev.natife_first.databinding.FragmentListBinding
import com.borlanddev.natife_first.helpers.APP_PREFERENCES
import com.borlanddev.natife_first.model.Item

class ListFragment : Fragment(R.layout.fragment_list), ListContract.View {
    private lateinit var binding: FragmentListBinding
    private val listPresenter: ListPresenter by lazy {
        ListPresenter(requireContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE))
    }
    private var itemList = listOf<Item>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        listPresenter.attach(this)
        listPresenter.getItems()

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ItemsAdapter(itemList) {
                listPresenter.saveIDtoPref(it.id)

                val direction =
                    ListFragmentDirections.actionListFragmentToDetailsFragment(it.id)
                findNavController().navigate(
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

    override fun showItems(items: List<Item>) {
        this.itemList = items
    }

    override fun onDestroyView() {
        super.onDestroyView()
        listPresenter.detach()
    }
}






