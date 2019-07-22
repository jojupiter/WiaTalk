package com.example.fofe.wiatalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.fofe.wiatalk.Call.callFragment;
import com.example.fofe.wiatalk.Chats.chatFragment;
import com.example.fofe.wiatalk.Contacts.CreateContact;
import com.example.fofe.wiatalk.Contacts.contactFragment;
import com.example.fofe.wiatalk.PageAdapter.ViewPageAdapter;

public class epicenterActivity extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager viewPager;
private ViewPageAdapter adapter;
private FloatingActionButton fab;
private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epicenter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fab = (FloatingActionButton) findViewById(R.id.fab);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(epicenterActivity.this, CreateContact.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        tabLayout= (TabLayout)findViewById(R.id.tabs);
        viewPager= (ViewPager)findViewById(R.id.viewPager);
        adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new chatFragment(),"Chats");
        adapter.addFragment(new callFragment(),"Call");
        adapter.addFragment(new contactFragment(),"Contact");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);






        /*
        tabLayout.addTab(tabLayout.newTab().setText("CHATS"));
        tabLayout.addTab(tabLayout.newTab().setText("CALLS"));
        tabLayout.addTab(tabLayout.newTab().setText("CONTACTS"));
        */

       // showRightFab(viewPager.getCurrentItem());



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                showRightFab(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageScrollStateChanged(int state) {}
        });


        showRightFab(viewPager.getCurrentItem());

    }









    private void showRightFab(int position) {
        switch (position) {
            case 0:
                fab.show();
                fab2.hide();
                fab3.hide();
                break;
            case 1:
                 fab.hide();
                fab2.show();
                fab3.hide();
                break;

            default:
                fab.hide();
                fab2.hide();
                fab3.show();
                break;
        }
    }




}
