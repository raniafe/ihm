package com.example.gaspimiamva.fragments;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.Produit;
import com.example.gaspimiamva.models.UserModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class ModifierMonCompteFragment  extends Fragment {

    private final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private final int PERMISSION_REQUEST_READ_MEDIA = 100;
    ArrayList<Produit> lst;
    View myView;
    private UserModel user;
    private static final String ARG_User = "argText";
    private EditText nom;
    private EditText prenom;
    private EditText adresse;
    private EditText mdp;
    private EditText telephone;
    private Button submit;
    private Button loadImage;
    private Button saveImage;
    private ImageView takephoto;
    private ImageView pdp;
    private Bitmap photo;
    private String pictureName="profile_pic" ;


    public static ModifierMonCompteFragment newInstance(UserModel user) {
        ModifierMonCompteFragment fragment = new ModifierMonCompteFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_User, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_modifier_compte, container, false);
        nom = myView.findViewById(R.id.nom);
        prenom = myView.findViewById(R.id.prenom);
        adresse = myView.findViewById(R.id.adresse);
        telephone = myView.findViewById(R.id.telephone);
        submit = myView.findViewById(R.id.submit);
        saveImage = myView.findViewById(R.id.save);
        mdp = myView.findViewById(R.id.mdp);
        takephoto = myView.findViewById(R.id.cam);
        pdp = myView.findViewById(R.id.pdp);
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

       /* loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permissionCheck!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_READ_MEDIA);
                }
                else
                {
                  // loadImageFromStorage("/data/user/0/com.example.gaspimiam");
                }
            }
        });*/


        if (getArguments() != null && user == null) {
            user = getArguments().getParcelable(ARG_User);
        }

        nom.setText(user.getName());
        prenom.setText(user.getFirstName());
        adresse.setText(user.getAdresse());
        telephone.setText(user.getNumeroMobile());
        if(user.getPhoto()!=null){
            pdp.setImageBitmap(user.getPhoto());
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mdp.getText().equals(user.getMdp())) user.setMdp(mdp.getText().toString());
                if (!nom.getText().equals(user.getName())) user.setName(nom.getText().toString());
                if (!prenom.getText().equals(user.getFirstName()))
                    user.setFirstName(prenom.getText().toString());
                if (!telephone.getText().equals(user.getNumeroMobile()))
                    user.setNumeroMobile(telephone.getText().toString());

                FragmentManager manager = getActivity().getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , ModifierMonCompteFragment.newInstance(user))
                        .commit();


            }
        });

        return myView;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                photo = (Bitmap) data.getExtras().get("data");
                pdp.setImageBitmap(photo);
                saveImage.setAlpha(1f);
                user.setImage(photo);

            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(getContext(),"Action Cancelled",5);
            }
            else {
                Toast.makeText(getContext(),"Action Failed",5);
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
                default:break;


    }
}

    private void saveToInternalStorage(Bitmap photo) {
        ContextWrapper cw = new ContextWrapper(getActivity().getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE) ;
        File file = new File(directory,pictureName);
        FileOutputStream fos = null ;
        try{
            fos = new FileOutputStream(file);
            photo.compress(Bitmap.CompressFormat.PNG,100,fos);

        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
            final String s = (String) MediaStore.Images.Media.insertImage((ContentResolver) getActivity().getContentResolver(), file.getPath(),pictureName,"");
            Toast.makeText(getContext(),"New Picture Saved",Toast.LENGTH_LONG);
        }catch (FileNotFoundException e){
            e.printStackTrace();

        }

    }

}