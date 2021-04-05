package com.amirhusseinsoori.diffutilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.amirhusseinsoori.diffutilsample.adabter.DiffAdapter
import com.amirhusseinsoori.diffutilsample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = DiffAdapter()


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)



        //setData update recyclerView
        adapter.setData(
            listOf(
                User(1, "amir", "22"),
                User(2, "hussein", "25"),
                User(3, "asghar", "26")
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter


    }
}