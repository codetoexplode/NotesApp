package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: UNotesAdapter):RecyclerView.Adapter<NotesRVAdapter.NoteViewholder>() {

    val notes = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        val viewHolder = NoteViewholder(view)
        val dButton = view.findViewById<ImageView>(R.id.deleteButton)
        view.dButton.setOnClickListener{
            listener.onItemClicked(notes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewholder, position: Int) {
        val currentNote = notes[position]

        holder.tV.text = currentNote.text
    }
    override fun getItemCount(): Int {
        return notes.size
    }

    fun updateList(notelist: List<Note>){
        notes.clear()
        notes.addAll(notelist)
        notifyDataSetChanged()
    }

    inner class NoteViewholder(itemView: View):RecyclerView.ViewHolder(itemView){

        val tV = itemView.findViewById<TextView>(R.id.textView)
        val dB = itemView.findViewById<Button>(R.id.deleteButton)

    }
    interface UNotesAdapter {
        fun onItemClicked(note:Note)
    }
}