package com.example.fofe.wiatalk.PageAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fofe.wiatalk.Chats.chatActivity;
import com.example.fofe.wiatalk.Contacts.Contact;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.methods.methods;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterChat extends RecyclerView.Adapter<RecyclerViewAdapterChat.MyViewHolder> {

    private Context context;
    private List<Contact> mData;

    public RecyclerViewAdapterChat(Context context, List<Contact> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_contact_chat, parent, false);
        final MyViewHolder vHolder = new RecyclerViewAdapterChat.MyViewHolder(v);



        ////////////////////////////////////////////////////////////////////////////////////////////
                    vHolder.item_contact_chat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                Intent intent = new Intent(context,chatActivity.class);
                                intent.putExtra("nameLogoChat",mData.get(vHolder.getAdapterPosition()).getNameContact());
                                intent.putExtra("statusLogoChat","online");
                                intent.putExtra("profilLogoChat",mData.get(vHolder.getAdapterPosition()).getPhotoProfil());
                                context.startActivity(intent);




                        }
                    });




                    /////////////////////////////////////////////////////////////////////////////////:
        return vHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterChat.MyViewHolder holder, int position) {
        holder.chat_name_contact.setText(mData.get(position).getNameContact());
        holder.chat_last_msg.setText(methods.getLastMsg());
        holder.chat_img_contact.setImageResource(mData.get(position).getPhotoProfil());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_contact_chat;
        private TextView chat_name_contact;
        private TextView chat_last_msg;
        private CircleImageView chat_img_contact;
        private Context mContext;


        public MyViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            item_contact_chat = (LinearLayout) itemView.findViewById(R.id.item_contact_chat_id);
            chat_name_contact = (TextView) itemView.findViewById(R.id.chat_nameContact);
            chat_last_msg = (TextView) itemView.findViewById(R.id.chat_lastMsg);
            chat_img_contact = (CircleImageView) itemView.findViewById(R.id.chat_imgContact);
        }

    }
}