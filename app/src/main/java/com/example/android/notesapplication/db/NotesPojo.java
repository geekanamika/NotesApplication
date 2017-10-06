package com.example.android.notesapplication.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by anamika on 2/10/17.
 */

@Entity
@TypeConverters(DateConverter.class)
public class NotesPojo {
    public @PrimaryKey String id;
    public Date endTime;
    public String titleNotes;
    public String detailNotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTitleNotes() {
        return titleNotes;
    }

    public void setTitleNotes(String titleNotes) {
        this.titleNotes = titleNotes;
    }

    public String getDetailNotes() {
        return detailNotes;
    }

    public void setDetailNotes(String detailNotes) {
        this.detailNotes = detailNotes;
    }
}
