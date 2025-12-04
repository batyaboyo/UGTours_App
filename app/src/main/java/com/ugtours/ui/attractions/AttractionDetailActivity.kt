package com.ugtours.ui.attractions

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.ugtours.R
import com.ugtours.data.AttractionsData
import com.ugtours.databinding.ActivityAttractionDetailBinding
import com.ugtours.models.Attraction

class AttractionDetailActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityAttractionDetailBinding
    private var attraction: Attraction? = null
    private val indicators = mutableListOf<ImageView>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttractionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val attractionId = intent.getIntExtra("ATTRACTION_ID", -1)
        attraction = AttractionsData.getAttractionById(attractionId)
        
        if (attraction == null) {
            finish()
            return
        }
        
        setupToolbar()
        displayAttractionDetails()
    }
    
    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        binding.collapsingToolbar.title = attraction?.name
    }
    
    private fun displayAttractionDetails() {
        attraction?.let { attr ->
            // Set basic info
            binding.attractionName.text = attr.name
            binding.categoryChip.text = attr.category
            binding.locationText.text = attr.location
            binding.descriptionText.text = attr.description
            
            // Setup image slider with indicators
            val imageAdapter = ImageSliderAdapter(attr.imageUrls)
            binding.imageSlider.adapter = imageAdapter
            
            // Setup carousel indicators
            setupIndicators(attr.imageUrls.size)
            binding.imageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    updateIndicators(position)
                }
            })
            
            // Setup features list
            val featuresAdapter = FeaturesAdapter(attr.uniqueFeatures)
            binding.featuresRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@AttractionDetailActivity)
                adapter = featuresAdapter
            }
            
            // Setup accommodations list
            val accommodationsAdapter = AccommodationAdapter(attr.nearbyAccommodations)
            binding.accommodationsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@AttractionDetailActivity)
                adapter = accommodationsAdapter
            }
            
            // Setup favorite button
            updateFavoriteButton(attr.isFavorite)
            binding.fabFavorite.setOnClickListener {
                attr.isFavorite = !attr.isFavorite
                updateFavoriteButton(attr.isFavorite)
            }
        }
    }
    
    private fun setupIndicators(count: Int) {
        indicators.clear()
        binding.indicatorContainer.removeAllViews()
        
        val indicatorSize = resources.getDimensionPixelSize(R.dimen.indicator_size)
        val indicatorMargin = resources.getDimensionPixelSize(R.dimen.indicator_margin)
        
        for (i in 0 until count) {
            val indicator = ImageView(this).apply {
                setImageResource(R.drawable.indicator_inactive)
                layoutParams = LinearLayout.LayoutParams(indicatorSize, indicatorSize).apply {
                    setMargins(indicatorMargin, 0, indicatorMargin, 0)
                }
            }
            indicators.add(indicator)
            binding.indicatorContainer.addView(indicator)
        }
        
        if (indicators.isNotEmpty()) {
            indicators[0].setImageResource(R.drawable.indicator_active)
        }
    }
    
    private fun updateIndicators(position: Int) {
        indicators.forEachIndexed { index, imageView ->
            if (index == position) {
                imageView.setImageResource(R.drawable.indicator_active)
            } else {
                imageView.setImageResource(R.drawable.indicator_inactive)
            }
        }
    }
    
    private fun updateFavoriteButton(isFavorite: Boolean) {
        if (isFavorite) {
            binding.fabFavorite.text = getString(R.string.remove_from_favorites)
            binding.fabFavorite.setIconResource(android.R.drawable.star_big_on)
        } else {
            binding.fabFavorite.text = getString(R.string.add_to_favorites)
            binding.fabFavorite.setIconResource(android.R.drawable.star_big_off)
        }
    }
}
