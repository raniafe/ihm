package com.example.gaspimiamva.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.adapters.CustomListView;
import com.example.gaspimiamva.models.ModelListOfProduit;

public class MesReservationsFragment extends Fragment {

    ListView lst;
    View myView;
    private static final String ARG_ModelList = "argText";
    public ModelListOfProduit modelList;

    public static MesReservationsFragment newInstance(ModelListOfProduit modelListOfProduit) {
        MesReservationsFragment fragment = new MesReservationsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_reservations, container, false);

        lst = (ListView) myView.findViewById(R.id.list);


        if (getArguments() != null && modelList == null) {
            modelList = getArguments().getParcelable(ARG_ModelList);
        }
        CustomListView customListView = new CustomListView(getActivity(), modelList.getListProduitReservation(), 0);
        lst.setAdapter(customListView);

        return myView;
    }
}