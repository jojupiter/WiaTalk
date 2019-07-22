package com.example.fofe.wiatalk.users;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.MainActivity;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.constants.constants;
import com.example.fofe.wiatalk.epicenterActivity;
import com.example.fofe.wiatalk.methods.methods;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class CreateUserActivity extends AppCompatActivity {
private EditText nameText;
private  EditText pseudoText;
private EditText pwdText;
private EditText emaiText;
private EditText telText;
private Button button;
private Socket socket;
private int photo = 000;
private String actu = "";
private int tel=337;

private  DatabaseManager databaseManager=null;


private int NOTIFICATION_ID=12;


   private  String messageReceiver;
   private String transmitter;
   private String receiver;
   private user User;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
         socket= MainActivity.getSocket();
        databaseManager= new DatabaseManager(this);
         nameText= (EditText)findViewById(R.id.NameTest);
         pseudoText= (EditText)findViewById(R.id.PseudoTest);
         pwdText= (EditText)findViewById(R.id.PwdText);
         emaiText=(EditText)findViewById(R.id.EmailText);
         telText=(EditText)findViewById(R.id.TelText);
         button= (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 if(constants.isConnect()){

                     createUser();
                 }


             }
         });

if( constants.isConnect()==false )  createNotificationErrorConnection();


    }


    ////////////////////////////////////////////////////procedure for creating a user

    private void createUser(){
        //tel=Integer.parseInt(telText.getText().toString());
        sendInfoUser();
        Log.e("SERVER","send info user to server SUCESS");
        User=    new user(nameText.getText().toString(),emaiText.getText().toString(),pseudoText.getText().toString(),pwdText.getText().toString(),photo,actu,telText.getText().toString());

        try{
            Dao<user,Integer> userDao= getHelper().getUserDao();
            userDao.create(User);
            Log.e("DATABASE","save info user to database SUCESS");
        }catch (java.sql.SQLException e){
            Log.e("DATABASE","impossible d inserer un utilisateur",e);
        }


        button.setClickable(false);
        button.setBackgroundResource(R.color.colorButtonAfterClick);
        databaseManager.close();
        goToEpicenterActivity();
    }






/////////////////////////////////////////////////////////////////////////////////////methods utils
    private void sendInfoUser(){

tel= methods.takeTel(telText);
Log.e("TEL","value "+tel);

        JSONObject obj = new JSONObject();
        try{
            obj.put("name_user", nameText.getText().toString());
            obj.put("pseudo",pseudoText.getText().toString());
            obj.put("pwd",pwdText.getText().toString());
            obj.put("tel",tel);
            obj.put("email",emaiText.getText().toString());
            obj.put("photo_profil",photo);
            obj.put("actu",actu);

            socket.emit("createUser", obj);

        }catch (JSONException e){
        }
    }







    private void ListeningAck( Socket msocket) {


    msocket.on("ackServerToClient", new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            try {
                JSONObject messageJson = new JSONObject(args[0].toString());
                messageReceiver = messageJson.getString("message");
                transmitter = messageJson.getString("transmitter");
                receiver = messageJson.getString("receiver");
                //if(receiver=="B")
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (messageReceiver == "ACK" && transmitter == "server" && receiver == "client"){}


                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    });
}




    private final void createNotificationErrorConnection(){
        final NotificationManager mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        final Intent launchNotifiactionIntent = new Intent(this, CreateUserActivity.class);

        Notification.Builder builder = new Notification.Builder(this)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(getResources().getString(R.string.app_name))
                .setContentText(getResources().getString(R.string.notification_error_1));


        mNotification.notify(NOTIFICATION_ID, builder.build());
    }






    private DatabaseManager getHelper(){
        if(databaseManager==null){
            databaseManager= OpenHelperManager.getHelper(this,DatabaseManager.class);
        }
    return databaseManager;
    }





///////////////////////////////////////// go to activity from Chats
    private void goToEpicenterActivity(){
        Intent intent = new Intent(
                CreateUserActivity.this,
                epicenterActivity.class
        );
        //intent.putExtra('relais', )
        startActivity(intent);

    }


/////////////////////////////////////////////   send info to the server VOIP

    private void  sentInfoToserverVoip(){

    }


/////////////////////////////////

    }
//////////////////// NB
/*
- ne pas enregistrer dans la BD locale alors que le seveur est indisponible
- user est d abord enregistrer sur le server avant d etre locale

 */

