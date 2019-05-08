package com.example.gaspimiamva.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.Produit;

public class FormulaireVenteFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList = "argText";
    public Produit produit;

    public static FormulaireVenteFragment newInstance(Produit produit) {
        FormulaireVenteFragment fragment = new FormulaireVenteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, produit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_formulaire_vente, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduitForm);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduitForm);
        EditText descriptionProduit = myView.findViewById(R.id.editText2Form);
        EditText quantiteProduit = myView.findViewById(R.id.quantiteForm);
        EditText prixProduit = myView.findViewById(R.id.prixForm);
        CheckedTextView fruitChecked = myView.findViewById(R.id.checkedFruit);
        CheckedTextView legumeChecked = myView.findViewById(R.id.checkedLegume);
        CheckedTextView autreChecked = myView.findViewById(R.id.checkedAutre);
        Button buttonVendreForm= myView.findViewById(R.id.buttonvendreFormVendre);

        if (getArguments() != null && produit==null) {
            produit = getArguments().getParcelable(ARG_ModelList);
        }

        nomProduit.setText(produit.getName());
        imageProduit.setImageResource(produit.getImage());
        prixProduit.setText("par défaut  "+produit.getPrix().toString() + "€");
        descriptionProduit.setText(produit.getDescription());
        quantiteProduit.setText(produit.getQuantite().toString());

        if (fruitChecked.isChecked()){
            produit.setCategorie("fruit");
        }else if (legumeChecked.isChecked()){
            produit.setCategorie("légume");
        }else if(autreChecked.isChecked()){
            produit.setCategorie("autre");
        }

        buttonVendreForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = (getActivity()).getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , ProduitFragment.newInstance(produit))
                        .commit();
            }
        });
        return myView;

    }
}