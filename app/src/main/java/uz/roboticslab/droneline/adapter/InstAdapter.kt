package uz.roboticslab.droneline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.roboticslab.droneline.models.InstData
import com.squareup.picasso.Picasso
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.ItemInstumentBinding

class InstAdapter(private val list: List<InstData>, private val listener: OnItemCLick) :
    RecyclerView.Adapter<InstAdapter.Vh>() {
    inner class Vh(private val binding: ItemInstumentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(instData: InstData) {
            binding.name.text = instData.name
            binding.endDate.text = instData.date
            Picasso.get()
                .load(instData.img)
                .placeholder(R.drawable.placeholder)
                .into(binding.image)
            binding.item.setOnClickListener {
                listener.onClick(instData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemInstumentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemCLick {
        fun onClick(instData: InstData)
    }
}