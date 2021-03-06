package com.sayamphoo.enjoyreading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sayamphoo.enjoyreading.ui.frament.book.BooksFragment
import com.sayamphoo.enjoyreading.ui.frament.home.HomeFragment
import com.sayamphoo.enjoyreading.ui.frament.libary.LibraryFragment
import com.sayamphoo.enjoyreading.ui.frament.me.MeFragment
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        bottom_Nav.setOnNavigationItemSelectedListener(bottomNavListener)

        if (savedInstanceState == null) {
            setFragment(HomeFragment())
        }
    }

    private val bottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.home -> {
                setFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.books -> {
                setFragment(BooksFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.library -> {
                setFragment(LibraryFragment())
                return@OnNavigationItemSelectedListener true
            }


            R.id.me -> {
                setFragment(MeFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_Layout, fragment)
            .commit()
    }
}