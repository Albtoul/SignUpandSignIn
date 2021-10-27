package com.example.signupandsignin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.signupandsignin.databinding.ItemRowBinding
import com.example.signupandsignin.databinding.ItemRowwBinding
// class Adapter to show result by recyclerView
class RV(val info:ArrayList<List<String>>): RecyclerView.Adapter<RV.ItemBinding>() {
    class ItemBinding (val bin : ItemRowwBinding):RecyclerView.ViewHolder(bin.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBinding {
        return ItemBinding(ItemRowwBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemBinding, position: Int) {


        val name = info[position][1]
        val location = info[position][2]

        holder.bin.apply{
            textView.text= "$name \n\n $location"

        }
    }

    override fun getItemCount()=info.size


}