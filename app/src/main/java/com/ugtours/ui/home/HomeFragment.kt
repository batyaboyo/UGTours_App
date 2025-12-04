package com.ugtours.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugtours.data.AttractionsData
import com.ugtours.databinding.FragmentHomeBinding
import com.ugtours.ui.attractions.AttractionAdapter
import com.ugtours.ui.attractions.AttractionDetailActivity

class HomeFragment : Fragment() {
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupHeroSection()
        setupCategories()
        setupFeaturedAttractions()
        
        binding.exploreAllButton.setOnClickListener {
            navigateToAttractions()
        }
        
        binding.viewAllText.setOnClickListener {
            navigateToAttractions()
        }
    }
    
    private fun setupHeroSection() {
        // Load a random attraction image for the hero section
        val randomAttraction = AttractionsData.getAllAttractions().random()
        
        com.bumptech.glide.Glide.with(this)
            .load(randomAttraction.imageUrls.first())
            .placeholder(com.ugtours.R.drawable.placeholder_attraction)
            .error(com.ugtours.R.drawable.placeholder_attraction)
            .centerCrop()
            .into(binding.heroImage)
    }
    
    private fun setupCategories() {
        // Show only main category types based on the 16 attractions
        val mainCategories = listOf(
            Category("National Parks", com.ugtours.R.drawable.ic_explore),
            Category("Waterfalls", com.ugtours.R.drawable.ic_location),
            Category("Mountains", com.ugtours.R.drawable.ic_explore),
            Category("Cultural Sites", com.ugtours.R.drawable.ic_profile),
            Category("Wildlife", com.ugtours.R.drawable.ic_favorite)
        )
        
        val adapter = CategoryAdapter(mainCategories) { category ->
            // Navigate to attractions list
            navigateToAttractions()
        }
        
        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
        }
    }
    
    private fun getIconForCategory(category: String): Int {
        return when {
            category.contains("Park", true) -> com.ugtours.R.drawable.ic_explore
            category.contains("Waterfall", true) -> com.ugtours.R.drawable.ic_location
            category.contains("Mountain", true) -> com.ugtours.R.drawable.ic_explore
            category.contains("Cultural", true) -> com.ugtours.R.drawable.ic_profile
            category.contains("Wildlife", true) -> com.ugtours.R.drawable.ic_favorite
            else -> com.ugtours.R.drawable.ic_explore
        }
    }
    
    private fun setupFeaturedAttractions() {
        // Get featured attractions - ensure at least 3 are shown
        val featuredAttractions = AttractionsData.getAllAttractions().take(3)
        
        val adapter = FeaturedAttractionAdapter { attraction ->
            val intent = Intent(requireContext(), AttractionDetailActivity::class.java)
            intent.putExtra("ATTRACTION_ID", attraction.id)
            startActivity(intent)
        }
        
        binding.featuredRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
        }
        
        adapter.submitList(featuredAttractions)
    }
    
    private fun navigateToAttractions() {
        requireActivity().findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            com.ugtours.R.id.bottom_navigation
        )?.selectedItemId = com.ugtours.R.id.navigation_attractions
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
