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

public class CustumOfStockListView extends ArrayAdapter<String> {

    private String[] produit;
    private String[] description;
    private String[] price;
    private Integer[] image;
    private Activity context;

    public CustumOfStockListView(Activity  context, String[] produit, Integer[] image, String[] descri, String[] prix) {
        super(context, R.layout.listviewlayout,produit);
        this.context=context;
        this.produit=produit;
        this.description=descri;
        this.image=image;
        this.price=prix;
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
        viewHolder.img.setImageResource(image[position]);
        viewHolder.tvprod.setText(produit[position]);
        viewHolder.tvprix.setText(price[position]);
        viewHolder.tvdescri.setText(description[position]);

        return r;
    }
    class ViewHolder{
        TextView tvprix;
        TextView tvprod;
        TextView tvdescri;
        ImageView img;
        ViewHolder(View v){
            tvprod=(TextView)v.findViewById(R.id.tvproduit);
            tvprix=(TextView)v.findViewById(R.id.tvprix);
            tvdescri=(TextView)v.findViewById(R.id.tvdescri);
            img=(ImageView)v.findViewById(R.id.img);
        }
    }


}

