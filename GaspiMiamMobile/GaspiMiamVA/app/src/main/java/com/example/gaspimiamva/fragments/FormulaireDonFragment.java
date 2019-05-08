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

public class FormulaireDonFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList = "argText";
    public Produit produit;

    public static FormulaireDonFragment newInstance(Produit produit) {
        FormulaireDonFragment fragment = new FormulaireDonFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, produit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_formulaire_don, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduitFormDon);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduitFormDon);
        EditText descriptionProduit = myView.findViewById(R.id.editText2FormDon);
        EditText quantiteProduit = myView.findViewById(R.id.quantiteFormDon);
        EditText prixProduit = myView.findViewById(R.id.prixFormDon);
        CheckedTextView fruitChecked = myView.findViewById(R.id.checkedFruitDon);
        CheckedTextView legumeChecked = myView.findViewById(R.id.checkedLegumeDon);
        CheckedTextView autreChecked = myView.findViewById(R.id.checkedAutreDon);
        Button buttonDonnerDonForm= myView.findViewById(R.id.buttonDonnerFormDon);

        if (getArguments() != null && produit==null) {
            produit = getArguments().getParcelable(ARG_ModelList);
        }

        nomProduit.setText(produit.getName());
        imageProduit.setImageResource(produit.getImage());
        prixProduit.setText("0 €");
        descriptionProduit.setText(produit.getDescription());
        quantiteProduit.setText(produit.getQuantite().toString());

        if (fruitChecked.isChecked()){
            produit.setCategorie("fruit");
        }else if (legumeChecked.isChecked()){
            produit.setCategorie("légume");
        }else if(autreChecked.isChecked()){
            produit.setCategorie("autre");
        }
        if (buttonDonnerDonForm.isSelected()){
            Integer qt = Integer.parseInt(quantiteProduit.getText().toString());
            produit.setQuantite(produit.getQuantite() - qt);
        }

        buttonDonnerDonForm.setOnClickListener(new View.OnClickListener() {
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
