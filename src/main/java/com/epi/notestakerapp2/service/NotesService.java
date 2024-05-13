package com.epi.notestakerapp2.service;

import com.epi.notestakerapp2.entity.Notes;
import com.epi.notestakerapp2.entity.User;

import java.util.List;

public interface NotesService {

    public Notes saveNotes (Notes notes);
    public Notes getNotesById(int id);
public List<Notes> getNotesByUser(User user);
public Notes updateNotes(Notes notes);
public boolean deleteNotes(int id);
}
