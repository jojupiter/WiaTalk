package com.example.fofe.wiatalk.methods;

import android.database.Cursor;
import android.support.text.emoji.widget.EmojiEditText;
import android.util.Log;
import android.widget.EditText;

import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.R;


public  class methods {



    public static boolean isEmptyEditext(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public static boolean isEmptyEmojiEditext(EmojiEditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
    public static boolean isEmptyWhatsAppPanel(br.com.instachat.emojilibrary.controller.WhatsAppPanel etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public static  String getDate(){

        return "aujourd'hui , 12h30";
    }


 ////////////////////////////////////////  METHODS WITH DATABASE   ///////////////////////////////////////////////////////////////
   ///////////////// userExist
    public  static boolean userExist(DatabaseManager db){
        boolean bool = false;
        String sql="SELECT count(*)FROM user;";
        Cursor cursor= db.getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        int icount = cursor.getInt(0);
       Log.i("DATABASE","method.userExist() invoked ");
        if(icount>0) {

                bool=true;
            }
            cursor.close();

        return bool;
    }









    //////////////// take tel///////////////////////////////////////////////
    public static int takeTel(EditText editText){
        String tmp = editText.getText().toString();
        int tmp_2= Integer.parseInt(tmp);
        return tmp_2;

    }




    /////////////////////////////////////getLastMsg//////////////////////////


      public static String getLastMsg(){
        return "lastMsg";
      }

public static  String takeInfoUser(DatabaseManager databaseManager,int option){
/*

    name= option O
    pseudo = option 1
    email= option 2
    password = option 3
    photoProfil= option 4
    actuProfil = option 5
    tel = option 6

*/

    String sql="SELECT name,email,pseudo,Tel,actuProfil ,photoProfil ,pwd FROM user ;";

    Cursor cursor = databaseManager.getReadableDatabase().rawQuery(sql,null);

    String nameUser="vous n'avez pas de nom";
    String emailUser=" vous n avez pas d email";
    String pseudoUser=" vous n avez pas de pseudo";
    String TelUser="0";
    String actuProfilUser="vous n avez pas de d actu";
    String photoProfilUser= String.valueOf(R.drawable.adduser);
    String pwdUser="mot de passe non defini";
    String Default = " invalide option" ;
    if (cursor.moveToFirst()){
        do {
            // Passing values
             nameUser = cursor.getString(0);
             emailUser = cursor.getString(1);
             pseudoUser = cursor.getString(2);
             TelUser = String.valueOf(cursor.getInt(3));
             actuProfilUser = cursor.getString(4);
             photoProfilUser = String.valueOf(cursor.getInt(5));
             pwdUser = cursor.getString(6);

        } while(cursor.moveToNext());
    }
    cursor.close();

    switch (option){

        case 0:
            return nameUser;
        case 1:
            return emailUser;
        case 2:
            return pseudoUser;
            case 3:
        return TelUser;
        case 4:
            return actuProfilUser;
        case 5:
            return photoProfilUser;
        case 6:
            return pwdUser;
        default:
            return  Default;
    }



}






    ///////////////////////////////////////////:notification/////////////////////////////////////////////////
/*
* a simple  method that allows you to create a notification, just enter the string
*
* */




}




















