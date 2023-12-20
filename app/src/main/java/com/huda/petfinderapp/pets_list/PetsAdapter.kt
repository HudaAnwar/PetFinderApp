package com.huda.petfinderapp.pets_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.huda.domain.common.models.Animal
import com.huda.petfinderapp.utils.Helper
import com.huda.petfinderapp.databinding.ItemPetBinding
import com.huda.petfinderapp.utils.OnItemClickListener

class PetsAdapter(var pets: ArrayList<Animal>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<PetsAdapter.PetViewHolder>() {
    inner class PetViewHolder(private val binding: ItemPetBinding, private val context: Context) :
        ViewHolder(binding.root) {
        fun setData(pet: Animal) {
            pet.primaryPhotoCropped?.small?.let { Helper.loadImage(context, it, binding.petImg) }
            binding.petName.text = pet.name ?: "NA"
            binding.petGender.text = pet.gender ?: "NA"
            binding.petType.text = pet.type ?: "NA"
            binding.root.setOnClickListener {
                pet.id?.let { it1 -> listener.onClick(it1) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return pets.size
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.setData(pets[position])
    }

    fun updatePets(pets: ArrayList<Animal>) {
        val diffResult = DiffUtil.calculateDiff(PetsDiffUtilCallback(this.pets, pets))
        this.pets.clear()
        pets.let { this.pets.addAll(it) }
        diffResult.dispatchUpdatesTo(this)
    }
}

class PetsDiffUtilCallback(
    private val oldList: List<Animal>?,
    private val newList: List<Animal>?
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList?.get(oldItemPosition)?.id == newList?.get(newItemPosition)?.id
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