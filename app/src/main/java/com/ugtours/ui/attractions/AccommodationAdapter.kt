package com.ugtours.ui.attractions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugtours.R
import com.ugtours.databinding.ItemAccommodationBinding
import com.ugtours.models.Accommodation

class AccommodationAdapter(
    private val accommodations: List<Accommodation>
) : RecyclerView.Adapter<AccommodationAdapter.AccommodationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccommodationViewHolder {
        val binding = ItemAccommodationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AccommodationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccommodationViewHolder, position: Int) {
        holder.bind(accommodations[position])
    }

    override fun getItemCount() = accommodations.size

    class AccommodationViewHolder(
        private val binding: ItemAccommodationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(accommodation: Accommodation) {
            binding.accommodationName.text = accommodation.name
            binding.accommodationType.text = accommodation.type
            binding.accommodationPrice.text = accommodation.priceRange
            binding.accommodationDistance.text = accommodation.distanceFromAttraction
            binding.accommodationRating.text = String.format("%.1f/5.0", accommodation.rating)
            binding.accommodationContact.text = accommodation.contact
        }
    }
}
