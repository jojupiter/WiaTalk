package com.example.fofe.wiatalk.Contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.MainActivity;
import com.example.fofe.wiatalk.R;
import com.example.fofe.wiatalk.epicenterActivity;
import com.example.fofe.wiatalk.methods.methods;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class CreateContact extends AppCompatActivity {

  private EditText nameContact;
  private EditText pseudoContact;
  private EditText telContact;
  private TextView actuContact;
  private ImageButton butGoodContact;
  private static JSONObject resulSeach = null;
private  Contact contact;
private  DatabaseManager  databaseManager;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Contact");
        setContentView(R.layout.activity_create_contact);

       databaseManager= new DatabaseManager(this);

       nameContact= (EditText) findViewById(R.id.NameTest_addcontact);
        pseudoContact= (EditText) findViewById(R.id.PseudoTest_addcontact);
        telContact= (EditText) findViewById(R.id.TelText_addcontact);
        actuContact=(TextView)findViewById(R.id.Actu_addcontact);
        butGoodContact=(ImageButton) findViewById(R.id.butGoodContact);

        butGoodContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // look various contacts on the server

                findContact(MainActivity.getSocket());
            }
        });
      ListenResulSeach(MainActivity.getSocket());

    }


    public  void createContact(String name, String tel,String pseudo,String actu){

        try {
            contact = new Contact(name, Integer.parseInt(tel), R.drawable.avatar, pseudo, actu);
        }catch (Exception e){
            Log.e("ADD CONTACT","error saving values for adding the contact",e);

        }
        try{
            Dao<Contact,Integer> contactDao= getHelper().getContactDao();
            contactDao.create(contact);
            Log.e("DATABASE","save info contact to database SUCESS");
        }catch (java.sql.SQLException e){
            Log.e("DATABASE","impossible d inserer un Contact",e);
        }

        databaseManager.close();
        butGoodContact.setClickable(false);

    }


//////////////////////// send info contact to the server/////////////////

    public void findContact(Socket msocket){

        if(methods.isEmptyEditext(nameContact)&&methods.isEmptyEditext(pseudoContact)&&methods.isEmptyEditext(telContact))
        {
            // null action
        }
        else {


            if(methods.isEmptyEditext(nameContact)) nameContact.setText(" ");
            if(methods.isEmptyEditext(pseudoContact))pseudoContact.setText(" ");
            if(methods.isEmptyEditext(telContact)) telContact.setText("0");
            JSONObject obj = new JSONObject();
            try {
                obj.put("name", nameContact.getText().toString());
                obj.put("pseudo", pseudoContact.getText().toString());
                obj.put("tel", telContact.getText().toString());
                msocket.emit("findContact", obj);
            } catch (JSONException e) {
            }
        }
    }

////////////////////////////////////////////////////////:get result of seach contact /////////////////////////////////




    private void ListenResulSeach( Socket msocket) {
        Log.e("ListenResultSeach ", "invocate ListenResultSearch" );

        msocket.on("getResultSeach", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                try {
            final JSONObject   jsonObject = new JSONObject(args[0].toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        resulSeach=jsonObject;
                            findContactFragment.showResultSeach(resulSeach);

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }





    ////////////////////////////////////////////////////

    private  DatabaseManager getHelper(){
        if(databaseManager==null){
            databaseManager= OpenHelperManager.getHelper(this,DatabaseManager.class);
        }
        return databaseManager;
    }


    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    private void goToEpicenterActivity(){
        Intent intent = new Intent(
                CreateContact.this,
                epicenterActivity.class
        );
        //intent.putExtra('relais', )
        startActivity(intent);

    }

    public static JSONObject getResulSeach() {
        return resulSeach;
    }
}
