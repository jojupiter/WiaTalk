package com.example.fofe.wiatalk.PageAdapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fofe.wiatalk.Contacts.Contact;
import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.MainActivity;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.epicenterActivity;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterCreateContact extends RecyclerView.Adapter<RecyclerViewAdapterCreateContact.MyViewHolder>{




    private Context context;
    private List<Contact> mData;
    private Dialog myDialog;
    private Contact contact;
    private String actuContact;
    private String pseudoContact;

    public RecyclerViewAdapterCreateContact(Context context, List<Contact> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder vHolder = new RecyclerViewAdapterCreateContact.MyViewHolder(v);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_create_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView dialog_name_tv = (TextView)myDialog.findViewById(R.id.dialog_contact_name);
                final TextView dialog_phone_tv= (TextView)myDialog.findViewById(R.id.dialog_phone_contact);
                ImageView dialog_image_contact= (ImageView) myDialog.findViewById(R.id.dialog_image_contact);
                final Button dialog_butAddContact = (Button)myDialog.findViewById(R.id.dialog_but_add_contact);


 actuContact= mData.get(vHolder.getAdapterPosition()).getActuProfil();
 pseudoContact= mData.get(vHolder.getAdapterPosition()).getPseudo();
                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getNameContact());
                dialog_phone_tv.setText(String.valueOf(mData.get(vHolder.getAdapterPosition()).getTel()));
                dialog_image_contact.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhotoProfil());

/////////implement button creation contact
                dialog_butAddContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

createContact(dialog_name_tv.getText().toString(),dialog_phone_tv.getText().toString(),pseudoContact,actuContact, MainActivity.getDatabaseManager());
                        Toast.makeText(context,"Contact creer",Toast.LENGTH_SHORT).show();

                        dialog_butAddContact.setClickable(false);
                        Intent intent = new Intent(context,epicenterActivity.class);
                        context.startActivity(intent);

                    }
                });

  /////////////////////////

                myDialog.show();
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterCreateContact.MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getNameContact());
        holder.tv_actuContact.setText(R.string.actuContact);
        holder.img_contact.setImageResource(mData.get(position).getPhotoProfil());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_contact;

        private TextView tv_name;
        private TextView tv_actuContact;
        private CircleImageView img_contact;


        public MyViewHolder(View itemView) {

            super(itemView);
            item_contact= (LinearLayout)itemView.findViewById(R.id.item_contact_id);

            tv_name =(TextView)itemView.findViewById(R.id.nameContact);
            tv_actuContact=(TextView)itemView.findViewById(R.id.actuContact);
            img_contact= (CircleImageView)itemView.findViewById(R.id.imgContact);
        }
    }



    //////////////////////////////////////// METHODS linked to the Database  ///////////////



    public  void createContact(String name, String tel,String pseudo,String actu,DatabaseManager databaseManager){

        try {
            contact = new Contact(name, Integer.parseInt(tel), R.drawable.avatar, pseudo, actu);
        }catch (Exception e){
            Log.e("ADD CONTACT","error assignming of values for adding the contact",e);

        }
        try{
            Dao<Contact,Integer> contactDao= getHelper(databaseManager).getContactDao();
            contactDao.create(contact);
            Log.e("DATABASE","save info contact to database SUCESS");
        }catch (java.sql.SQLException e){
            Log.e("DATABASE","impossible d inserer un Contact",e);
        }


    }






    private DatabaseManager getHelper(DatabaseManager databaseManager){
        if(databaseManager==null){
            databaseManager= OpenHelperManager.getHelper(context,DatabaseManager.class);
        }
        return databaseManager;
    }


   //////////////////////////////////////////////////////////////////////////:::

    }





