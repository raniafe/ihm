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
import com.example.gaspimiamva.adapters.CustumOfStockListView;


public class StockFragment extends Fragment {

    View myView;
    ListView listView;
    String[] product={"Carotte","Noix de coco","Pêche","Fraises","Tomate", "Yaourt"};
    String[] description={"de plein champs","de Martinique","du Maroc","des bois", "de plein champs", "fermier"};
    Integer[] image={R.drawable.carot,R.drawable.coconut, R.drawable.peach,R.drawable.strawberry,R.drawable.tomatoe,R.drawable.yogourt};
    String[] price={"2,5 €","7€","3,85€","2,4€","1,2€","3€"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_stock, container, false);
        listView = (ListView) myView.findViewById(R.id.list_stock);

        CustomListView customListView= new CustomListView(getActivity(),product,image,description,price);
        listView.setAdapter(customListView);

        return myView;
    }

}

