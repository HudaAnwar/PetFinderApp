package com.huda.petfinderapp.pets_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.huda.domain.pet_list.models.Type
import com.huda.petfinderapp.databinding.ItemTypeBinding
import com.huda.petfinderapp.utils.OnItemClickListener

class TypesAdapter(var types: ArrayList<Type>, private val listener: OnItemClickListener) : RecyclerView.Adapter<TypesAdapter.TypeViewHolder>() {
    private var selectedType = "All"

    inner class TypeViewHolder(private val binding: ItemTypeBinding, private val context: Context) :
        ViewHolder(binding.root) {
        fun setData(type: Type) {
            binding.type.isChecked = (selectedType==type.name)
            binding.type.text = type.name.toString()
            binding.root.setOnClickListener {
                selectedType = type.name.toString()
                type.name?.let { it1 -> listener.onClick(it1) }
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val binding = ItemTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TypeViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return types.size
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.setData(types[position])
    }
    fun updateTypes(types: ArrayList<Type>) {
        val diffResult = DiffUtil.calculateDiff(TypesDiffUtilCallback(this.types, types))
        this.types.clear()
        this.types.addAll(types)
        diffResult.dispatchUpdatesTo(this)
    }
}

class TypesDiffUtilCallback(
    private val oldList: List<Type>?,
    private val newList: List<Type>?
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList?.size?:0
    }

    override fun getNewListSize(): Int {
        return newList?.size?:0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList?.get(oldItemPosition)?.name == newList?.get(newItemPosition)?.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when (oldList?.size) {
            newList?.size -> true
            else -> false
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any {
        return when (oldItemPosition) {
            newItemPosition -> true
            else -> false
        }
    }

}