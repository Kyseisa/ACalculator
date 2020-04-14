package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

val EXTRA_HISTORIC_LIST = "com.example.acalculator.HISTORIC_LIST"

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private val VISOR_KEY = "visor"

    private val operations = ArrayList<Operation>()
    private val funcs = setOf(".", "+", "-", "/", "*")

    fun onClickSymbol(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        if (symbol !in funcs && text_visor.text == "0") {
            text_visor.text = symbol
        } else {
            text_visor.append(symbol)
        }
    }

    fun onClickClear(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        text_visor.text = "0"
    }

    fun onClickErase(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        if(text_visor.text.length == 1) {
            text_visor.text = "0"
        } else {
            text_visor.text = text_visor.text.dropLast(1)
        }
    }

    fun onClickEquals(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        val visorText = text_visor.text.toString()

        val expression = ExpressionBuilder(visorText).build()
        val result = expression.evaluate()

        val lastCalculation = "$visorText = $result"
        val operation = Operation(visorText, result)

        text_visor.text = result.toString()
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            text_last_calculation.text = lastCalculation
        }

        operations.add(operation)

        Log.i(TAG, "O resultado da expressão é $result")
    }

    fun onClickHistory(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        val intent = Intent(this, HistoryActivity::class.java)
        intent.apply { putParcelableArrayListExtra(EXTRA_HISTORIC_LIST, ArrayList(operations)) }
        startActivity(intent)
        finish()
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

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            list_historic.adapter = HistoryAdapter(this, R.layout.item_expression, operations)
        }

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