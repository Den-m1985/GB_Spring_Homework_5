package com.example.controller;

import com.example.model.Note;
import com.example.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    private final NoteService noteService;


    /**
     * Handles the HTTP POST request to create a new note.
     *
     * @param note The note object to be created. Should be provided in the request body as JSON.
     * @return The newly created note object with its unique identifier.
     */
    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }


    /**
     * Handles the HTTP GET request to retrieve a list of all notes.
     *
     * @return A list of notes containing information about each note in the system.
     */
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }


    /**
     * Handles the HTTP GET request to retrieve a list of all notes by id.
     *
     * @return A list of notes containing information about each unique note in the system.
     */
    @GetMapping("/{id}")
    public List<Note> getNotesById(@PathVariable Long id) {
        return noteService.getNotesById(id);
    }


    /**
     * Handles the HTTP PUT request to update the status of a specific note.
     *
     * @param id   The unique identifier of the note to be updated.
     * @param note The note object containing the updated status. Should be provided in the request body as JSON.
     * @return The updated note object with its modified status.
     */
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }


    /**
     * Handles the HTTP DELETE request to delete a specific task.
     *
     * @param id The unique identifier of the task to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

}
