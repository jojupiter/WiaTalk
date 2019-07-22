package com.example.fofe.wiatalk.Contacts;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fofe.wiatalk.DatabaseManager.DatabaseManager;
import com.example.fofe.wiatalk.MainActivity;
import com.example.fofe.wiatalk.PageAdapter.RecyclerViewAdapterContact;
import com.example.fofe.wiatalk.R;

import java.util.ArrayList;
import java.util.List;


public class contactFragment extends Fragment {


    private View v;
    private RecyclerView myrecyclerView;
    private List<Contact> lsContact;
private DatabaseManager databaseManager;


    public contactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v=inflater.inflate(R.layout.fragment_contact, container, false);
        myrecyclerView= (RecyclerView)v.findViewById(R.id.contactRecycler);
        RecyclerViewAdapterContact recyclerViewAdapterContact= new RecyclerViewAdapterContact(getContext(),lsContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapterContact);
//databaseManager= new DatabaseManager(getActivity());
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
databaseManager= MainActivity.getDatabaseManager();
        lsContact= new ArrayList<>();
        showContacts();
    }
    private void showContacts(){

        String sql="SELECT NameContact,PhotoProfil,Pseudo,Tel,actuProfil FROM Contact ORDER BY NameContact ASC;";
        Cursor cursor = databaseManager.getReadableDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()) {


            String NameContact = cursor.getString(0);
            Integer PhotoProfil = cursor.getInt(1);
            String Pseudo = cursor.getString(2);
            Integer Tel = cursor.getInt(3);
            String actuProfil = cursor.getString(4);

            Contact contact = new Contact(NameContact, Tel, PhotoProfil, Pseudo,actuProfil);
            lsContact.add(contact);
        }
    }


}
