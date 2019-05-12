package com.example.gaspimiamva.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;


import com.example.gaspimiamva.R;
import com.example.gaspimiamva.adapters.CustomListView;
import com.example.gaspimiamva.models.ModelListOfProduit;


public class BoutiqueFragment extends Fragment {

    ListView lst;
    View myView;
    RadioButton filtre;
    boolean filtr = false;
    private static final String ARG_ModelList = "argText";
    public ModelListOfProduit modelList;
    private CustomListView customListView;
    private RadioButton filt ;
    private RadioButton filtFr ;
    private RadioButton filtLe ;
    private RadioButton filtAutre ;


    public static BoutiqueFragment newInstance(ModelListOfProduit modelListOfProduit) {
        BoutiqueFragment fragment = new BoutiqueFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_boutique, container, false);

        lst = (ListView) myView.findViewById(R.id.list);
        // Check which radio button was clicked
        filt = myView.findViewById(R.id.filtre) ;
        filtFr = myView.findViewById(R.id.fruit) ;
        filtLe = myView.findViewById(R.id.legumes) ;
        filtAutre = myView.findViewById(R.id.autres) ;
        filt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filt);
            }
        });

        filtFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filtFr);
            }
        });

        filtLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filtLe);
            }
        });

        filtAutre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filtAutre);
            }
        });


        if (getArguments() != null && modelList == null) {
            modelList = getArguments().getParcelable(ARG_ModelList);

        }

        if (!filtr) {
            customListView = new CustomListView(getActivity(), modelList.getListProduitsBoutique(), 1);
        } else
            customListView = new CustomListView(getActivity(), modelList.getListProduitsBoutiqueGratuits(), 1);
        lst.setAdapter(customListView);

        return myView;

    }

    public void onRadioButtonClicked(RadioButton view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.filtre:
                if (checked)
                { filtr = true ;
                    customListView = new CustomListView(getActivity(), modelList.getListProduitsBoutiqueGratuits(), 1);
                    lst.setAdapter(customListView);
                    filtAutre.setChecked(false); filtFr.setChecked(false);filtLe.setChecked(false);

                }
                    break;
            case R.id.fruit:
                    if(checked)
                    {
                        customListView = new CustomListView(getActivity(), modelList.filtrerListParCategorie("Fruit",modelList.getListProduitsBoutique()), 1);
                        lst.setAdapter(customListView);
                        filtAutre.setChecked(false); filt.setChecked(false);filtLe.setChecked(false);
                    }
                    break;
            case R.id.legumes:
                if(checked)
                {
                    customListView = new CustomListView(getActivity(), modelList.filtrerListParCategorie("Légume",modelList.getListProduitsBoutique()), 1);
                    lst.setAdapter(customListView);
                    filtAutre.setChecked(false); filt.setChecked(false);filtFr.setChecked(false);

                }
                break;
            case R.id.autres :
                if(checked)
                {
                    customListView = new CustomListView(getActivity(), modelList.filtrerListParCategorie("Autre",modelList.getListProduitsBoutique()), 1);
                    lst.setAdapter(customListView);
                    filtFr.setChecked(false); filt.setChecked(false);filtLe.setChecked(false);

                }
                break;

        }
    }
}




