package com.example.notesapp.Database;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesapp.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO
{
    //Insert a note
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    //Read
    @Query("SELECT * FROM notes ORDER BY id DESC") // Latest Notes query
    List<Notes> getAll();

    //Update
    @Query("UPDATE notes SET title = :title, notes =:notes WHERE ID = :id")
    void update(int id, String title, String notes);

    //Delete
    @Delete
    void delete(Notes notes);
}
