package com.example.gaspimiamva.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.activites.Contact;
import com.example.gaspimiamva.activites.MainActivity;
import com.example.gaspimiamva.adapters.ContactListView;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.UserModel;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {

    View myView;
    public Button delete, tel, sms;
    public TextView details;
    public ListView myList;
    public ArrayList<Contact> contacts = new ArrayList<>();

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_contact, container, false);

        //myList = myView.findViewById(R.id.listContact);

        //myList.setAdapter(new ContactListView(getActivity(),contacts));


        contacts.add(new Contact("Jean-Michel Test","0687091685"));

        details = myView.findViewById(R.id.contact01);
        String txt = this.contacts.get(0).getName()+" ("+this.contacts.get(0).getCellNum()+")";
        details.setText(txt);

        tel = myView.findViewById(R.id.tel);
        tel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String num = "tel:"+contacts.get(0).getCellNum();
                        Intent appel = new Intent(Intent.ACTION_CALL, Uri.parse(num));
                        startActivity(appel);
                    }
                }

        );

        sms = myView.findViewById(R.id.sms);
        sms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String num = "smsto:"+contacts.get(0).getCellNum();
                        Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse(num));
                        sms.putExtra("sms_body", "Bonjour, "+contacts.get(0).getName()+",\n");
                        startActivity(sms);
                    }
                }

        );

        delete = myView.findViewById(R.id.delete);
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }

        );

        return myView;

    }

    public void addContact(Contact c) {
        this.contacts.add(c);
    }

}