package com.example.gaspimiamva.fragments;
/**
 * Created by anonymous on 11/4/16.
 */

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.Produit;

import java.util.ArrayList;

public class HorizontalListViewFragment extends Fragment {

    RecyclerView MyRecyclerView;
    ModelListOfProduit modelListOfProduit ;
    ArrayList<Produit> listOfProduits =new ArrayList<>() ;
    private int id ;
    private static final String ARG_ModelList= "argText";
    private static final String ARG_Model= "argModel";
    private static final String ARG_ID= "argid";

    public static HorizontalListViewFragment newInstance(ArrayList<Produit> listOfProduit, int id, ModelListOfProduit modelListOfProduit) {
        HorizontalListViewFragment fragment = new HorizontalListViewFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_ModelList,listOfProduit);
        args.putParcelable(ARG_Model,modelListOfProduit);
        args.putInt(ARG_ID,id);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horizontal_list_view, container, false);

        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);

        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (getArguments() != null) {
            listOfProduits = getArguments().getParcelableArrayList(ARG_ModelList);
            id = getArguments().getInt(ARG_ID);
            modelListOfProduit = getArguments().getParcelable(ARG_Model);
        }

        if (listOfProduits.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listOfProduits,id));
        }

        MyRecyclerView.setLayoutManager(MyLayoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<Produit> list;
        private int id ;

        public MyAdapter(ArrayList<Produit> Data, int id) {
            list = Data;
            this.id =id ;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.titleTextView.setText(list.get(position).getName() +" "+ list.get(position).getQuantite() + " Kg");
            holder.coverImageView.setImageResource(list.get(position).getImage());
            holder.coverImageView.setTag(list.get(position).getImage());
            holder.likeImageView.setTag(R.drawable.ic_like);

            holder.coverImageView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(id==0)
                    {
                        FragmentManager manager = getActivity().getFragmentManager();
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , ProduitFragment.newInstance(list.get(position),modelListOfProduit))
                                .commit();}
                    else{
                        FragmentManager manager = getActivity().getFragmentManager();
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , ProduitBoutiqueFragment.newInstance(list.get(position),modelListOfProduit))
                                .commit();

                    }
                }
            }));
            if(id==1)
            { holder.likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = (int)holder.likeImageView.getTag();
                    if( id == R.drawable.ic_like){

                        holder.likeImageView.setTag(R.drawable.ic_liked);
                        holder.likeImageView.setImageResource(R.drawable.ic_liked);
                        Toast.makeText(getActivity(),holder.titleTextView.getText()+" added to your Reservations",Toast.LENGTH_SHORT).show();
                        modelListOfProduit.addReservation(list.get(position));
                        modelListOfProduit.deleteBoutique(list.get(position));

                    }else{

                        holder.likeImageView.setTag(R.drawable.ic_like);
                        holder.likeImageView.setImageResource(R.drawable.ic_like);
                        Toast.makeText(getActivity(),holder.titleTextView.getText()+" removed from your Reservations",Toast.LENGTH_SHORT).show();
                        modelListOfProduit.deleteReservation(list.get(position));
                        modelListOfProduit.addBoutique(list.get(position));
                    }

                }
            });}
            else holder.likeImageView.setImageBitmap(null);


        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);



            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));



                }
            });



        }
    }
}