package com.example.gaspimiamva.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.adapters.CustomListView;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;


public class StockFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList= "argText";
    public ModelListOfProduit modelList ;
    ListView listView;

    public static StockFragment newInstance(ModelListOfProduit modelListOfProduit) {
        StockFragment fragment = new StockFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_stock, container, false);
        listView = (ListView) myView.findViewById(R.id.list_stock);

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
                                , formulaireFragment.newInstance(modelList))
                        .commit();



            }

        });

        CustomListView customListView= new CustomListView(getActivity(),modelList.getListProduitsStock(), 0);
        listView.setAdapter(customListView);

        return myView;

    }

}

