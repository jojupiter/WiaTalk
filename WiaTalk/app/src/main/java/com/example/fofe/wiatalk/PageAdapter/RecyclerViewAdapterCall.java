package com.example.fofe.wiatalk.PageAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fofe.wiatalk.Contacts.Contact;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.methods.methods;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterCall extends RecyclerView.Adapter<RecyclerViewAdapterCall.MyViewHolder>{

private Context context;
private List<Contact> mData;

    public RecyclerViewAdapterCall(Context context, List<Contact> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public  MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View v;
       v = LayoutInflater.from(context).inflate(R.layout.item_contact_call,parent,false);
MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
holder.tv_name.setText(mData.get(position).getNameContact());
holder.tv_DateLastCall.setText(methods.getDate());
holder.img_contact.setImageResource(mData.get(position).getPhotoProfil());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_DateLastCall;
        private CircleImageView img_contact;


    public MyViewHolder(View itemView) {
        super(itemView);
        tv_name =(TextView)itemView.findViewById(R.id.nameContact);
        tv_DateLastCall=(TextView)itemView.findViewById(R.id.lastTimeAppel);
        img_contact= (CircleImageView)itemView.findViewById(R.id.imgContact);
    }
}
}
