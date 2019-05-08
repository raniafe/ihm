package com.example.gaspimiamva.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Fragment;

import com.example.gaspimiamva.R;


@SuppressLint("ValidFragment")
public class formulaireFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String produit;
    private String descrip;
    private String prix;
    private Integer image;
    private Activity context;
    TextView tvprix;
    TextView tvprod;
    TextView tvdescri;
    ImageView img;
    View myview;


    public formulaireFragment() {
    }

    public formulaireFragment(String produit, Integer image, String descri, String prix) {
        // Required empty public constructor
        this.produit = produit;
        this.descrip = descri;
        this.image = image;
        this.prix = prix;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_formulaire,container,false);
        
        tvprod=myview.findViewById(R.id.tvproduit);
       // tvprod.setText(produit);
        tvdescri=myview.findViewById(R.id.tvdescri);
       // tvdescri.setText(descrip);
        img=myview.findViewById(R.id.img);
        //img.setImageResource(image);

        return inflater.inflate(R.layout.fragment_formulaire, container, false);
    }
}