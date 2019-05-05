package com.example.gaspimiamva.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.Produit;

import java.util.ArrayList;

public class MesVentesFragment extends Fragment {

     ArrayList<Produit> lst ;
    View myView;


    private static final String ARG_ModelList = "argText";
    public Produit produit;

    public static FormulaireVenteFragment newInstance(Produit produit) {
        FormulaireVenteFragment fragment = new FormulaireVenteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, produit);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_mesventes, container, false);
        // TextView text = myView.findViewById(R.id.textView4);
        return myView;
    }
}
