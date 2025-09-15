package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        // Ambil view untuk update teks
        val titleTv = view.findViewById<TextView>(R.id.coffee_title)
        val descTv = view.findViewById<TextView>(R.id.coffee_desc)
        val backBtn = view.findViewById<Button>(R.id.btn_back)

        // Set konten sesuai id kopi
        when (coffeeId) {
            R.id.affogato -> {
                titleTv.text = getString(R.string.affogato_title)
                descTv.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                titleTv.text = getString(R.string.americano_title)
                descTv.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                titleTv.text = getString(R.string.latte_title)
                descTv.text = getString(R.string.latte_desc)
            }
            R.id.mocha -> {
                titleTv.text = getString(R.string.mocha_title)
                descTv.text = getString(R.string.mocha_desc)
            }
            R.id.cappuccino -> {
                titleTv.text = getString(R.string.cappuccino_title)
                descTv.text = getString(R.string.cappuccino_desc)
            }
            else -> {
                titleTv.text = getString(R.string.coffee_list)
                descTv.text = ""
            }
        }

        // Tombol Back → kembali ke ListFragment
        backBtn.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}
