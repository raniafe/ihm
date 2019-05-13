package com.example.gaspimiamva.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.activites.Contact;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;

public class ProduitBoutiqueFragment extends Fragment {
    View myView;
    private static final String ARG_ModelList = "argText";
    private static final String ARG_Model = "argModel";
    public Produit produit;
    private ModelListOfProduit modelListOfProduit;

    public static ProduitBoutiqueFragment newInstance(Produit produit, ModelListOfProduit modelListOfProduit) {
        ProduitBoutiqueFragment fragment = new ProduitBoutiqueFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, produit);
        args.putParcelable(ARG_Model, modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.produit_boutique, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduit);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduit);
        TextView descr = myView.findViewById(R.id.de);
        final EditText quantiteProduit = myView.findViewById(R.id.quantite);
        Button buttonReserverProduit = myView.findViewById(R.id.butttonReserver);
        Button buttonContact=myView.findViewById(R.id.add);
        final TextView quant = myView.findViewById(R.id.quant);
        final TextView erreur = myView.findViewById(R.id.Erreur);


        if (getArguments() != null && produit == null) {
            produit = getArguments().getParcelable(ARG_ModelList);
            modelListOfProduit = getArguments().getParcelable(ARG_Model);
        }
        nomProduit.setText(produit.getName());
        descr.setText(produit.getDescription());
        quant.setText(produit.getQuantite().toString());
        imageProduit.setImageResource(produit.getImage());
        buttonReserverProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int quantit;
                if (quantiteProduit.getText().toString().equals("") )
                {
                    erreur.setText("Veuillez saisir la quantité désirée.");
                }
                else if(Integer.parseInt(quantiteProduit.getText().toString())<=0 || Integer.parseInt(quantiteProduit.getText().toString())> produit.getQuantite())
                {
                    erreur.setText("La quantité saisie est hors-norme.");
                }
                else
                {
                    quantit = Integer.parseInt(quantiteProduit.getText().toString());
                    Produit produit1 = new Produit(produit.getName(),quantit,produit.getCategorie(),produit.getDate(),produit.getImage(),produit.getDescription());
                    if(quantit== produit.getQuantite()) {
                        produit1.setQuantite(quantit);
                        modelListOfProduit.deleteBoutique(produit);

                    }
                    modelListOfProduit.addReservation(produit1);
                    produit.setQuantite(produit.getQuantite()-quantit);

                    FragmentManager manager = (getActivity()).getFragmentManager();
                    manager.beginTransaction()
                        .replace(R.id.content_frame
                                , MesReservationsFragment.newInstance(modelListOfProduit))
                        .commit();}
            }
        });
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    FragmentManager manager = (getActivity()).getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , ContactFragment.newInstance())
                            .commit();}
            });
        return myView;

    }
}
