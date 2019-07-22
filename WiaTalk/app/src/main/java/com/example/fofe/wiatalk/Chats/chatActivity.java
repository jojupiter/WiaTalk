package com.example.fofe.wiatalk.Chats;

import android.database.Cursor;
import android.os.Bundle;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import android.support.text.emoji.widget.EmojiEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.MainActivity;
import com.example.fofe.wiatalk.PageAdapter.RecyclerViewAdapterMessage;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.Sms.Sms;
import com.example.fofe.wiatalk.methods.methods;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class chatActivity  extends AppCompatActivity /* extends EmojiCompatActivity implements WhatsAppPanelEventListener*/ {
private ImageButton butSendMsg;
    private EmojiEditText whriteMsg;
private Socket socket;
private TextView nameLogoChat;
private  TextView statusLogoChat;
private CircleImageView profilLogoChat;
private CircleImageView sendIconMsg;
private Toolbar toolbar;
private String discussion;
private String messageReceiver;
private String transmitter;
private String receiver;
private  Sms sms;
private int tampon;
private int last_tampon=1000;
private RecyclerView recyclerViewSms;
private RecyclerViewAdapterMessage recyclerViewAdapterMessage;
private static List<Sms> lsSms;
    private DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmojiCompat.Config config = new BundledEmojiCompatConfig( this)
                .setReplaceAll(true)
                .setEmojiSpanIndicatorEnabled(true)
                //.setEmojiSpanIndicatorColor(Color.GREEN)
                .setEmojiSpanIndicatorEnabled(false);
        //.registerInitCallback(new EmojiCompat.InitCallback() {...})
        EmojiCompat.init(config);
        setContentView(R.layout.activity_chat);
        whriteMsg = (EmojiEditText)findViewById(R.id.chat_WhriteMsg);
        nameLogoChat= (TextView)findViewById(R.id.name_logo_chat_activity);
        statusLogoChat=(TextView)findViewById(R.id.status_logo_chat_activity);
        profilLogoChat=(CircleImageView)findViewById(R.id.profil_logo_chat_activity);
        sendIconMsg=(CircleImageView)findViewById(R.id.wiaTalk_icon_send);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout1);

        //
        lsSms= new ArrayList<>();
        recyclerViewSms= (RecyclerView)findViewById(R.id.smsRecycler);
        recyclerViewAdapterMessage = new RecyclerViewAdapterMessage(this,lsSms);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(Boolean.TRUE);
        recyclerViewSms.setLayoutManager(linearLayoutManager);
        recyclerViewSms.setAdapter(recyclerViewAdapterMessage);



        //
        getIncomingIntent();


        RefrechRecyclerViewSms(MainActivity.getDatabaseManager(),discussion);


        socket= MainActivity.getSocket();
       toolbar=(Toolbar)findViewById(R.id.toolbar_chat);

      // smsFragment.showMessages(MainActivity.getDatabaseManager(),discussion);


        sendIconMsg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
onClickedIconSend();
            }
        });;

    }


