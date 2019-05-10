package com.example.gaspimiamva.fragments;


import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
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

import java.util.Calendar;

public class ProduitFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList= "argText";
    private static final String ARG_Model= "argModel";
    public Produit produit ;
    private ModelListOfProduit modelListOfProduit ;
    private Button butt ;

    public static ProduitFragment newInstance(Produit produit, ModelListOfProduit modelListOfProduit) {
        ProduitFragment fragment = new ProduitFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,produit);
        args.putParcelable(ARG_Model,modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_produit_stock, container, false);

        TextView nomProduit = myView.findViewById(R.id.nomProduit);
        ImageView imageProduit = myView.findViewById(R.id.imageViewProduit);
        TextView descr = myView.findViewById(R.id.de);
        final EditText quantiteProduit = myView.findViewById(R.id.quantite);
        Button buttonVendreProduit = myView.findViewById(R.id.buttonVendre);
        Button buttonMangerProduit = myView.findViewById(R.id.buttonManger);
        Button buttonDonnerProduit = myView.findViewById(R.id.butttonDonner);
        butt=myView.findViewById(R.id.button3);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   /* ContentResolver cr = getActivity().getContentResolver();
                    ContentValues eventValues = new ContentValues();
                    eventValues.put(CalendarContract.Events.TITLE, "title");
                    eventValues.put(CalendarContract.Events.EVENT_LOCATION, "location");
                    eventValues.put(CalendarContract.Events.DTSTART, startMillis);
                    eventValues.put(CalendarContract.Events.DTEND, endMillis);
                    eventValues.put(CalendarContract.Events.CALENDAR_ID, "1");//Defaul calendar
                    eventValues.put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.SHORT);
                    cr.insert(CalendarContract.Events.CONTENT_URI, eventValues);
*/
             /*   Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, appointment.getStartOfCompleteDateAndTimeOfEvent())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, appointment.getEndOfCompleteDateAndTimeOfEvent())
                        .putExtra(CalendarContract.Events.TITLE, appointment.mTitle)
                        .putExtra(CalendarContract.Events.DESCRIPTION, appointment.mDescription)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, appointment.mAddress)
                        ;
                startActivity(intent);*/

                    /*long currentTimeMillis = System.currentTimeMillis();
                    // 設定活動結束時間為15分鐘後
                    long endTimeMillis = currentTimeMillis + 900000;

                    insertEntry("hh","ll","jj",currentTimeMillis,endTimeMillis);}*/

                    Log.d("calendar","I");
                    Calendar calendarEvent = Calendar.getInstance();
                    Intent intent = new Intent(Intent.ACTION_EDIT);
                    intent.setType("vnd.android.cursor.item/event");
                    intent.putExtra("beginTime", calendarEvent.getTimeInMillis());
                    intent.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
                    intent.putExtra("title", "Sample Event");
                    intent.putExtra("allDay", true);
                    intent.putExtra("rule", "FREQ=YEARLY");
                    startActivity(intent);



            }
        });
        final TextView quant= myView.findViewById(R.id.quant);


        if (getArguments() != null && produit==null) {
            produit = getArguments().getParcelable(ARG_ModelList);
            modelListOfProduit = getArguments().getParcelable(ARG_Model);
        }
        nomProduit.setText(produit.getName());
        descr.setText(produit.getDescription());
        quant.setText(produit.getQuantite().toString());
        imageProduit.setImageResource(produit.getImage());

        buttonVendreProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = (getActivity()).getFragmentManager();
                int quant ;
                if(quantiteProduit.getText().toString().equals(""))
                    quant =0 ;
                else
                    quant =Integer.parseInt(quantiteProduit.getText().toString());
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , FormulaireVenteFragment.newInstance(produit,quant,modelListOfProduit))
                        .commit();
            }
        });
        buttonDonnerProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // penser à afficher un message pour avertir de saisir une quantité
                // sinon par défaut l'utilisateur va donner tout son stock
                Integer quanti = produit.getQuantite() - Integer.parseInt( quantiteProduit.getText().toString()) ;
                produit.setQuantite(quanti);
                if( Integer.parseInt( quant.getText().toString())!=5) Log.d("Quantité","c'est pas nul");
                int quantit ;
                if(quantiteProduit.getText().toString().equals(""))
                    quantit =0 ;
                else
                    quantit =Integer.parseInt(quantiteProduit.getText().toString());

                Produit produit1 = new Produit(produit.getName(),0,produit.getCategorie(),produit.getDate(),produit.getImage(),0,"",produit.getDescription());
                if(quantit==0)
                {
                    produit1.setQuantite(produit.getQuantite());
                    produit.setQuantite(0);
                    modelListOfProduit.deleteStock(produit);
                }
                else {
                    produit1.setQuantite(quantit);
                    produit.setQuantite(new Integer(produit.getQuantite()-quantit));
                }
                modelListOfProduit.addMesVentes(produit1);
                modelListOfProduit.addBoutique(produit1);
                FragmentManager manager = (getActivity()).getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , ProduitFragment.newInstance(produit,modelListOfProduit))
                        .commit();
            }
        });
        buttonMangerProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // idem message d'alerte
                int quantit ;
                if(quantiteProduit.getText().toString().equals(""))
                    quantit =0 ;
                else
                    quantit =Integer.parseInt(quantiteProduit.getText().toString());
                Integer quanti = produit.getQuantite() - Integer.parseInt( quantiteProduit.getText().toString()) ;
                produit.setQuantite(quanti);
                FragmentManager manager = (getActivity()).getFragmentManager();
                if (quanti <=0) {
                    modelListOfProduit.deleteStock(produit);
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , StockFragment.newInstance(modelListOfProduit))
                            .commit();
                }
               else { manager.beginTransaction()
                        .replace(R.id.content_frame
                                , ProduitFragment.newInstance(produit,modelListOfProduit))
                        .commit();}
            }
        });

        return myView;
    }
}
