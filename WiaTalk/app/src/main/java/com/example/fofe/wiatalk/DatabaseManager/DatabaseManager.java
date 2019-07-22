package com.example.fofe.wiatalk.DatabaseManager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.fofe.wiatalk.Contacts.Contact;
import com.example.fofe.wiatalk.Sms.Sms;
import com.example.fofe.wiatalk.users.user;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseManager extends OrmLiteSqliteOpenHelper{


    private static final String DATABASE_NAME = "test_db_5";
    private static final int DATABASE_VERSION = 8;
private Dao<user,Integer> userDao;
    private Dao<Contact,Integer> contactDao;
    private Dao<Sms,Integer> smsDao;

    public DatabaseManager(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try{

            TableUtils.createTable(connectionSource,user.class);
           TableUtils.createTable(connectionSource,Contact.class);
           TableUtils.createTable(connectionSource,Sms.class);
            Log.e("DATABASE","create database sucess  "+ DATABASE_VERSION+"" );

        }catch (Exception e){
            Log.e("DATABASE","Can't create database",e);
        };
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try{
            TableUtils.dropTable(connectionSource,user.class,true);
         TableUtils.dropTable(connectionSource,Contact.class,true);
         TableUtils.dropTable(connectionSource,Sms.class,true);

            onCreate(database,connectionSource);
            Log.e("DATABASE","update database sucess to "+ DATABASE_VERSION+"" );

        }catch (Exception e)
        {
            Log.e("DATABASE","can't update database to version   "+ DATABASE_VERSION+"",e );
        };
    }


public Dao<user,Integer> getUserDao()throws SQLException,java.sql.SQLException {

    if (userDao == null) {
        userDao = getDao(user.class);
    }

return userDao;
}

    public Dao<Contact,Integer> getContactDao()throws SQLException,java.sql.SQLException {

        if (contactDao == null) {
            contactDao = getDao(Contact.class);
        }

        return contactDao;
    }
    public Dao<Sms,Integer> getSmsDao()throws SQLException,java.sql.SQLException {

        if (smsDao == null) {
            smsDao = getDao(Sms.class);
        }

        return smsDao;
    }

}
