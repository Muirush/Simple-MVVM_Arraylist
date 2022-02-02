package com.galoppingtech.simplemvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.galoppingtech.simplemvvm.Model.model
import com.galoppingtech.simplemvvm.ViewModel.MainViewModel

class recyclerAdapter (val viewModel: MainViewModel, val arrayList: ArrayList<model>, val context: Context): RecyclerView.Adapter<recyclerAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): recyclerAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return NotesViewHolder(root)
    }



    override fun onBindViewHolder(holder: recyclerAdapter.NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty",Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }
    inner class NotesViewHolder(private val binding: View) :RecyclerView.ViewHolder(binding) {
        fun bind(blog: model){
            //check the binding.
         //  binding.Text.text= blog.title

            }
        }

    }


