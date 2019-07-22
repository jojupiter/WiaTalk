package com.example.fofe.wiatalk.Contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fofe.wiatalk.PageAdapter.RecyclerViewAdapterCreateContact;
import com.example.fofe.wiatalk.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class findContactFragment extends Fragment {
String name="invalide";
    private View v;
    private RecyclerView myrecyclerView;
    private static List<Contact> lsContact;
    public findContactFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_find_contact, container, false);
        myrecyclerView= (RecyclerView)v.findViewById(R.id.id_recyclerView_create_contact);
        RecyclerViewAdapterCreateContact recyclerViewAdapterCreateContact= new RecyclerViewAdapterCreateContact(getContext(),lsContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapterCreateContact);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lsContact= new ArrayList<>();
    }

    public static void showResultSeach(JSONObject jsonObject) {

        if (jsonObject == null) {
            Log.e("BAD CONCEPTION ", "error in the logic conception of the application // jsonObject is NULL");
        } else {
            Log.e("GOOD CONCEPTION ", "the logic conception of the application is good// jsonObject is not NULL");

            try {
                JSONArray array = jsonObject.getJSONArray("table");

                for (int i = 0; i < array.length(); i++) {

                    JSONObject jo = array.getJSONObject(i);
                    Contact contact = new Contact(jo.getString("name_user"), Integer.parseInt(jo.getString("tel")), R.drawable.avatar, jo.getString("pseudo"), jo.getString("actu_profil"));

                    lsContact.add(contact);

                }


            } catch (JSONException e) {

                Log.e("JSON PASSING", "error at level of the reception resultSearchContact // failed ARRAY", e);

            }
        }
    }

}
