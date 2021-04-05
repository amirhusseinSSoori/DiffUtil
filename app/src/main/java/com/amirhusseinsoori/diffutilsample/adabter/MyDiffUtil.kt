package com.amirhusseinsoori.diffutilsample.adabter

import androidx.recyclerview.widget.DiffUtil
import com.amirhusseinsoori.diffutilsample.User

class MyDiffUtil(
    private val newList: List<User>,
    private val oldList: List<User>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[oldItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            oldList[oldItemPosition].age != newList[newItemPosition].age -> {
                false
            }
            else -> true
        }
    }


}