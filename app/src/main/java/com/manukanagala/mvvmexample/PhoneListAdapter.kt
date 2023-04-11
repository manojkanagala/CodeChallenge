package com.manukanagala.mvvmexample

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhoneListAdapter(private val clickListener: PhoneModelListener) : RecyclerView.Adapter<PhoneListAdapter.MyViewHolder>() {

    var smartPhoneList: List<PhoneModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        val holder = MyViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.priceValue.text = smartPhoneList.get(position).price.toString()
        holder.descriptionValue.text = smartPhoneList.get(position).description
        Glide.with(holder.imageView.context).load(smartPhoneList.get(position).thumbnail)
            .into(holder.imageView)

        holder.imageView.setOnClickListener {
            clickListener.onClick(smartPhoneList.get(position))
        }

    }

    override fun getItemCount(): Int {
        return smartPhoneList.size
    }

    fun setPhoneList(phoneList: List<PhoneModel>) {
        this.smartPhoneList = phoneList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val priceValue: TextView = itemView.findViewById(R.id.price_value)
        val descriptionValue: TextView = itemView.findViewById(R.id.description_content)
    }

    class PhoneModelListener(val clickListener: (phone: PhoneModel) -> Unit) {
        fun onClick(phone: PhoneModel) = clickListener(phone)
    }
}
