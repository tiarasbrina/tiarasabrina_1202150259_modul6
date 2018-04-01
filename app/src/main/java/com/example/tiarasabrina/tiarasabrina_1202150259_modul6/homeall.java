package com.example.tiarasabrina.tiarasabrina_1202150259_modul6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class homeall extends Fragment {
    RecyclerView rc; //membuat variable dr Recycleview
    DatabaseReference dataref; //membuat variable
    ArrayList<DBPost> list; //membuat variable
    AdapterPost adapterPost; //membuat variable

    public homeall() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inisialisasi semua objek
        View v = inflater.inflate(R.layout.f_homeall, container, false);//menyetting inflater
        rc = v.findViewById(R.id.rchomeall); //menemukan id
        list = new ArrayList<>(); //membuat array
        dataref = FirebaseDatabase.getInstance().getReference().child("post"); //membuat database
        adapterPost = new AdapterPost(list, this.getContext()); //membuat adapter

        //Menampilkan recyclerview
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new GridLayoutManager(getContext(),2));
        rc.setAdapter(adapterPost);

        //Event listener ketika value pada Firebase berubah
        dataref.addValueEventListener(new ValueEventListener() {
            //Digunakan untuk membaca seluruh postingan dari firebase
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    DBPost post = data.getValue(DBPost.class);
                    post.key = data.getKey();
                    list.add(post);
                    adapterPost.notifyDataSetChanged();
                }
            }
            //on cancelled
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;
    }

}
