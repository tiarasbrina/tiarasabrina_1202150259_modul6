package com.example.tiarasabrina.tiarasabrina_1202150259_modul6;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {
    ViewPager vp; //membuat variable dr ViewPager
    TabLayout tab; //membuat variable
    AppBarLayout abl; //membuat variable
    Toolbar tl;//membuat variable
    FirebaseAuth auth;//membuat variable
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_home);


        vp = findViewById(R.id.vp); //menemukan id dan menyimpan ke variable
        tab = findViewById(R.id.tabs);//menemukan id dan menyimpan ke variable
        abl = findViewById(R.id.appbar);//menemukan id dan menyimpan ke variable
        tl = findViewById(R.id.tb);//menemukan id dan menyimpan ke variable
        auth = FirebaseAuth.getInstance();

        //Menentukan toolbar
        setSupportActionBar(tl);
        setupPager(vp);

        //Mengikat tablayout dengan viewpager
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.drawable.ic_group);
        tab.getTabAt(1).setIcon(R.drawable.ic_person);
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    abl.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }else{
                    abl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //Method ketika membuat menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    //Method ketika menu logout dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menulogout) {
            auth.signOut();
            startActivity(new Intent(home.this, login.class)); //intent ke login
            finish();
        }
        return true;
    }


    //Menetapkan adapter untuk viewpager
    public void setupPager(ViewPager v){
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.addFragment(new homeall(), "TERBARU");
        adapter.addFragment(new homeuser(), "SAYA");

        v.setAdapter(adapter);
    }

    //Method ketika tombol tambah post diklik
    public void TambahPost(View view) {
        startActivity(new Intent(home.this, upload.class));
    }

    //Subclass sebagai adapter untuk Viewpager dengan fragmentnya
    class VPAdapter extends FragmentPagerAdapter{
        private final List<Fragment> listfragment = new ArrayList<>();
        private final List<String> listfragmenttitle = new ArrayList<>();
        public VPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listfragment.get(position);
        }

        public void addFragment(Fragment f, String title){
            listfragment.add(f);
            listfragmenttitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return listfragment.size();
        }
    }
}

