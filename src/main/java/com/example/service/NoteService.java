package com.example.service;

import com.example.model.Note;
import com.example.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository repository;


    public List<Note> getAllNotes() {
        return repository.findAll();
    }


    public Optional<Note> getNoteById(Long id) {
        return repository.findById(id);
    }


    public List<Note> getNotesById(Long id) {
        Optional<Note> optionalTask = getNoteById(id);
        if (optionalTask.isPresent()) {
            Note note = optionalTask.get();
            List<Note> array = new ArrayList<>();
            array.add(note);
            return array;
        }
        throw new IllegalArgumentException("Note not found with id: " + id);
    }


    public Note createNote(Note note) {
        return repository.save(note);
    }


    public Note updateNote(Long id, Note note) {
        Optional<Note> optionalTask = getNoteById(id);
        if (optionalTask.isPresent()) {
            Note note1 = optionalTask.get();
            note1.setHeader(note.getHeader());
            note1.setContent(note.getContent());
            note1.setLocalDateTime(note.getLocalDateTime());
            return repository.save(note1);
        } else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }

    public void deleteNote(Long id) {
        repository.deleteById(id);
    }

}
