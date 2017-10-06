package com.example.android.notesapplication.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by anamika on 2/10/17.
 */

@Database(entities = {NotesPojo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE ;

    static final String DATABASE_NAME = "basic-notes-db";

    public abstract NotesDao getNotesDao();


}
