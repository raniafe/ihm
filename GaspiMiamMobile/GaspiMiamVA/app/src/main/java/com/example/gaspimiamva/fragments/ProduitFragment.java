package com.example.gaspimiamva.fragments;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;

public class ProduitFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList= "argText";
    public Produit produit ;

    public static ProduitFragment newInstance(Produit produit) {
        ProduitFragment fragment = new ProduitFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,produit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_produit_stock, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduit);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduit);
        EditText descriptionProduit = myView.findViewById(R.id.editText2);
        EditText quantiteProduit = myView.findViewById(R.id.editText4);
        Button buttonVendreProduit = myView.findViewById(R.id.buttonVendre);
        Button buttonMangerProduit = myView.findViewById(R.id.buttonManger);
        Button buttonDonnerProduit = myView.findViewById(R.id.butttonDonner);


        if (getArguments() != null && produit==null) {
            produit = getArguments().getParcelable(ARG_ModelList);
        }
        nomProduit.setText(produit.getName());
        descriptionProduit.setText(produit.getDescription());
        imageProduit.setImageResource(produit.getImage());
        quantiteProduit.setText(produit.getQuantite().toString());

        buttonVendreProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = (getActivity()).getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.cont_frame
                                , FormulaireVenteFragment.newInstance(produit))
                        .commit();
            }
        });
        buttonDonnerProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = (getActivity()).getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.cont_frame
                                , FormulaireDonFragment.newInstance(produit))
                        .commit();
            }
        });
        return myView;
    }
}
