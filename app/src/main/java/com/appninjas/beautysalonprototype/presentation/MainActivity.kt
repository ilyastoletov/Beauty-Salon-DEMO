package com.appninjas.beautysalonprototype.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.appninjas.beautysalonprototype.R
import com.appninjas.beautysalonprototype.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val btNav: BottomNavigationView = binding.bottomNavView
        val navControllerFragment = supportFragmentManager.findFragmentById(R.id.nav_controller_fragment) as NavHostFragment
        val navController = navControllerFragment.navController
        val appBarConf = AppBarConfiguration(setOf(R.id.homeFragment, R.id.appointmentFragment, R.id.reviewFragment, R.id.galleryFragment))

        setupActionBarWithNavController(navController, appBarConf)
        btNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.addReviewFragment) {
                btNav.visibility = View.GONE
            } else {
                btNav.visibility = View.VISIBLE
            }
        }
    }

}