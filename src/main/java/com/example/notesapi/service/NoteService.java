package com.example.notesapi.service;

import com.example.notesapi.model.Note;
import com.example.notesapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        note.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);
    }
}
