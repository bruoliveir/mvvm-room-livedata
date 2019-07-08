package com.example.mvvmroomlivedata.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomlivedata.R
import com.example.mvvmroomlivedata.model.Word
import kotlinx.android.synthetic.main.view_main_list_item.view.*

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var words = listOf<Word>()
    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = layoutInflater.inflate(R.layout.view_main_list_item, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount() = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.itemView.tvWord.text = words[position].word
    }

    fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
