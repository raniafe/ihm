package com.example.gaspimiamva.adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.activites.Contact;

import java.util.ArrayList;

public class ContactListView extends ArrayAdapter<Contact> {
    private ArrayList<Contact> contacts;
    private Activity context;

    public ContactListView(Activity context, ArrayList<Contact> cts) {
        super(context, R.layout.listviewlayout,cts);
        this.context=context;
        this.contacts = cts;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder;
        if(r==null) {
            LayoutInflater layoutinf = context.getLayoutInflater();
            r=layoutinf.inflate(R.layout.listviewlayout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.tvName.setText(contacts.get(position).getName());
        viewHolder.tvNum.setText(contacts.get(position).getCellNum());

        return r;

    }


    class ViewHolder {
        TextView tvName;
        TextView tvNum;

        ViewHolder(View v) {
            tvName = v.findViewById(R.id.tvname);
            tvNum = v.findViewById(R.id.tvnum);
        }
    }

}
