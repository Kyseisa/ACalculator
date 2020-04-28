package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val TAG = MainActivity::class.java.simpleName
    private val VISOR_KEY = "visor"

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_calculator -> NavigationManager.goToCalculatorFragment(supportFragmentManager)
            R.id.nav_history -> NavigationManager.goToHistoryFragment(supportFragmentManager)
            R.id.nav_logout -> finish()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "O método onCreate foi invocado.")
        Toast.makeText(this, "onCreate ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setupDrawerMenu()
        if(!screenRotated(savedInstanceState)) {
            NavigationManager.goToCalculatorFragment(supportFragmentManager)
        }
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else if(supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun screenRotated(savedInstanceState: Bundle?) : Boolean {
        return savedInstanceState != null
    }

    private fun setupDrawerMenu() {
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close)
        nav_drawer.setNavigationItemSelectedListener(this)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onStart() {
        Toast.makeText(this, "onStart ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    override fun onResume() {
        Toast.makeText(this, "onResume ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onResume()
    }

    override fun onPause() {
        Toast.makeText(this, "onPause ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onPause()
    }

    override fun onStop() {
        Toast.makeText(this, "onStop ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onStop()
    }

    override fun onRestart() {
        Toast.makeText(this, "onRestart ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onRestart()
    }

    override fun onDestroy() {
        Log.i(TAG, "O método onDestroy foi invocado.")
        Toast.makeText(this, "onDestroy ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}