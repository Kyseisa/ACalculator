package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

val EXTRA_HISTORIC_LIST = "com.example.acalculator.HISTORIC_LIST"

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private val VISOR_KEY = "visor"

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

        NavigationManager.goToCalculatorFragment(supportFragmentManager)
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