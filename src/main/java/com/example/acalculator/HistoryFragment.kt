package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {
    private val TAG = HistoryFragment::class.java.simpleName

    override fun onStart() {
        val operations = ArrayList<Operation>()
        operations.add(Operation("2+3", 5.0))
        list_history_page.layoutManager = LinearLayoutManager(activity as Context)
        list_history_page.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, operations)
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_history, container, false)
    }
}
