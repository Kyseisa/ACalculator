package com.example.acalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, "onCreate ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_0.setOnClickListener {
            Log.i(TAG, "Click no Botão 0")
            if (text_visor.text == "0") {
                text_visor.text = "0"
            } else {
                text_visor.append("0")
            }
        }

        button_1.setOnClickListener {
            Log.i(TAG, "Click no Botão 1")
            if (text_visor.text == "0") {
                text_visor.text = "1"
            } else {
                text_visor.append("1")
            }
        }

        button_2.setOnClickListener {
            Log.i(TAG, "Click no Botão 2")
            if (text_visor.text == "0") {
                text_visor.text = "2"
            } else {
                text_visor.append("2")
            }
        }

        button_3.setOnClickListener {
            Log.i(TAG, "Click no Botão 3")
            if (text_visor.text == "0") {
                text_visor.text = "3"
            } else {
                text_visor.append("3")
            }
        }

        button_4.setOnClickListener {
            Log.i(TAG, "Click no Botão 4")
            if (text_visor.text == "0") {
                text_visor.text = "4"
            } else {
                text_visor.append("4")
            }
        }

        button_5.setOnClickListener {
            Log.i(TAG, "Click no Botão 5")
            if (text_visor.text == "0") {
                text_visor.text = "5"
            } else {
                text_visor.append("5")
            }
        }

        button_6.setOnClickListener {
            Log.i(TAG, "Click no Botão 6")
            if (text_visor.text == "0") {
                text_visor.text = "6"
            } else {
                text_visor.append("6")
            }
        }

        button_addition.setOnClickListener {
            Log.i(TAG, "Click no Botão +")
            text_visor.append("+")
        }

        button_subtraction.setOnClickListener {
            Log.i(TAG, "Click no Botão -")
            text_visor.append("-")
        }

        button_division.setOnClickListener {
            Log.i(TAG, "Click no Botão /")
            text_visor.append("/")
        }

        button_multiplication.setOnClickListener {
            Log.i(TAG, "Click no Botão *")
            text_visor.append("*")
        }

        button_dot.setOnClickListener {
            Log.i(TAG, "Click no Botão *")
            text_visor.append(".")
        }

        button_less_than.setOnClickListener {
            Log.i(TAG, "Click no Botão <")
            text_visor.append("<")
        }

        button_clear.setOnClickListener {
            Log.i(TAG, "Click no Botão C")
            text_visor.text = "0"
        }

        button_equals.setOnClickListener {
            Log.i(TAG, "Click no Botão =")
            val visorText = text_visor.text.toString()

            val expression = ExpressionBuilder(visorText).build()
            val result = expression.evaluate().toString()

            val lastCalculation = "$visorText = $result"

            text_visor.text = result
            text_last_calculation.text = lastCalculation

            Log.i(TAG, "O resultado da expressão é $result")
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
        Toast.makeText(this, "onDestroy ${SimpleDateFormat.getTimeInstance().format(Date())}", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}