////////////////////////////////////////// send message//////////////////////////////////////////////////////////
    public void sendMsg(EmojiEditText  whriteMsg,Socket msocket){

        if(methods.isEmptyEmojiEditext(whriteMsg))
        {
            // null action
        }
        else {
            JSONObject obj = new JSONObject();
            try {
                obj.put("message", whriteMsg.getText().toString());
                obj.put("transmitter", methods.takeInfoUser(MainActivity.getDatabaseManager(),0));
                obj.put("receiver", discussion);
                msocket.emit("messageChat", obj);
                Log.e("SENDING THE MESSAGE","emit of event : messageChat SUCESS");

            } catch (JSONException e) {
            }
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






////////////////////////////////////////////receive message//////////////////////////////////////////////////////////////////


    private void ListeningMsg(  Socket msocket) {

        msocket.on("messageChatServer", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                try {
                    Log.e("RECEIVING THE MESSAGE","listen of event : messageChatServer SUCESS");
                    JSONObject messageJson = new JSONObject(args[0].toString());
                   messageReceiver = messageJson.getString("message");
                 transmitter     = messageJson.getString("transmitter");
                 receiver        = messageJson.getString("receiver");
                 tampon      = messageJson.getInt("tampon");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if(receiver.equals(methods.takeInfoUser(MainActivity.getDatabaseManager(),0)))
                            {

                                if(last_tampon==1000){

                                    last_tampon=tampon;
                                    Log.e("RECEIVING THE MESSAGE","listen of event : run the method CreateMsgDatabase   TAMPON ="+tampon);

                                    CreateMsgDatabase(MainActivity.getDatabaseManager(),transmitter,receiver,messageReceiver);
                                   //RefrechSmsFragment();
                                    Sms test_newSms = new Sms("invalid","invalid",transmitter,receiver,messageReceiver,receiver);
                                    updateRecyclerViewSms(test_newSms, transmitter);
                                }

                                else {

                                    if(last_tampon==tampon) {
                                        Log.e("message repetition","a message has been sent several times");
                                    }
                                    else {
                                        last_tampon=tampon;
                                        Log.e("RECEIVING THE MESSAGE","listen of event : run the method CreateMsgDatabase   TAMPON ="+tampon);

                                        CreateMsgDatabase(MainActivity.getDatabaseManager(),transmitter,receiver,messageReceiver);
                                        //RefrechSmsFragment();
                                        Sms test_newSms = new Sms("invalid","invalid",transmitter,receiver,messageReceiver,receiver);
                                        updateRecyclerViewSms(test_newSms,transmitter);

                                    }
                                }

                            }

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    private void CreateMsgDatabase(DatabaseManager databaseManager,String emetter,String receiver,String textMsg) {

        try {
            sms = new Sms("invalid", "invalid", emetter, receiver, textMsg, discussion);
            } catch (Exception e) {
            Log.e("ADD SMS", "error saving values for adding the message", e);

            }
            try {
            Dao<Sms, Integer> smsDao = getHelper(databaseManager).getSmsDao();
            smsDao.create(sms);
            //smsFragment.showMessages(databaseManager, discussion);
            Log.e("DATABASE", "save message of Discussion: " + sms.getDiscussion() + " to database SUCESS");
            } catch (java.sql.SQLException e) {
            Log.e("DATABASE", "unable to insert the message of the Discussion: " + sms.getDiscussion() + "", e);
            }

    }



// cette methode prend les elements pour actualiser l activite avec le nom , le profil du destinataire
    private void getIncomingIntent(){
        Log.e("PUT EXTRA INTENT","getIncomingIntent: checking for incoming intent");
        if(getIntent().hasExtra("nameLogoChat")){
            Log.e("HAS EXTRA INTENT","getIncoming: found  nameLogoChat");
            discussion=getIntent().getStringExtra("nameLogoChat");
            nameLogoChat.setText("  "+getIntent().getStringExtra("nameLogoChat"));
        }

        if(getIntent().hasExtra("statusLogoChat")){
            Log.e("HAS EXTRA INTENT","getIncoming: found  statusLogoChat");
            statusLogoChat.setText("  "+getIntent().getStringExtra("statusLogoChat"));

        }
        if(getIntent().hasExtra("profilLogoChat")){
            Log.e("HAS EXTRA INTENT","getIncoming: found  nameLogoChat");
            profilLogoChat.setImageResource(getIntent().getIntExtra("profilLogoChat",R.drawable.avatar));

        }

    }
    private  DatabaseManager getHelper(DatabaseManager databaseManager){
        if(databaseManager==null){
            databaseManager= OpenHelperManager.getHelper(this,DatabaseManager.class);
        }
        return databaseManager;
    }


    public void onClickedIconSend() {

        if (!methods.isEmptyEmojiEditext(whriteMsg)){
            CreateMsgDatabase(MainActivity.getDatabaseManager(),methods.takeInfoUser(MainActivity.getDatabaseManager(),0),discussion,whriteMsg.getText().toString());
            sendMsg(whriteMsg,socket);
            Sms test_newSms = new Sms("invalid","invalid",methods.takeInfoUser(MainActivity.getDatabaseManager(),0),discussion,whriteMsg.getText().toString() ,discussion);
            updateRecyclerViewSms(test_newSms, discussion);
            this.whriteMsg.setText("");

            ListeningMsg(socket);
/*
              startActivity(getIntent().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    finish();
*/
        }
    }

    private void RefrechRecyclerViewSms(DatabaseManager databaseManager,String discussion){

        recyclerViewSms.clearOnScrollListeners();

        String sql = "SELECT time_sent,time_receive,emetter,receiver,TextMsg FROM Sms WHERE Discussion=\""+discussion+"\" ";
        Cursor cursor = databaseManager.getReadableDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()) {


            String time_sent = cursor.getString(0);
            String time_receive = cursor.getString(1);
            String emetter = cursor.getString(2);
            String receiver = cursor.getString(3);
            String textMsg= cursor.getString(4);

            Sms sms = new Sms(time_sent, time_receive, emetter, receiver,textMsg,discussion);
            lsSms.add(sms);

    }}
    private  void updateRecyclerViewSms(Sms newSms,String Discussion){
        if(this.discussion.equals(Discussion)){
            Log.e("problemm","poooooooo");

        recyclerViewAdapterMessage.getLsSms().add(newSms);
        recyclerViewAdapterMessage.notifyDataSetChanged();
         recyclerViewSms.scrollToPosition(recyclerViewAdapterMessage.getItemCount()-1);

    }}

    private void affiche_noitification(){

    }



    //////////////////////////////////////////////////////overide de whatsapp
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.e("DEBUG","onPrepareOptionMenu");

        super.onCreateOptionsMenu(menu);
        this.getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("DEBUG","onOptionItemSelected");

        switch (item.getItemId()) {

            case android.R.id.home:
                if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    this.mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    this.mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }








}
