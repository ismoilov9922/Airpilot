package uz.roboticslab.droneline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.roboticslab.droneline.models.DroneWeb
import com.squareup.picasso.Picasso
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.ItemStoresBinding

class WebAdapter(private val list: List<DroneWeb>, private val listener: OnItemCLick) :
    RecyclerView.Adapter<WebAdapter.Vh>() {
    inner class Vh(private val binding: ItemStoresBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(droneWeb: DroneWeb) {
            binding.name.text = droneWeb.name
            binding.desc.setText(droneWeb.desc)
            Picasso.get()
                .load(droneWeb.imgUrl)
                .placeholder(R.drawable.placeholder)
                .into(binding.image)
            binding.item.setOnClickListener {
                listener.onClick(droneWeb)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemStoresBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemCLick {
        fun onClick(droneWeb: DroneWeb)
    }
}