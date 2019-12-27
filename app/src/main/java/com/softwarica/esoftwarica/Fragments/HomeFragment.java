package com.softwarica.esoftwarica.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwarica.esoftwarica.Adapters.StudentsAdapter;
import com.softwarica.esoftwarica.MainActivity;
import com.softwarica.esoftwarica.Models.Students;
import com.softwarica.esoftwarica.R;


public class HomeFragment extends Fragment {

    RecyclerView rvStudents;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvStudents = view.findViewById(R.id.rvStudents);
        if (MainActivity.studentsList.isEmpty()) {
            Toast.makeText(getContext(),"empty" , Toast.LENGTH_SHORT).show();
        }
        else {
            StudentsAdapter studentsAdapter = new StudentsAdapter(getContext(), MainActivity.studentsList);
            rvStudents.setAdapter(studentsAdapter);
            rvStudents.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        return view;
    }

}
