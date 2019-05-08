package com.example.gaspimiamva.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.UserModel;


public class MonCompteFragment extends Fragment {

    View myView;
    public Button modification ;
    private static final String ARG_User= "argText";
    private UserModel user ;
    private TextView prénom ;
    private TextView adresse ;


    public static MonCompteFragment newInstance(UserModel user) {
        MonCompteFragment fragment = new MonCompteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_User,user);
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_moncompte, container, false);


        if (getArguments() != null && user==null) {
            user = getArguments().getParcelable(ARG_User);
        }

        modification = myView.findViewById(R.id.modifier) ;
        prénom = myView.findViewById(R.id.prenom) ;
        adresse = myView.findViewById(R.id.adresse) ;
        prénom.setText(user.getFirstName());
        adresse.setText(user.getAdresse());

        modification.setOnClickListener(
                new View.OnClickListener()
                {@Override
                public void onClick(View view) {
                    FragmentManager manager = getActivity().getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , ModifierMonCompteFragment.newInstance(user))
                            .commit();
                }
                }

        );

        return myView;

    }



}