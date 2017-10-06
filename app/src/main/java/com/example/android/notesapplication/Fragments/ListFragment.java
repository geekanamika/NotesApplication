package com.example.android.notesapplication.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.android.notesapplication.Adapter.MainListAdapter;
import com.example.android.notesapplication.ViewModel.MyViewModel;
import com.example.android.notesapplication.R;
import com.example.android.notesapplication.db.NotesPojo;

import java.util.List;


public class ListFragment extends Fragment {
    private MainListAdapter listAdapter;


    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerViewList = view.findViewById(R.id.listRecyclerView);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(getContext()));

        MyViewModel viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        listAdapter = new MainListAdapter();
        viewModel.getProducts().observe(this, new Observer<PagedList<NotesPojo>>() {
            @Override
            public void onChanged(@Nullable PagedList<NotesPojo> notesPojos) {
                listAdapter.setList(notesPojos);
                listAdapter.notifyDataSetChanged();
            }
        });

        recyclerViewList.setAdapter(listAdapter);

        return view;
    }


}
