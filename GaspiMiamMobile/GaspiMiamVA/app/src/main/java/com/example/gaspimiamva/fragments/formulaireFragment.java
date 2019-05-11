package com.example.gaspimiamva.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Fragment;
import android.widget.Toast;


import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.activites.IAgenda;
import com.example.gaspimiamva.models.UserModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;


public class formulaireFragment extends Fragment implements IAgenda {

    private String produit;
    private String descrip;
    private String prix;
    private Integer image;
    private Activity context;
    private UserModel user;
    private static final String ARG_User = "argText";
    private EditText nom;
    private EditText prenom;
    private EditText adresse;
    private EditText mdp;
    private EditText telephone;
    TextView tvprix;
    TextView tvprod;
    TextView tvdescri;
    ImageView img;
    View myview;
    Button butt;
    private Button saveImage;
    private ImageView takephoto;
    private ImageView pdp;
    private Bitmap photo;
    private String pictureName = "profile_pic";
    private final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private final int PERMISSION_REQUEST_READ_MEDIA = 100;
/*
    public static final String[] EVENT_PROJECTION = new String[] {
            CalendarContract.Calendars._ID,                           // 0
            CalendarContract.Calendars.ACCOUNT_NAME,                  // 1
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,         // 2
            CalendarContract.Calendars.OWNER_ACCOUNT                  // 3
    };
    // The indices for the projection array above.
    private static final int PROJECTION_ID_INDEX = 0;
    private static final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
    private static final int PROJECTION_DISPLAY_NAME_INDEX = 2;
    private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
    */



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_formulaire, container, false);
        butt = myview.findViewById(R.id.button3);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Specify the date

                /*

                long calID = 3;
                long startMillis = 0;
                long endMillis = 0;
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2019, 1, 1, 8, 0);
                startMillis = beginTime.getTimeInMillis();
                Calendar endTime = Calendar.getInstance();
                endTime.set(2020, 12, 31, 0, 0);
                endMillis = endTime.getTimeInMillis();


                ContentResolver cr = getActivity().getContentResolver();
                ContentValues values = new ContentValues();
                values.put(CalendarContract.Events.DTSTART, startMillis);
                values.put(CalendarContract.Events.DTEND, endMillis);
                values.put(CalendarContract.Events.TITLE, "Jazzercise");
                values.put(CalendarContract.Events.DESCRIPTION, "Group workout");
                values.put(CalendarContract.Events.CALENDAR_ID, calID);
                values.put(CalendarContract.Events.EVENT_TIMEZONE, "America/Los_Angeles");
                Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);

// get the event ID that is the last element in the Uri
                long eventID = Long.parseLong(uri.getLastPathSegment());
                System.out.println(eventID);
//
// ... do something with event ID
//
//*/

                Calendar beginTime = Calendar.getInstance();
                long calID = 3;
                long eventID = 208;
                beginTime.set(2012, 0, 19, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2012, 0, 19, 8, 30);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, "Nom du produit")
                        .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "Frigo")
                        // recuperer l'id du calendrier
                        .putExtra(CalendarContract.Events.CALENDAR_ID, calID)
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                        // adresses gmail auxquelles ont fait la publication
                        .putExtra(Intent.EXTRA_EMAIL, "jeanneDurant@example.com,fannykali@example.com")
                        .putExtra(CalendarContract.Events._ID, eventID);

// recuperer l'id de l'event
                // forcer la permission
                final int callbackId = 42;
                checkPermissions(callbackId, Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR);

                ContentResolver cr = getActivity().getContentResolver(); // fait beuguer : demande des droits alors qu'on les a
                ContentValues values = new ContentValues();
                Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);

// get the event ID that is the last element in the Uri
                long recupEventID = Long.parseLong(uri.getLastPathSegment());
                // TODO : utiliser l'id de l'event pour accéder au contenu donc a la date selectionnée

                startActivity(intent);


                /*

                INTENT DE BOUBOU


                Log.d("calender","i");
                Log.d("calendar", "I");
                Calendar calendarEvent = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", calendarEvent.getTimeInMillis());
                intent.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
                intent.putExtra("title", "Date d'expiration de tes ... ");
                intent.putExtra("allDay", true);
                intent.putExtra("rule", "FREQ=YEARLY");
                startActivity(intent);

                */
/*

                ESSAIS DE FANOU

                Date date = calendarEvent.getTime();
                System.out.println(date);
                calendarEvent.getDisplayNames();


                String id = intent.getStringExtra("id");
                System.out.println("id" +id);
                String name = intent.getStringExtra("name");
                System.out.println("name"+name);
                */

            }
        });

        saveImage = myview.findViewById(R.id.save);
        takephoto = myview.findViewById(R.id.cam);
        pdp = myview.findViewById(R.id.pdp);
        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
            }
        });
        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (photo !=null){
                    int permissionCheck= ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if(permissionCheck!= PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_READ_MEDIA);
                    }
                    else {
                        saveToInternalStorage(photo);
                    }
                }
            }
        });

        return myview;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                photo = (Bitmap) data.getExtras().get("data");
                saveImage.setAlpha(1f);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getContext(), "Action Cancelled", Toast.LENGTH_LONG);
            } else {
                Toast.makeText(getContext(), "Action Failed", Toast.LENGTH_LONG);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_READ_MEDIA:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                    // permission was granted, proceed to the normal flow.
                    saveToInternalStorage(photo);
                }
                break;
            default:
                break;


        }
    }

    private void saveToInternalStorage(Bitmap photo) {
        ContextWrapper cw = new ContextWrapper(getActivity().getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        File file = new File(directory, pictureName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            photo.compress(Bitmap.CompressFormat.PNG, 100, fos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            final String s = (String) MediaStore.Images.Media.insertImage((ContentResolver) getActivity().getContentResolver(), file.getPath(), pictureName, "");
            Toast.makeText(getContext(), "New Picture Saved", Toast.LENGTH_LONG);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    public String getContent(){
        return "hello";
    }

    public void checkPermissions(int callbackId, String... permissionsId) {
        boolean permissions = true;
        for (String p : permissionsId) {
            permissions = permissions && ContextCompat.checkSelfPermission(getContext(), p) == PERMISSION_GRANTED;
        }

        if (!permissions)
            ActivityCompat.requestPermissions(getActivity(), permissionsId, callbackId);
    }
}
