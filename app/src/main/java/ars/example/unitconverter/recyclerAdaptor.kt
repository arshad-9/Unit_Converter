package ars.example.unitconverter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ars.example.unitconverter.databinding.ItemBinding

class recyclerAdaptor(val list :List<MesurmentTypes>,val listenner:((Int)->Unit)?)
    :RecyclerView.Adapter<recyclerAdaptor.viewHolder>() {
    inner class viewHolder(val binding:ItemBinding?):RecyclerView.ViewHolder(binding!!.root){}

    private var selectedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
       return viewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
          holder.binding?.img?.setImageResource(list[position].image)
         holder.binding?.description?.text = list[position].type
        if(selectedPosition==holder.adapterPosition)
        {
            holder.binding?.ParentItem?.setBackgroundColor(Color.RED)
            holder.binding?.description?.setTextColor(Color.WHITE)

        }else{
            holder.binding?.ParentItem?.setBackgroundColor(Color.parseColor("#CDDAF36A"))
            holder.binding?.description?.setTextColor(Color.BLACK)
        }
         holder?.binding?.ParentItem?.setOnClickListener {
             listenner!!(holder.adapterPosition)
             selectedPosition = holder.adapterPosition
             notifyDataSetChanged()
         }

    }
}