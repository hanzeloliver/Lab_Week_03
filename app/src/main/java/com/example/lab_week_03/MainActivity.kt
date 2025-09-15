package com.example.lab_week_03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle window insets (boleh dipertahankan, ini bawaan template)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tambahkan ListFragment pertama kali
        if (savedInstanceState == null) {
            findViewById<FragmentContainerView>(R.id.fragment_container).let { containerLayout ->
                val listFragment = ListFragment()
                supportFragmentManager.beginTransaction()
                    .add(containerLayout.id, listFragment)
                    .commit()
            }
        }
    }

    override fun onSelected(id: Int) {
        // Buat DetailFragment baru
        val detailFragment = DetailFragment()

        findViewById<FragmentContainerView>(R.id.fragment_container).let { containerLayout ->
            supportFragmentManager.beginTransaction()
                .replace(containerLayout.id, detailFragment)
                .addToBackStack(null) // supaya bisa back ke ListFragment
                .commit()
        }

        // Tunggu transaksi selesai, lalu update data
        supportFragmentManager.executePendingTransactions()
        detailFragment.setCoffeeData(id)
    }
}
