package com.ugtours.ui.attractions

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.ugtours.R
import com.ugtours.databinding.ActivityAttractionDetailBinding
import com.ugtours.ui.ViewModelFactory

/**
 * Attraction Detail Activity with MVVM architecture.
 * Uses AttractionDetailViewModel for data and state management.
 */
class AttractionDetailActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityAttractionDetailBinding
    private lateinit var viewModel: AttractionDetailViewModel
    private val indicators = mutableListOf<android.widget.ImageView>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttractionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val attractionId = intent.getIntExtra("ATTRACTION_ID", -1)
        if (attractionId == -1) {
            finish()
            return
        }
        
        // Create ViewModel with attraction ID
        val factory = ViewModelFactory(this)
        viewModel = factory.createAttractionDetailViewModel(attractionId)
        
        val attraction = viewModel.attraction
        if (attraction == null) {
            finish()
            return
        }
        
        setupToolbar()
        displayAttractionDetails()
        setupObservers()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        binding.collapsingToolbar.title = viewModel.attraction?.name
    }
    
    private fun setupObservers() {
        // Observe favorite status - automatically updates button
        viewModel.isFavorite.observe(this) { isFavorite ->
            updateFavoriteButton(isFavorite)
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.attraction_detail_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareAttraction()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    private fun shareAttraction() {
        viewModel.attraction?.let { attr ->
            val shareText = buildString {
                append("🌍 Check out this amazing place in Uganda!\n\n")
                append("📍 ${attr.name}\n")
                append("🏷️ ${attr.category}\n")
                append("📌 ${attr.location}\n\n")
                append("${attr.description.take(200)}...\n\n")
                append("✨ Unique Features:\n")
                attr.uniqueFeatures.take(3).forEach { feature ->
                    append("• $feature\n")
                }
                append("\nDiscover more with UG Tours app!")
            }
            
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                putExtra(Intent.EXTRA_SUBJECT, "${attr.name} - UG Tours")
                type = "text/plain"
            }
            
            startActivity(Intent.createChooser(shareIntent, "Share ${attr.name} via"))
        }
    }
    
    private fun displayAttractionDetails() {
        viewModel.attraction?.let { attr ->
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
            
            // Setup favorite button click
            binding.fabFavorite.setOnClickListener {
                viewModel.toggleFavorite()
            }
        }
    }
    
    private fun setupIndicators(count: Int) {
        indicators.clear()
        binding.indicatorContainer.removeAllViews()
        
        val indicatorSize = resources.getDimensionPixelSize(R.dimen.indicator_size)
        val indicatorMargin = resources.getDimensionPixelSize(R.dimen.indicator_margin)
        
        for (i in 0 until count) {
            val indicator = android.widget.ImageView(this).apply {
                setImageResource(R.drawable.indicator_inactive)
                layoutParams = android.widget.LinearLayout.LayoutParams(indicatorSize, indicatorSize).apply {
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
