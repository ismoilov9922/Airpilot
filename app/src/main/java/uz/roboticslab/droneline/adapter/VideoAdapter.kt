package uz.roboticslab.droneline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.roboticslab.droneline.models.VideoHome
import uz.roboticslab.droneline.models.videoData.Item
import com.squareup.picasso.Picasso
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.ItemLearnDroneBinding

class VideoAdapter(private val list: List<VideoHome>, private var listener: OnItemClickListener) :
    RecyclerView.Adapter<VideoAdapter.Vh>() {

    inner class Vh(private var itemVideoListBinding: ItemLearnDroneBinding) :
        RecyclerView.ViewHolder(itemVideoListBinding.root) {

        fun onBind(item: VideoHome) {
            Picasso.get().load(item.image)
                .placeholder(R.drawable.ic_youtube_placeholder)
                .error(R.drawable.ic_youtube_placeholder)
                .into(itemVideoListBinding.imageView)
            itemVideoListBinding.textView.text = item.title
            itemVideoListBinding.textView2.text = item.description
            itemVideoListBinding.imageView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemLearnDroneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }


    class MyDiffUtill : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onItemClick(item: VideoHome)
    }
}