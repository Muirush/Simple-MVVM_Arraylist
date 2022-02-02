package com.galoppingtech.simplemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.galoppingtech.simplemvvm.Model.model
import com.galoppingtech.simplemvvm.ViewModel.MainViewModel
import com.galoppingtech.simplemvvm.ViewModel.ViewModelFactory

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
        val factory = ViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)
        but = findViewById(R.id.btSave)
        but.setOnClickListener {
            addData()
        }

        initialiseAdapter()
    }

    private fun initialiseAdapter() {
        mainrecycler.layoutManager = viewManager
        observeData()
    }

    private fun observeData() {
        viewModel.lst.observe(this, Observer{
            Log.i("data",it.toString())
            mainrecycler.adapter= recyclerAdapter(viewModel, it, this,context = this)
        })
    }

    private fun addData() {
        var txtplce = findViewById<EditText>(R.id.tvText)
        var title=txtplce.text.toString()
        if(title.isNullOrBlank()){
            Toast.makeText(this,"Enter value!",Toast.LENGTH_LONG).show()
        }else{
            var blog= model(title)
            viewModel.add(blog)
            txtplce.text.clear()
            mainrecycler.adapter?.notifyDataSetChanged()
        }

    }
}