package com.example.gaspimiamva.adapters;


import android.app.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.models.Produit;

import java.util.ArrayList;
import java.util.List;


public class CustomListView extends ArrayAdapter<Produit> {
    private ArrayList<Produit> Listproduit;
    private int id;

    private Activity context;

    public CustomListView(Activity  context, ArrayList<Produit> ListProduit, int id) {
        super(context, R.layout.listviewlayout,ListProduit);
        this.context=context;
        this.Listproduit = ListProduit;
        this.id = id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutinf=context.getLayoutInflater();
            r=layoutinf.inflate(R.layout.listviewlayout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.img.setImageResource(Listproduit.get(position).getImage());
        viewHolder.tvprod.setText(Listproduit.get(position).getName());
        viewHolder.tvdescri.setText(Listproduit.get(position).getCategorie());

        if (id ==1){
            viewHolder.tvid.setText((Listproduit.get(position).getPrix()).toString() + "€");
        }else{
            viewHolder.tvid.setText((Listproduit.get(position).getQuantite()).toString());
        }
        return r;
    }
    class ViewHolder{
        TextView tvid;
        TextView tvprod;
        TextView tvdescri;
        ImageView img;
        ViewHolder(View v){
            tvprod=(TextView)v.findViewById(R.id.tvproduit);
            tvid=(TextView)v.findViewById(R.id.tvid);
            tvdescri=(TextView)v.findViewById(R.id.tvdescri);
            img=(ImageView)v.findViewById(R.id.img);
        }
    }
}

