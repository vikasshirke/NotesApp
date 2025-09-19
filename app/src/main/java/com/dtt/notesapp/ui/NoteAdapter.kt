package com.dtt.notesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dtt.notesapp.data.entity.Note
import com.dtt.notesapp.databinding.ItemNoteBinding


class NoteAdapter(
    private val onItemClick: (Note) -> Unit,
    private val onItemLongClick: (Note) -> Unit
) : ListAdapter<Note, NoteAdapter.NoteViewHolder>(DiffCallback()) {

    class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note, onItemClick: (Note) -> Unit, onItemLongClick: (Note) -> Unit) {
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content

            binding.root.setOnClickListener { onItemClick(note) }
            binding.root.setOnLongClickListener {
                onItemLongClick(note)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick, onItemLongClick)
    }

    class DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
    }
}

