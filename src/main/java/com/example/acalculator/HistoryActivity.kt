package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class HistoryActivity : AppCompatActivity() {
    private val TAG = HistoryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORIC_LIST)
        list_history_page.adapter = HistoryAdapter(this, R.layout.item_expression, operations)

        button_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        list_history_page.setOnItemClickListener { parent, _, position, _ ->
            Toast.makeText(this, "${parent.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
        }
    }
}
