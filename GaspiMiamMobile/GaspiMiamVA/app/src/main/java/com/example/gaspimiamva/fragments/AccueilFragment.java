package com.example.gaspimiamva.fragments;
import android.Manifest;
import android.accounts.AccountManager;
import android.app.Fragment;
import android.app.FragmentManager;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.icu.util.GregorianCalendar;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log ;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static android.app.Activity.RESULT_OK;
import static android.support.constraint.Constraints.TAG;
import static java.lang.System.exit;


public class AccueilFragment extends Fragment {

    View myView;
    private static final String ARG_ModelList= "argText";
    public ModelListOfProduit modelList ;
    private Button butt;

    public static AccueilFragment newInstance(ModelListOfProduit modelListOfProduit) {
        AccueilFragment fragment = new AccueilFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList,modelListOfProduit);
         fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_accueil, container, false);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        Fragment fragment2 = fm.findFragmentById(R.id.fragmentContainer1);
        Fragment fragment3 = fm.findFragmentById(R.id.fragmentContainer2);
        butt= myView.findViewById(R.id.button2) ;
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2019, 1, 1, 8, 0);
        final long startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(2019, 4, 1, 8, 0);
        final long endMillis = endTime.getTimeInMillis();
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
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.WRITE_CALENDAR);
                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
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
            }
        });



        if (getArguments() != null && modelList==null) {
            modelList = getArguments().getParcelable(ARG_ModelList);
        }

        fragment = HorizontalListViewFragment.newInstance(modelList.getListProduitsBoutiqueGratuits(),1,modelList);
        fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();

        fragment2 = HorizontalListViewFragment.newInstance(modelList.getListProduitsStock(),0,modelList);
        fm.beginTransaction()
                    .add(R.id.fragmentContainer1, fragment2)
                    .commit();
        fragment3 = HorizontalListViewFragment.newInstance(modelList.getListProduitReservation(),0,modelList);
        fm.beginTransaction()
                .add(R.id.fragmentContainer2, fragment3)
                .commit();

        return myView;
    }


    private void insertEntry(String pTitle, String pDescription, String pLocation, long pStartTimestamp, long pEndTimestamp) {
      /*  ContentValues values = new ContentValues();
        ContentResolver mContentResolver = getActivity().getContentResolver();
        values.put(CalendarContract.Events.CALENDAR_ID, CalendarContract.Calendars._ID);
        values.put(CalendarContract.Events.TITLE, pTitle);
        values.put(CalendarContract.Events.DESCRIPTION, pDescription);
        values.put(CalendarContract.Events.EVENT_LOCATION, pLocation);
        values.put(CalendarContract.Events.DTSTART, pStartTimestamp);
        values.put(CalendarContract.Events.DTEND, pEndTimestamp);
        values.put(CalendarContract.Events.HAS_ALARM, 1); // 0 for false, 1 for true
        values.put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getDisplayName()); //get the Timezone
        Uri uri = mContentResolver.insert(CalendarContract.Events.CONTENT_URI, values);
        Log.i(TAG,"calendar entry inserted");*/
        /*Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "My House Party");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Beach House");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "A Pig Roast on the Beach");
        GregorianCalendar calDate = new GregorianCalendar(2019, 5, 10);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                calDate.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                calDate.getTimeInMillis());
        intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);
        intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        intent.putExtra(CalendarContract.Events.RRULE, "FREQ=WEEKLY;COUNT=10;WKST=SU;BYDAY=TU,TH");


        startActivity(intent);*/


        ContentResolver cr = getActivity().getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, pStartTimestamp);
        values.put(CalendarContract.Events.TITLE, pTitle);
        values.put(CalendarContract.Events.DESCRIPTION, pDescription);
        TimeZone timeZone = TimeZone.getDefault();
        values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
// Default calendar
        values.put(CalendarContract.Events.CALENDAR_ID, 3);
        values.put(CalendarContract.Events.RRULE, "FREQ=WEEKLY;COUNT=10;WKST=SU;BYDAY=TU,TH");
// Set Period for 1 Hour
        values.put(CalendarContract.Events.DURATION, "+P1H");

        values.put(CalendarContract.Events.HAS_ALARM, 1);
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        Calendar dt = Calendar.getInstance();

// Where untilDate is a date instance of your choice, for example 30/01/2012

// If you want the event until 30/01/2012, you must add one day from our day because UNTIL in RRule sets events before the last day
        dt.add(Calendar.DATE, 2);


    }


    }
