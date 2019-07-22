package com.example.fofe.wiatalk.PageAdapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fofe.wiatalk.Contacts.Contact;
import com.example.fofe.wiatalk.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterContact extends RecyclerView.Adapter<RecyclerViewAdapterContact.MyViewHolder>{


    private Context context;
    private List<Contact> mData;
private Dialog myDialog;
    public RecyclerViewAdapterContact(Context context, List<Contact> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder vHolder = new RecyclerViewAdapterContact.MyViewHolder(v);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_contact);
myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

     vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             TextView dialog_name_tv = (TextView)myDialog.findViewById(R.id.dialog_contact_name);
             TextView dialog_phone_tv= (TextView)myDialog.findViewById(R.id.dialog_phone_contact);
             ImageView dialog_image_contact= (ImageView) myDialog.findViewById(R.id.dialog_image_contact);

             dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getNameContact());
            dialog_phone_tv.setText(String.valueOf(mData.get(vHolder.getAdapterPosition()).getTel()));
             dialog_image_contact.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhotoProfil());
           Toast.makeText(context,"Wait"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

             myDialog.show();
         }
     });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterContact.MyViewHolder holder, int position) {
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
}
