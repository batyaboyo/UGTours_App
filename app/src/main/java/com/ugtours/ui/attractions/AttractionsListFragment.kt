package com.ugtours.ui.attractions

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.ugtours.R
import com.ugtours.data.AttractionsData
import com.ugtours.databinding.FragmentAttractionsListBinding
import com.ugtours.models.Attraction

class AttractionsListFragment : Fragment() {
    
    private var _binding: FragmentAttractionsListBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var adapter: AttractionAdapter
    private var allAttractions = listOf<Attraction>()
    private var filteredAttractions = listOf<Attraction>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAttractionsListBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        allAttractions = AttractionsData.getAllAttractions()
        filteredAttractions = allAttractions
        
        setupRecyclerView()
        setupSearch()
        setupCategoryFilters()
        
        updateAttractionsList()
    }
    
    private fun setupRecyclerView() {
        adapter = AttractionAdapter { attraction ->
            val intent = Intent(requireContext(), AttractionDetailActivity::class.java)
            intent.putExtra("ATTRACTION_ID", attraction.id)
            startActivity(intent)
        }
        binding.attractionsRecyclerView.adapter = adapter
    }
    
    private fun setupSearch() {
        binding.searchBar.addTextChangedListener { text ->
            filterAttractions()
        }
    }
    
    private fun setupCategoryFilters() {
        binding.categoryChips.setOnCheckedStateChangeListener { group, checkedIds ->
            filterAttractions()
        }
    }
    
    private fun filterAttractions() {
        val searchQuery = binding.searchBar.text.toString()
        val selectedChipId = binding.categoryChips.checkedChipId
        
        filteredAttractions = allAttractions.filter { attraction ->
            val matchesSearch = searchQuery.isEmpty() || 
                attraction.name.contains(searchQuery, ignoreCase = true) ||
                attraction.description.contains(searchQuery, ignoreCase = true) ||
                attraction.location.contains(searchQuery, ignoreCase = true)
            
            val matchesCategory = when (selectedChipId) {
                R.id.chip_all -> true
                R.id.chip_national_park -> attraction.category.contains("National Park", ignoreCase = true)
                R.id.chip_waterfall -> attraction.category.contains("Waterfall", ignoreCase = true)
                R.id.chip_cultural -> attraction.category.contains("Cultural", ignoreCase = true)
                else -> true
            }
            
            matchesSearch && matchesCategory
        }
        
        updateAttractionsList()
    }
    
    private fun updateAttractionsList() {
        adapter.submitList(filteredAttractions)
        
        if (filteredAttractions.isEmpty()) {
            binding.emptyView.visibility = View.VISIBLE
            binding.attractionsRecyclerView.visibility = View.GONE
        } else {
            binding.emptyView.visibility = View.GONE
            binding.attractionsRecyclerView.visibility = View.VISIBLE
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
