package com.example.fofe.wiatalk.PageAdapter;

import android.content.Context;
import android.support.text.emoji.widget.EmojiTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fofe.wiatalk.MainActivity;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.Sms.Sms;
import com.example.fofe.wiatalk.methods.methods;

import java.util.List;

public class RecyclerViewAdapterMessage extends RecyclerView.Adapter<RecyclerViewAdapterMessage.CustomViewHolder>{

    public static class CustomViewHolder extends RecyclerView.ViewHolder{


        private EmojiTextView Textmsg;
        private TextView time;

        public CustomViewHolder(View itemView) {
            super(itemView);
            Textmsg= itemView.findViewById(R.id.textView_chat);
            time= itemView.findViewById(R.id.textView_time_chat);

        }
    }


private List<Sms> lsSms;
    private Context context;

    public RecyclerViewAdapterMessage(Context context,List<Sms> lsSms) {
 this.lsSms=lsSms;
 this.context= context;
    }

    public List<Sms> getLsSms() {
        return lsSms;
    }

    @Override

    public int getItemViewType(int position) {

if (lsSms.get(position).getEmetter().equals(methods.takeInfoUser(MainActivity.getDatabaseManager(),0))){
    return R.layout.item_chat_emitter;
}
return R.layout.item_chat_receiver;
    }

    @Override
    public RecyclerViewAdapterMessage.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(context).inflate(viewType,parent,false);
        CustomViewHolder vHolder = new CustomViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterMessage.CustomViewHolder holder, int position) {
        holder.Textmsg.setText(lsSms.get(position).getTextMsg());
        holder.time.setText(lsSms.get(position).getTime_sent());
    }

    @Override
    public int getItemCount() {
        return lsSms.size();
    }
}
