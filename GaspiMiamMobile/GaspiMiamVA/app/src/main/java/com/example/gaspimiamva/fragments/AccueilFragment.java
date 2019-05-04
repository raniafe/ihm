package com.example.gaspimiamva.fragments;
import android.app.Fragment;
import android.app.FragmentManager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log ;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;


public class AccueilFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList= "argText";
    public ModelListOfProduit modelList ;

    public static AccueilFragment newInstance(ModelListOfProduit modelListOfProduit) {
        AccueilFragment fragment = new AccueilFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,modelListOfProduit);
         fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_accueil, container, false);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        Fragment fragment2 = fm.findFragmentById(R.id.fragmentContainer1);


        if (getArguments() != null && modelList==null) {
            modelList = getArguments().getParcelable(ARG_ModelList);
        }

        fragment = HorizontalListViewFragment.newInstance(modelList.getListProduitsBoutiqueGratuits());
        fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();

        fragment2 = HorizontalListViewFragment.newInstance(modelList.getListProduitsStock());
        fm.beginTransaction()
                    .add(R.id.fragmentContainer1, fragment2)
                    .commit();

        return myView;
    }
}