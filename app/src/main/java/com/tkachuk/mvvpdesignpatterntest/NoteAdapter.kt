package com.tkachuk.mvvpdesignpatterntest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    private var notes: List<Note> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteHolder {
        val itemView =  LayoutInflater.from(p0.context)
                .inflate(R.layout.item_note, p0, false)

        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(p0: NoteHolder, p1: Int) {
        p0.item.text_view_title.text = notes[p1].title
        p0.item.text_view_description.text = notes[p1].description
        p0.item.text_view_priority.text = notes[p1].priority.toString()
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes (notes: List<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }

    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item = itemView
    }
}