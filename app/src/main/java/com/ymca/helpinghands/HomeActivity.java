package com.ymca.helpinghands;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.ymca.helpinghands.ui.main.SectionsPagerAdapter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Setting Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //TABS
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //Floating Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feedback", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Thread timer=new Thread(){
                    public void run(){
                        try{
                            sleep(1200);
                        }catch (    InterruptedException e){
                            e.printStackTrace();
                        }finally{
                            String[] emails = new String[]{
                                    "sameepmago@gmail.com"
                            };
                            String mailSubject = "Feedback to Developer";
                            Intent intent = new Intent(Intent.ACTION_SENDTO);
                            intent.putExtra(Intent.EXTRA_EMAIL,emails);
                            intent.putExtra(Intent.EXTRA_SUBJECT,mailSubject);
                            intent.setData(Uri.parse("mailto:"));

                            // Try to start the activity
                            if (intent.resolveActivity(getPackageManager()) != null) {
                                startActivity(intent);
                            }else{
                                // If there are no email client installed in this device
                                Toast.makeText(HomeActivity.this,"No email client installed in this device.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                };
                timer.start();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent i;
        if(id==R.id.nav_orgdeaf){
            i=new Intent(HomeActivity.this,DeafOrganisationActivity.class);
            startActivity(i);
        }else{
            i=new Intent(HomeActivity.this,SignLanguageActivity.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}