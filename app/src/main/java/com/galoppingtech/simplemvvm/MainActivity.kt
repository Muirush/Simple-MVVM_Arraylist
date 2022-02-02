package com.galoppingtech.simplemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.galoppingtech.simplemvvm.ViewModel.Factory
import com.galoppingtech.simplemvvm.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var mainrecycler: RecyclerView
    private lateinit var but: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainrecycler = findViewById(R.id.recylerview)
        val application = requireNotNull(this).application
        val factory = Factory()
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel::class.java)
        but = findViewById(R.id.button)
        but.setOnClickListener {
            addData()
        }

        initialiseAdapter()
    }
}