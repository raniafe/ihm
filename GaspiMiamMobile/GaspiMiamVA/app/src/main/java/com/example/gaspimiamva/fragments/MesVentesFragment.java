package com.example.gaspimiamva.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.adapters.CustomListView;
import com.example.gaspimiamva.models.ModelListOfProduit;


public class MesVentesFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList= "argText";
    public ModelListOfProduit modelList ;
    ListView listView;

    public static MesVentesFragment newInstance(ModelListOfProduit modelListOfProduit) {
        MesVentesFragment fragment = new MesVentesFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_mesventes, container, false);
        listView = (ListView) myView.findViewById(R.id.list_vente);

        if (getArguments() != null && modelList==null) {
            modelList = getArguments().getParcelable(ARG_ModelList);
        }
        FloatingActionButton mFab = (FloatingActionButton) myView.findViewById(R.id.buttonfab);
        mFab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame
                                , new CalenderFragment())
                        .commit();



            }

        });

        CustomListView customListView= new CustomListView(getActivity(),modelList.getListProduitVente(), 1);
        listView.setAdapter(customListView);

        return myView;

    }

}

