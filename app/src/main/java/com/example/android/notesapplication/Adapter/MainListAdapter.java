package com.example.android.notesapplication.Adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.notesapplication.R;
import com.example.android.notesapplication.db.DateConverter;
import com.example.android.notesapplication.db.NotesPojo;

/**
 * Created by anamika on 3/10/17.
 */

public class MainListAdapter extends PagedListAdapter<NotesPojo,MainListAdapter.ListHolder> {
    public MainListAdapter() {
        super(DIFF_CALLBACK);
    }

    private int count = 0;
    private static final DiffCallback<NotesPojo> DIFF_CALLBACK = new DiffCallback<NotesPojo>() {
        @Override
        public boolean areItemsTheSame(@NonNull NotesPojo oldItem, @NonNull NotesPojo newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull NotesPojo oldItem, @NonNull NotesPojo newItem) {
            return areItemsTheSame(oldItem, newItem);
        }
    };

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_display_main,parent,false);
        return new MainListAdapter.ListHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListHolder holder, int position) {
        NotesPojo pojo = getItem(position);
        if(pojo!=null) {
            holder.titleText.setText(pojo.getTitleNotes());
            holder.dateText.setText(pojo.getEndTime().toString());
        }

    }

    public class ListHolder extends RecyclerView.ViewHolder {
        TextView titleText, dateText;
        public ListHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title_text);
            dateText = itemView.findViewById(R.id.date_text);

        }
    }
}
