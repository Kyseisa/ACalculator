package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {
    private val TAG = CalculatorFragment::class.java.simpleName

    private val operations = ArrayList<Operation>()
    private val funcs = setOf(".", "+", "-", "/", "*")

    @Optional
    @OnClick(R.id.button_0, R.id.button_00, R.id.button_1, R.id.button_2, R.id.button_3,
        R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9,
        R.id.button_addition, R.id.button_subtraction, R.id.button_division,
        R.id.button_multiplication, R.id.button_dot)
    fun onClickSymbol(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        if (symbol !in funcs && text_visor.text == "0") {
            text_visor.text = symbol
        } else {
            text_visor.append(symbol)
        }
    }

    @OnClick(R.id.button_clear)
    fun onClickClear(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        text_visor.text = "0"
    }

    @OnClick(R.id.button_erase)
    fun onClickErase(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        if(text_visor.text.length == 1) {
            text_visor.text = "0"
        } else {
            text_visor.text = text_visor.text.dropLast(1)
        }
    }

    @OnClick(R.id.button_equals)
    fun onClickEquals(view: View) {
        val symbol = view.tag.toString()
        Log.i(TAG, "Click no Botão $symbol")
        val visorText = text_visor.text.toString()

        val expression = ExpressionBuilder(visorText).build()
        val result = expression.evaluate()

        val lastCalculation = "$visorText = $result"
        val operation = Operation(visorText, result)

        text_visor.text = result.toString()
        text_last_calculation?.text = lastCalculation

        operations.add(operation)

        Log.i(TAG, "O resultado da expressão é $result")
    }

    override fun onStart() {
        list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        list_historic?.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, operations)
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        ButterKnife.bind(this, view)
        return view
    }
    
}