package com.example.android.notesapplication.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by anamika on 3/10/17.
 */

public class DatabaseInitUtil {

    private static final String[] titleList = new String[]{"first", "second", "third", "fourth", "fifth"};
    private static final String[] detailList = new String[] {
            "first detail is here",
            "second detial it is",
            "third detail is is",
            "fourth detail",
            "firth detail is here"
    };



    static void initializeDb(AppDatabase db) {
        List<NotesPojo> notesList = new ArrayList<>();
        generateData(notesList);
        insertData(db,notesList);
    }

    private static void insertData(AppDatabase db, List<NotesPojo> notesList) {

        db.beginTransaction();
        try {
            db.getNotesDao().insertAll(notesList);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    private static void generateData(List<NotesPojo> notesList) {
        for(int i =0; i<titleList.length;i++)  {
            NotesPojo pojo = new NotesPojo();
            pojo.setTitleNotes(titleList[i]);
            pojo.setDetailNotes(detailList[i]);
            pojo.setEndTime(giveDate(i));
            notesList.add(pojo);
        }

    }

    private static Date giveDate(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,n);
        return calendar.getTime();
    }
}
