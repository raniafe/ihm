package com.example.gaspimiamva.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.Produit;

import java.util.ArrayList;

public class MesVentesFragment extends Fragment {

     ArrayList<Produit> lst ;



    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_mesventes, container, false);
        return myView;
    }
}
