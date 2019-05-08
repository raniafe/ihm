package com.example.gaspimiamva.fragments;

import android.app.Fragment;
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
import com.example.gaspimiamva.models.Produit;
import com.example.gaspimiamva.models.UserModel;

import java.util.ArrayList;

public class ModifierMonCompteFragment  extends Fragment {

    ArrayList<Produit> lst;
    View myView;
    private UserModel user ;
    private static final String ARG_User= "argText";
    private EditText nom ;
    private EditText prenom ;
    private EditText adresse ;
    private EditText mdp ;
    private EditText telephone ;
    private Button submit ;



    public static ModifierMonCompteFragment newInstance(UserModel user) {
        ModifierMonCompteFragment fragment = new ModifierMonCompteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_User,user);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_modifier_compte, container, false);
        nom = myView.findViewById(R.id.nom) ;
        prenom = myView.findViewById(R.id.prenom) ;
        adresse = myView.findViewById(R.id.adresse) ;
        telephone = myView.findViewById(R.id.telephone);
        submit = myView.findViewById(R.id.submit);
        mdp = myView.findViewById(R.id.mdp) ;


        if (getArguments() != null && user==null) {
            user = getArguments().getParcelable(ARG_User);
        }

        nom.setText(user.getName());
        prenom.setText(user.getFirstName());
        adresse.setText(user.getAdresse());
        telephone.setText(user.getNumeroMobile());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mdp.getText().equals(user.getMdp())) user.setMdp(mdp.getText().toString());
                if(!nom.getText().equals(user.getName())) user.setName(nom.getText().toString());
                if(!prenom.getText().equals(user.getFirstName())) user.setFirstName(prenom.getText().toString());
                if(!telephone.getText().equals(user.getNumeroMobile())) user.setNumeroMobile(telephone.getText().toString());

            }
        });
        return myView;


    }

}