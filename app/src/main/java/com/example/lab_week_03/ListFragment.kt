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

        // Tambahkan semua kopi (total 5 item sesuai assignment)
        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte),
            view.findViewById<View>(R.id.mocha),
            view.findViewById<View>(R.id.cappuccino)
        )

        // Pasang listener untuk setiap item kopi
        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                // Kirim id kopi yang dipilih ke DetailFragment
                val bundle = Bundle().apply {
                    putInt("coffeeId", coffee.id)
                }
                findNavController().navigate(
                    R.id.action_listFragment_to_detailFragment,
                    bundle
                )
            }
        }
    }
}
