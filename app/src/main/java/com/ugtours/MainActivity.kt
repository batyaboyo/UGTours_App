package com.ugtours

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ugtours.data.local.AppDatabase
import com.ugtours.data.repository.AttractionsRepository
import com.ugtours.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

/**
 * Main Activity with reactive favorites badge.
 * Uses AttractionsRepository for favorites count.
 */
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var attractionsRepository: AttractionsRepository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Initialize repository
        val database = AppDatabase.getDatabase(this)
        attractionsRepository = AttractionsRepository(
            database.favoritesDao(),
            database.recentlyViewedDao()
        )
        
        setSupportActionBar(binding.toolbar)
        
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        
        binding.bottomNavigation.setupWithNavController(navController)
        
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_login, R.id.navigation_register -> {
                    binding.bottomNavigation.visibility = android.view.View.GONE
                    binding.toolbar.visibility = android.view.View.GONE
                }
                else -> {
                    binding.bottomNavigation.visibility = android.view.View.VISIBLE
                    binding.toolbar.visibility = android.view.View.VISIBLE
                }
            }
        }
        
        // Observe favorites count reactively
        observeFavoritesBadge()
    }
    
    private fun observeFavoritesBadge() {
        lifecycleScope.launch {
            attractionsRepository.getFavoritesCount().collect { count ->
                val badge = binding.bottomNavigation.getOrCreateBadge(R.id.navigation_favorites)
                
                if (count > 0) {
                    badge.isVisible = true
                    badge.number = count
                    badge.backgroundColor = getColor(R.color.md_theme_light_tertiary)
                } else {
                    badge.isVisible = false
                }
            }
        }
    }
}
