package com.amirhusseinsoori.diffutilsample.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amirhusseinsoori.diffutilsample.User
import com.amirhusseinsoori.diffutilsample.databinding.CustomItemsBinding

class DiffAdapter : RecyclerView.Adapter<DiffAdapter.ViewHolder>() {
    var oldList: List<User> = emptyList<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CustomItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = oldList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = oldList.size


    class ViewHolder(val binding: CustomItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: User) {
            binding.txtName.text = data.name
            binding.txtAge.text = data.age

        }

    }

    fun setData(newUserList: List<User>) {
        val diffUtil = MyDiffUtil(oldList, newUserList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newUserList
        diffResult.dispatchUpdatesTo(this)

    }
}