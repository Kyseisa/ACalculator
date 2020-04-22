package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class HistoryActivity : AppCompatActivity() {
    private val TAG = HistoryActivity::class.java.simpleName

    fun onClickBack(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORIC_LIST)
        list_history_page.layoutManager = LinearLayoutManager(this)
        list_history_page.adapter = HistoryAdapter(this, R.layout.item_expression, operations)
    }
}
