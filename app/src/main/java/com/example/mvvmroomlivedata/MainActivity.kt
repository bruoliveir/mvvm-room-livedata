package com.example.mvvmroomlivedata

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupRecyclerView()
        setupFAB()
    }

    private fun setupRecyclerView() {
        rvWordList.adapter = WordListAdapter()
        rvWordList.layoutManager = LinearLayoutManager(this)
    }

    private fun setupFAB() {
        fab.setOnClickListener {
            startActivity(Intent(this, NewWordActivity::class.java))
        }
    }
}
