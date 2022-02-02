package com.galoppingtech.simplemvvm

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.galoppingtech.simplemvvm.Model.model
import com.galoppingtech.simplemvvm.ViewModel.MainViewModel
import com.galoppingtech.simplemvvm.databinding.ItemViewBinding

class recyclerAdapter(
    viewModel: MainViewModel,
   val arrayList: ArrayList<model>,
    mainActivity: MainActivity,
   val  context: Context
    ) : RecyclerView.Adapter<recyclerAdapter.NotesViewHolder>() {
    val binding:ItemViewBinding? = null

    inner class NotesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        fun bind(blog: model) {
            binding?.tvTextView?.text = blog.title


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            )
        )
    }




    override fun onBindViewHolder(holder: recyclerAdapter.NotesViewHolder, position: Int) {


        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty",Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


}
//(val viewModel: MainViewModel, val arrayList: ArrayList<model>, val context: Context)





