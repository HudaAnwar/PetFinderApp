package com.huda.petfinderapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.children
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.huda.petfinderapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var onDestinationChangedListener: NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        setupNavigation()
        events()
    }

    private fun events() {
        binding.toolbar.toolbarHome.setNavigationOnClickListener {
            navController.popBackStack()
        }
    }

    private fun setupNavigation() {
        onDestinationChangedListener =
            NavController.OnDestinationChangedListener { _, destination, _ ->
                var icon= AppCompatResources.getDrawable(this, R.drawable.ic_arrow_back)
                binding.toolbar.toolbarTitle.text = when (destination.id) {
                    R.id.petDetailsFragment -> {
                        getString(R.string.pet_details)
                    }
                    R.id.previewPetWebsiteFragment -> {
                        getString(R.string.pet_s_website)
                    }
                    else -> {
                        icon = null
                        getString(R.string.pets)
                    }
                }
                binding.toolbar.toolbarHome.navigationIcon = icon
            }

        navController.addOnDestinationChangedListener(onDestinationChangedListener)
    }
}