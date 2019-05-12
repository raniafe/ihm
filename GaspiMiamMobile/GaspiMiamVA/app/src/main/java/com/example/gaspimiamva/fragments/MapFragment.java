package com.example.gaspimiamva.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View myView;
    public ModelListOfProduit modelList;

    private Activity context;

    public MapFragment(){

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_map, container, false);
        return myView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);


        mMapView = (MapView) myView.findViewById(R.id.map);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getActivity());
        mGoogleMap= googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).title("Ajouter un produit ici"));

            }
        });

        //LatLng Olives = new LatLng(43.615280, 7.072272);
        //LatLng Pommes = new LatLng(49.079255, -0.655125);
        //LatLng locperso = new LatLng(location.getLatitude(),location.getLongitude());
        //googleMap.addMarker(new MarkerOptions().position(Olives).title("1 sac d'olives "));
        //googleMap.addMarker(new MarkerOptions().position(locperso).title("5kg de pommes "));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(Olives));
        int i=0;
        for(Produit produit : modelList.getListProduitsBoutique()){
            googleMap.addMarker(new MarkerOptions().position(produit.getPositiongps()).title(produit.getName()).zIndex(i));
            i++;
        }

        mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                System.out.println(marker.getTitle());
                if ( ! marker.getTitle().equals("Ajouter un produit ici")){
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , ProduitBoutiqueFragment.newInstance(modelList.getListProduitsBoutique().get(Math.round(marker.getZIndex())),modelList))
                        .commit();
            }else{
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.content_frame
                                    , FormulaireVenteFragment.newInstance(modelList.getListProduitsBoutique().get(Math.round(marker.getZIndex())),1,modelList))
                            .commit();
                }
            }
        });
    }}
