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


public class BoutiqueFragment extends Fragment {

    ListView lst;
    String[] produit={"Poisson","Avocat","yaourt","escalope"};
    String[] descri={"hi","hi","hi","hi"};
    Integer[] image={R.drawable.poisson,R.drawable.avocat,R.drawable.yaourt,R.drawable.escalope};
    String[] prix={"1 euro","1","A","hi","hi"};
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_boutique, container, false);

        lst = (ListView) myView.findViewById(R.id.list);

        CustomListView customListView= new CustomListView(getActivity(),produit,image,descri,prix);
        lst.setAdapter(customListView);
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

        return myView;
    }



}
