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
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.Fragment;
import android.widget.Toast;


import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.activites.IAgenda;
import com.example.gaspimiamva.adapters.CalendarManager;
import com.example.gaspimiamva.adapters.CustomListView;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;
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


    private static final String ARG_User = "argText";
    private EditText nomProduit;
    private EditText quantiteProduit;
    private EditText descriptionProduit;
    private EditText prixProduit;
    private String categorie="";
    View myview;
    Button butt;
    private Button saveImage;
    private ImageView takephoto;
    private ImageView pdp;
    private Bitmap photo;
    private String pictureName = "profile_pic";
    private final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private final int PERMISSION_REQUEST_READ_MEDIA = 100;
    private Produit produit;
    Button buttonAjoutStock;
    private RadioButton filtFr ;
    private RadioButton filtLe ;
    private RadioButton filtAutre ;

    private static final String ARG_ModelList = "argText";
    public ModelListOfProduit modelList;
    private CalendarManager calendarManager;
    private CalendarView calendar;


    public static formulaireFragment newInstance(ModelListOfProduit modelListOfProduit) {
        formulaireFragment fragment = new formulaireFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ModelList, modelListOfProduit);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_formulaire, container, false);
        produit = new Produit();
        calendar = myview.findViewById(R.id.calendarView);

        if (getArguments() != null && modelList == null) {
            modelList = getArguments().getParcelable(ARG_ModelList);
        }
        Date currentDate = new Date(calendar.getDate());
        produit.setDate(currentDate);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                produit.setDate(new Date(year - 1900, month, dayOfMonth));
            }
        });

        //Request permissions
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR}, 1);

        calendarManager = new CalendarManager(getActivity());
        calendarManager.init();
        filtFr = myview.findViewById(R.id.fruit) ;
        filtLe = myview.findViewById(R.id.legumes) ;
        filtAutre = myview.findViewById(R.id.autres) ;

        filtFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filtFr);
            }
        });

        filtLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filtLe);
            }
        });

        filtAutre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(filtAutre);
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

        buttonAjoutStock = myview.findViewById(R.id.buttonajout);
        buttonAjoutStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomProduit = myview.findViewById(R.id.nomProduit);
                quantiteProduit = myview.findViewById(R.id.quantite);
                descriptionProduit = myview.findViewById(R.id.description);
                prixProduit = myview.findViewById(R.id.prixProduit);
                TextView erreur = myview.findViewById(R.id.erreur);
                if(categorie.equals("") || nomProduit.getText().equals("") ||quantiteProduit.getText().equals("") || descriptionProduit.getText().equals("")||prixProduit.getText().equals(""))
                {erreur.setText("Veuillez saisir tous les champs.");}
                else {
                    produit.setName(nomProduit.getText().toString());
                    produit.setQuantite(Integer.parseInt(quantiteProduit.getText().toString()));
                    produit.setDescription(descriptionProduit.getText().toString());
                    produit.setPrix(Integer.parseInt(prixProduit.getText().toString()));
                    produit.setCategorie(categorie);
                    addEventToCalendar();
                    FragmentManager manager = (getActivity()).getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , StockFragment.newInstance(modelList))
                            .commit();


                }


                modelList.addStock(produit);
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
                pdp.setImageBitmap(photo);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getContext(), "Action cancelled", Toast.LENGTH_LONG);
            } else {
                Toast.makeText(getContext(), "Action failed", Toast.LENGTH_LONG);
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
    public void onRadioButtonClicked(RadioButton view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.fruit:
                if(checked)
                { categorie="Fruit";}
                break;
            case R.id.legumes:
                if(checked)
                { categorie="Légume";}
                break;
            case R.id.autres :
                if(checked)
                { categorie="Autre";}
                break;

        }
    }

    private void addEventToCalendar(){
        if (ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("Holidays in United States");
            return;
        } else calendarManager.insert(produit);
    }



}
