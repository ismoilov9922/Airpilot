package uz.roboticslab.droneline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.roboticslab.droneline.models.Category
import uz.roboticslab.droneline.databinding.ItemHomeBinding

class AdapterTwo(
    private val list: List<Category>,
    private val listener: OnItemCLick
) :
    RecyclerView.Adapter<AdapterTwo.Vh>() {
    inner class Vh(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(category: Category) {
            binding.image.setImageResource(category.image)
            binding.title.setText(category.text)
            binding.item.setOnClickListener {
                listener.onClickListener(category.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemCLick {
        fun onClickListener(id: Int)
    }
}