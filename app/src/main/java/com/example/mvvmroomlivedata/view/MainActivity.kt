package com.example.mvvmroomlivedata.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomlivedata.R
import com.example.mvvmroomlivedata.model.Word
import com.example.mvvmroomlivedata.view.NewWordActivity.Companion.EXTRA_WORD
import com.example.mvvmroomlivedata.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_NEW_WORD = 1
    }

    private val wordViewModel by lazy { ViewModelProviders.of(this).get(WordViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupRecyclerView()
        setupFAB()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_NEW_WORD && resultCode == Activity.RESULT_OK) {
            val word = data?.getStringExtra(EXTRA_WORD) ?: throw IllegalArgumentException()
            wordViewModel.insert(Word(word))
        } else {
            Toast.makeText(applicationContext, R.string.error_empty_word, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        val adapter = WordListAdapter()
        rvWordList.adapter = adapter
        rvWordList.layoutManager = LinearLayoutManager(this)
        wordViewModel.getAllWords().observe(this, Observer { list ->
            adapter.setWords(list)
        })
    }

    private fun setupFAB() {
        fab.setOnClickListener {
            startActivityForResult(
                    Intent(this, NewWordActivity::class.java),
                    REQUEST_CODE_NEW_WORD
            )
        }
    }
}
