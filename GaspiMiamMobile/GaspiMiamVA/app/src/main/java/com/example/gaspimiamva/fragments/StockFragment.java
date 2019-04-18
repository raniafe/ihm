/*package com.example.gaspimiamva.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaspimiamva.R;

public class StockFragment extends Fragment {

    private GridView gridView;
    private ArrayAdapter<String> adapter;

    private static String [] produits_stocks={"patate", "courgette", "poire"};


    public static StockFragment newInstance(){
        StockFragment stock_fragment = new StockFragment();
        return stock_fragment;
    }

    @Nullable
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