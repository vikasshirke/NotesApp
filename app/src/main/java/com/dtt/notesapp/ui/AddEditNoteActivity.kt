package com.dtt.notesapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dtt.notesapp.R
import com.dtt.notesapp.data.entity.Note
import com.dtt.notesapp.databinding.ActivityAddEditNoteBinding
import com.dtt.notesapp.viewmodel.NoteViewModel

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditNoteBinding
    private val viewModel: NoteViewModel by viewModels()
    private var noteId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteId = intent.getIntExtra("note_id", -1).takeIf { it != -1 }
        val oldTitle = intent.getStringExtra("note_title")
        val oldContent = intent.getStringExtra("note_content")

        if (noteId != null) {
            binding.etTitle.setText(oldTitle)
            binding.etContent.setText(oldContent)
        }

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Both fields required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val note = Note(
                id = noteId ?: 0,
                title = title,
                content = content
            )

            if (noteId == null) {
                viewModel.insert(note)
            } else {
                viewModel.update(note)
            }

            finish()
        }
    }
}