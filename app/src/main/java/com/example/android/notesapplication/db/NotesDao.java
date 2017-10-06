package com.example.android.notesapplication.db;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.ABORT;
import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by anamika on 2/10/17.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface NotesDao {

    @Query("select * from NotesPojo where id = :id")
    NotesPojo getNotesById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NotesPojo> notesPojoList);

    @Query("SELECT * From NotesPojo")
    LivePagedListProvider<?, NotesPojo> findAll();

    @Insert(onConflict = REPLACE)
    void insertNotes(NotesPojo notesPojo);

    @Update(onConflict = REPLACE)
    void updateLoan(int id, NotesPojo notesPojo);

    @Query("DELETE FROM NotesPojo")
    void deleteAll();

    @Query("delete from NotesPojo where id = :id")
    void deleteNotesById(int id);

    @Delete
    void delete(NotesPojo notesPojo);


}
