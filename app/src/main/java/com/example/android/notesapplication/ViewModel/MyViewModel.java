package com.example.android.notesapplication.ViewModel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.paging.LivePagedListProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.example.android.notesapplication.db.AppDatabase;
import com.example.android.notesapplication.db.DatabaseCreator;
import com.example.android.notesapplication.db.NotesDao;
import com.example.android.notesapplication.db.NotesPojo;

import java.util.List;

/**
 * Created by anamika on 3/10/17.
 */

public class MyViewModel extends AndroidViewModel {

    private static AppDatabase appDatabase;
    private static NotesDao notesDao;

//    private static final MutableLiveData ABSENT = new MutableLiveData();
//
//    {
//        //noinspection unchecked
//        ABSENT.setValue(null);
//    }


    private LiveData<PagedList<NotesPojo>> mObservableNotes;

    public MyViewModel(@NonNull Application application) {
        super(application);

        final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());
        LiveData<Boolean> databaseCreated = databaseCreator.isDatabaseCreated();
        databaseCreator.createDb(this.getApplication());


        mObservableNotes = getDao().findAll().create(null, 50);


    }

    private static NotesDao getDao() {
        if (notesDao == null)
            notesDao = appDatabase.getNotesDao();
        return notesDao;
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<PagedList<NotesPojo>> getProducts() {
        return mObservableNotes;
    }
}
