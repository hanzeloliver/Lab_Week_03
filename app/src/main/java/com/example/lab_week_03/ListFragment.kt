package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pastikan id berikut ada di fragment_list.xml
        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte)
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                // Kirim paket argumen ke DetailFragment dengan key "coffeeId"
                val bundle = Bundle().apply {
                    putInt("coffeeId", coffee.id)
                }
                // Gunakan action id yang ada di nav_graph.xml
                findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }
}
