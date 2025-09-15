package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_detail.xml
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil argumen yang dikirim (key = "coffeeId")
        val coffeeId = arguments?.getInt("coffeeId") ?: 0

        // Ambil view untuk update teks (pastikan id ada di fragment_detail.xml)
        val titleTv = view.findViewById<TextView>(R.id.coffee_title)
        val descTv = view.findViewById<TextView>(R.id.coffee_desc)

        when (coffeeId) {
            R.id.affogato -> {
                titleTv?.text = getString(R.string.affogato_title)
                descTv?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                titleTv?.text = getString(R.string.americano_title)
                descTv?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                titleTv?.text = getString(R.string.latte_title)
                descTv?.text = getString(R.string.latte_desc)
            }
            else -> {
                titleTv?.text = getString(R.string.coffee_list)
                descTv?.text = ""
            }
        }
    }
}

