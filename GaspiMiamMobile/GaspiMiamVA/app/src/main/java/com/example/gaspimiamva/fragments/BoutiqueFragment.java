package com.example.gaspimiamva.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.Toast;


import com.example.gaspimiamva.R;
import com.example.gaspimiamva.adapters.CustomListView;
import com.example.gaspimiamva.models.ModelListOfProduit;


public class BoutiqueFragment extends Fragment {

    ListView lst;
    View myView;
    private static final String ARG_ModelList= "argText";
    public ModelListOfProduit modelList ;

    public static BoutiqueFragment newInstance(ModelListOfProduit modelListOfProduit) {
        BoutiqueFragment fragment = new BoutiqueFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_boutique, container, false);

        lst = (ListView) myView.findViewById(R.id.list);


        if (getArguments() != null && modelList==null) {
            modelList = getArguments().getParcelable(ARG_ModelList);
        }
        CustomListView customListView= new CustomListView(getActivity(),modelList.getListProduitsBoutique(),1);
        lst.setAdapter(customListView);

        return myView;

        //CustomListView customListView= new CustomListView(getActivity(),produit,image,descri,prix);
        //lst.setAdapter(customListView);
    /*    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position==0){
                    Intent myitent= new Intent(view.getContext(),ProduitenVente.class);
                    startActivityForResult(myitent,0);
                }
                if(position==1){
                    Intent myitent= new Intent(view.getContext(),ProduitenVente.class);
                    startActivityForResult(myitent,1);
                }
                if(position==2) {
                    Intent myitent = new Intent(view.getContext(), ProduitenVente.class);
                    startActivityForResult(myitent, 2);
                }
                if(position==3){
                    Intent myitent= new Intent(view.getContext(),ProduitenVente.class);
                    startActivityForResult(myitent,3);
                }
                if(position==4){
                    Intent myitent= new Intent(view.getContext(),ProduitenVente.class);
                    startActivityForResult(myitent,4);
                }
            }

        });*/
    }



}
