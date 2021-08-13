package com.dicoding.githubusers1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.dicoding.githubusers1.databinding.UserItemBinding

@Suppress("DEPRECATION")
class UserAdapter(private var listUser: ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: UserData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder){
            with(listUser[position]) {
                binding.tvName.text = name
                binding.tvCompany.text = company
                binding.tvLocation.text = location

                Glide.with(holder.itemView.context)
                    .load(avatar)
                    .apply(
                        RequestOptions()
                            .fitCenter()
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .override(Target.SIZE_ORIGINAL))
                    .into(binding.imgUser)
                holder.itemView.setOnClickListener {
                    Toast.makeText(holder.itemView.context, "Kamu memilih $name", Toast.LENGTH_SHORT).show()
                    onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
                }
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

    inner class UserViewHolder(val binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root)
}