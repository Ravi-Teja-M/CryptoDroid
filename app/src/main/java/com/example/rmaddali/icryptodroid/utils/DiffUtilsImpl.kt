package com.example.rmaddali.icryptodroid.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.rmaddali.icryptodroid.model.Data

class DiffUtilsImpl(var oldList: List<Data>, var newList: List<Data>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition).id == (newList.get(newItemPosition).id)
    }

    override fun getOldListSize(): Int {
       return  oldList.size
     }

    override fun getNewListSize(): Int {
        return  newList.size
     }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition))
     }
}