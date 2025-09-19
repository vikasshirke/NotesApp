# 📒 NotesApp

A simple **Notes Taking App** built with **MVVM architecture** using Room, LiveData, ViewModel, and RecyclerView.  
This app demonstrates clean architecture for Android with full CRUD (Create, Read, Update, Delete) functionality.

---

## 🚀 Features
- Add new notes (title + content)
- View all notes in a list
- Edit existing notes
- Delete notes with swipe-to-delete
- Stores data locally using Room Database
- MVVM + Repository pattern with LiveData

---

## 🛠️ Tools & Technologies
- **Kotlin**
- **MVVM Architecture**
- **Android Jetpack Components**
    - LiveData
    - ViewModel
    - Room Database
- **RecyclerView**
- **Material Design UI**

---

## 📂 Project Structure

       com.example.notesapp
       ├─ data/
       │ ├─ entity/Note.kt
       │ ├─ dao/NoteDao.kt
       │ ├─ database/NoteDatabase.kt
       ├─ repository/NoteRepository.kt
       ├─ viewmodel/NoteViewModel.kt
       ├─ ui/
       │ ├─ MainActivity.kt
       │ ├─ AddEditNoteActivity.kt
       │ ├─ NoteAdapter.kt
       ├─ res/layout/
       │ ├─ activity_main.xml
       │ ├─ activity_add_edit_note.xml
       │ ├─ item_note.xml
       └─ AndroidManifest.xml