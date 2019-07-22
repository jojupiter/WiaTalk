package com.example.fofe.wiatalk.Call;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fofe.wiatalk.Contacts.Contact;
import com.example.fofe.wiatalk.PageAdapter.RecyclerViewAdapterCall;
import com.example.fofe.wiatalk.R;

import java.util.ArrayList;
import java.util.List;


public class callFragment extends Fragment {

    private View v;
    private RecyclerView myrecyclerView;
    private List<Contact> lsContact;


    public callFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_call, container, false);
        myrecyclerView= (RecyclerView)v.findViewById(R.id.callRecycler);
        RecyclerViewAdapterCall recyclerViewAdapterCall= new RecyclerViewAdapterCall(getContext(),lsContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapterCall);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lsContact= new ArrayList<>();
        lsContact.add(new Contact("azee zzeae",56,R.drawable.profil,"sfdfdfdf","dsdsdsdd"));
        lsContact.add(new Contact("azee zzeae",66,R.drawable.profil,"sfdfdfdf","dsdsdsdd"));

    }
}
