package com.example.gaspimiamva.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.UserModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


public class formulaireFragment extends Fragment {

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




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_formulaire, container, false);
        butt = myview.findViewById(R.id.button3);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    if(permissionCheck!= PackageManager.PERMISSION_GRANTED){
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
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
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
}
