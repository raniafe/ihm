package com.example.gaspimiamva.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Fragment;

import com.example.gaspimiamva.R;

import java.util.Calendar;


@SuppressLint("ValidFragment")
public class formulaireFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String produit;
    private String descrip;
    private String prix;
    private Integer image;
    private Activity context;
    TextView tvprix;
    TextView tvprod;
    TextView tvdescri;
    ImageView img;
    View myview;
    Button butt;


    public formulaireFragment() {
    }

    public formulaireFragment(String produit, Integer image, String descri, String prix) {
        // Required empty public constructor
        this.produit = produit;
        this.descrip = descri;
        this.image = image;
        this.prix = prix;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_formulaire,container,false);

        tvprod=myview.findViewById(R.id.tvproduit);
       // tvprod.setText(produit);
        tvdescri=myview.findViewById(R.id.tvdescri);
       // tvdescri.setText(descrip);
        img=myview.findViewById(R.id.img);
        //img.setImageResource(image);
        butt=myview.findViewById(R.id.button3);
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

        return inflater.inflate(R.layout.fragment_formulaire, container, false);

    }
}