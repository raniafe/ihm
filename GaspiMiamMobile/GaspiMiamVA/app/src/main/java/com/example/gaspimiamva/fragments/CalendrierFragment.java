package com.example.gaspimiamva.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.gaspimiamva.R;

public class CalendrierFragment extends Fragment {

    View calendarView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        calendarView = inflater.inflate(R.layout.fragment_calendrier, container, false);
        return calendarView;
    }

}
