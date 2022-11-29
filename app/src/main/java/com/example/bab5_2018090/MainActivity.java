package com.example.bab5_2018090;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class MainActivity extends AppCompatActivity {
    // tugas recycle view
    RecyclerView RecylerView;
    String s1[], s2[],s3[];
    int images[] =
            {R.drawable.helm1,R.drawable.helm2,R.drawable.helm3};
    private DrawerLayout dl;
    private ActionBarDrawerToggle abut;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// tugas recycle view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecylerView = findViewById(R.id.recyclerView);
        s1 =
                getResources().getStringArray(R.array.Helm);
        s2 =
                getResources().getStringArray(R.array.Deskripsi);
        s3 = getResources().getStringArray(R.array.Star);
        HelmAdapter appAdapter = new HelmAdapter(this, s1, s2, s3, images);
        RecylerView.setAdapter(appAdapter);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(MainActivity.this,LinearLayoutManager.
                HORIZONTAL,false);
        RecylerView.setLayoutManager(layoutManager);
        RecylerView.setItemAnimator(new
                DefaultItemAnimator());
        dl = (DrawerLayout) findViewById(R.id.dl);
        abut = new ActionBarDrawerToggle(this, dl,
                R.string.Open, R.string.Close);
        abut.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abut);
        abut.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView)
                findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new
                                                           NavigationView.OnNavigationItemSelectedListener() {
                                                               @Override
                                                               public boolean
                                                               onNavigationItemSelected(@NonNull MenuItem item) {
                                                                   int id = item.getItemId();
                                                                   if (id == R.id.nav_profile) {
                                                                       Intent a = new
                                                                               Intent(MainActivity.this, MainActivity.class);
                                                                       startActivity(a);
                                                                   } else if (id == R.id.nav_reviews) {
                                                                       Intent a = new
                                                                               Intent(MainActivity.this, ActivityMain2.class);
                                                                       startActivity(a);
                                                                   } else if (id == R.id.nav_settings) {
                                                                       Intent a = new
                                                                               Intent(MainActivity.this, ActivityMain2.class);
                                                                       startActivity(a);
                                                                   }
                                                                   return true;
                                                               }
                                                           });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem
                                                 item) {
        return abut.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }
}