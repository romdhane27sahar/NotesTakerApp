package com.epi.notestakerapp2.repository;

import com.epi.notestakerapp2.entity.Notes;
import com.epi.notestakerapp2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes,Integer> {


    public List<Notes> findByUser(User user);
}
