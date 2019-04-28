package com.example.gaspimiamva.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaspimiamva.R;


public class StockFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_stock, container, false);
        return myView;
    }
}

/*
public class StockFragment extends Fragment {
    View myView ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_boutique, container, false);
        return myView;
    }

    private GridView gridView;
    private ArrayAdapter<String> adapter;

    private static String [] produits_stocks={"patate", "courgette", "poire"};


    public static StockFragment newInstance(){
        StockFragment stock_fragment = new StockFragment();
        return stock_fragment;
    }

  /*  @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.stock, null);

        gridView = (GridView) view.findViewById(R.id.produits_stock);

        gridView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1
        ,  produits_stocks));

        gridView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), produits_stocks[position],Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


}

*/
