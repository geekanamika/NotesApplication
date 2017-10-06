package com.example.android.notesapplication.Activity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.android.notesapplication.R;

public class NotesActivity extends AppCompatActivity {
    EditText notesText;
    private final String EDIT_TEXT_VALUE = "edit_Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesText = findViewById(R.id.editNotes);
        if (savedInstanceState != null)
            notesText.setText(savedInstanceState.getString(EDIT_TEXT_VALUE));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_menu, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(EDIT_TEXT_VALUE, notesText.getText().toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.okayButton) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

