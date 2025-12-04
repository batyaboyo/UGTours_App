package com.ugtours.ui.favorites

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ugtours.data.AttractionsData
import com.ugtours.databinding.FragmentFavoritesBinding
import com.ugtours.ui.attractions.AttractionAdapter
import com.ugtours.ui.attractions.AttractionDetailActivity

class FavoritesFragment : Fragment() {
    
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var adapter: AttractionAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        adapter = AttractionAdapter { attraction ->
            val intent = Intent(requireContext(), AttractionDetailActivity::class.java)
            intent.putExtra("ATTRACTION_ID", attraction.id)
            startActivity(intent)
        }
        
        binding.favoritesRecyclerView.adapter = adapter
        
        updateFavoritesList()
    }
    
    override fun onResume() {
        super.onResume()
        updateFavoritesList()
    }
    
    private fun updateFavoritesList() {
        val favoriteAttractions = AttractionsData.getAllAttractions().filter { it.isFavorite }
        
        adapter.submitList(favoriteAttractions)
        
        if (favoriteAttractions.isEmpty()) {
            binding.emptyView.visibility = View.VISIBLE
            binding.favoritesRecyclerView.visibility = View.GONE
        } else {
            binding.emptyView.visibility = View.GONE
            binding.favoritesRecyclerView.visibility = View.VISIBLE
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
