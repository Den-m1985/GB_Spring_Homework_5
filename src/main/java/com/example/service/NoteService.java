package com.example.service;

import com.example.aspect.TrackUserAction;
import com.example.model.Note;
import com.example.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log
public class NoteService {

    private final NoteRepository repository;


    @TrackUserAction
    public List<Note> getAllNotes() {
        log.info("method: getAllNotes");
        return repository.findAll();
    }


    @TrackUserAction
    public Optional<Note> getNoteById(Long id) {
        log.info("method: getNoteById " + id);
        return repository.findById(id);
    }


    @TrackUserAction
    public List<Note> getNotesById(Long id) {
        log.info("method: getNotesById" + id);
        Optional<Note> optionalTask = getNoteById(id);
        if (optionalTask.isPresent()) {
            Note note = optionalTask.get();
            List<Note> array = new ArrayList<>();
            array.add(note);
            return array;
        }
        throw new IllegalArgumentException("Note not found with id: " + id);
    }


    @TrackUserAction
    public Note createNote(Note note) {
        log.info("method: createNote");
        return repository.save(note);
    }


    @TrackUserAction
    public Note updateNote(Long id, Note note) {
        log.info("method: updateNote with " + id);
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


    @TrackUserAction
    public void deleteNote(Long id) {
        log.info("method: deleteNote " + id);
        repository.deleteById(id);
    }

}
