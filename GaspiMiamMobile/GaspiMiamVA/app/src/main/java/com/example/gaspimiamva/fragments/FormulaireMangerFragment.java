package com.example.gaspimiamva.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
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

public class FormulaireMangerFragment extends Fragment {
    View myView;
    private static final String ARG_ModelList = "argText";
    public Produit produit;

    public static FormulaireMangerFragment newInstance(Produit produit) {
        FormulaireMangerFragment fragment = new FormulaireMangerFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, produit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_formulaire_manger, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduitFormManger);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduitFormManger);
        EditText descriptionProduit = myView.findViewById(R.id.editText2FormManger);
        EditText quantiteProduit = myView.findViewById(R.id.quantiteFormManger);

        Button buttonMangerForm= myView.findViewById(R.id.buttonMangerFormManger);

        if (getArguments() != null && produit==null) {
            produit = getArguments().getParcelable(ARG_ModelList);
        }

        nomProduit.setText(produit.getName());
        imageProduit.setImageResource(produit.getImage());
        descriptionProduit.setText(produit.getDescription());
        quantiteProduit.setText(produit.getQuantite().toString());

        buttonMangerForm.setOnClickListener(new View.OnClickListener() {
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
