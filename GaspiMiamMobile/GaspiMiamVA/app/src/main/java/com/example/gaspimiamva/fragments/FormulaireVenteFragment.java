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
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;

public class FormulaireVenteFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList = "argText";
    private static final String ARG_Model = "arglist";
    private static final String ARG_quant = "quant";
    public Produit produit;
    public Integer quantite;
    private ModelListOfProduit modelListOfProduit ;

    public static FormulaireVenteFragment newInstance(Produit produit, Integer quantite, ModelListOfProduit modelListOfProduit) {
        FormulaireVenteFragment fragment = new FormulaireVenteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, produit);
        args.putParcelable(ARG_Model, modelListOfProduit);
        args.putInt(ARG_quant, quantite);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_formulaire_vente, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduit);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduit);
        TextView descriptionProduit = myView.findViewById(R.id.de);
        final TextView quantiteProduit = myView.findViewById(R.id.quant);
        final EditText prixProduit = myView.findViewById(R.id.prixForm);
        final EditText quantiteN = myView.findViewById(R.id.editText4);
        Button buttonVendreForm= myView.findViewById(R.id.buttonvendreFormVendre);

        if (getArguments() != null && produit==null) {
            produit = getArguments().getParcelable(ARG_ModelList);
            quantite = getArguments().getInt(ARG_quant);
            modelListOfProduit = getArguments().getParcelable(ARG_Model);
        }

        nomProduit.setText(produit.getName());
        imageProduit.setImageResource(produit.getImage());
        prixProduit.setText(produit.getPrix().toString() );
        descriptionProduit.setText(produit.getDescription());
        quantiteProduit.setText(quantite.toString());

        buttonVendreForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quant ;
                FragmentManager manager = (getActivity()).getFragmentManager();
                if(quantiteN.getText().toString().equals("") && quantite ==0 )
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , StockFragment.newInstance(modelListOfProduit))
                            .commit();
                else
                {
                    if(!quantiteN.getText().toString().equals(""))
                        quant = quantite +  Integer.parseInt(quantiteN.getText().toString());

                    else
                        quant = quantite;
                    if(produit.getQuantite() - quant <= 0)
                    {
                        modelListOfProduit.deleteStock(produit);
                        produit.setQuantite(quant);
                        produit.setPrix(Integer.parseInt(prixProduit.getText().toString()));

                    }

                    else
                    {

                        produit.setQuantite(produit.getQuantite() - quant);
                        Produit produit1 = new Produit(produit.getName(), quant,produit.getCategorie(), produit.getDate(), produit.getImage(),Integer.parseInt(prixProduit.getText().toString()),"", produit.getDescription(),produit.getPositiongps()) ;
                        modelListOfProduit.addBoutique(produit1);
                        modelListOfProduit.addMesVentes(produit1);

                    }
                    modelListOfProduit.addBoutique(produit);
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , MesVentesFragment.newInstance(modelListOfProduit))
                            .commit();


                }

            }
        });
        return myView;

    }
}