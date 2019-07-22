package com.example.fofe.wiatalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.connexion.connexion;
import com.example.fofe.wiatalk.constants.constants;
import com.example.fofe.wiatalk.methods.methods;
import com.example.fofe.wiatalk.users.CreateUserActivity;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class MainActivity extends AppCompatActivity {


private static Socket socket;
private static DatabaseManager databaseManager;
private Button createAccount;
private String str;

//private Button login;

/////////////////////////////////////////////////getter and setter /////////////////////////
    public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public static void setDatabaseManager(DatabaseManager databaseManager) {
        MainActivity.databaseManager = databaseManager;
    }
////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        socket= connexion.ConnectToServer(socket);
        AffirmationConnection(socket);
        databaseManager= new DatabaseManager(this);

;
        createAccount= (Button)findViewById(R.id.createAccount);
        //login= (Button)findViewById(R.id.login);



         startProcedure();

       // socket.connect();
        //goToCreateUserActivity();
    }

    public static Socket getSocket() {
        return socket;
    }



    private  void startProcedure(){
// on verifie si il ya un client deja dans la bd
if(methods.userExist(databaseManager)){

    goToEpicenterActivity();

}
else {


    createAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToCreateUserActivity();
        }
    });


    }
}



    private void goToCreateUserActivity(){
        Intent intent = new Intent(
                MainActivity.this,
                CreateUserActivity.class
        );
        //intent.putExtra('relais', )
        startActivity(intent);

    }

    private void goToEpicenterActivity(){
        Intent intent = new Intent(
                MainActivity.this,
                epicenterActivity.class
        );
        //intent.putExtra('relais', )
        startActivity(intent);

    }









    private void AffirmationConnection( Socket msocket) {

final String tmp = "ok";

        msocket.on("affirmeConnection", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                try {
                    JSONObject messageJson = new JSONObject(args[0].toString());
                    str = messageJson.getString("info");
if(str.equals("ok")){

    Log.e("VERIFIRE","value str = "+str+"");
}
                    //if(receiver=="B")
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                                constants.setConnect(true);
                                Log.e("AFFIMATION_CONNECTION","value connect = "+constants.isConnect()+"  value str ="+str+"");



                        }



                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }




}

////////////////////////////////////////////////// URGENT   A LIRE



/*    - on verifie si il y a un client dans la base de donnee
      - si oui afficher l'activite du chat
      - si nom appeler la methode creer un nouvel utilisateur

// methods.isConnet dit si on est connecte au seveur ou non , or il le dit qu une seule fois , apres il garde tjr la valeur true
faudra arranger de sorte que :
                                  connect <=> connection au seveur



-ne pas enregistrer dans la BD locale alors que le seveur est indisponible
- user est d abord enregistrer sur le server avant d etre locale
-ajouter des restriction de carcteres sur les champs editests pour eviter les injections SQL
- autre probleme a gerer , on ne doit pas etre capable d enregistrer un contact existant ( comme pour le serveur ,
on doit faire un select avant pour verifier l existance de ce cpntact)
- dans chatFgrament , trouver un moyen d afficher les contacts recents
        */