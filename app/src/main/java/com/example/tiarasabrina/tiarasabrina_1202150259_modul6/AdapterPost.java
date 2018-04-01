package com.example.tiarasabrina.tiarasabrina_1202150259_modul6;

/**
 * Created by ASUS on 4/1/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterPost extends  RecyclerView.Adapter<AdapterPost.PostViewHolder>{

    private List<DBPost> list;  //membuat variable dari list
    private Context con; //membuat variable dr context

    //Constructor dari adapter
    public AdapterPost(List<DBPost> list, Context con) {
        this.list = list;
        this.con = con;
    }

    //Return ViewHolder untuk adapter
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(con).inflate(R.layout.rec_feed, parent, false));
    }

    //Mengikat nilai dari list dengan view
    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        DBPost current = list.get(position); //mendapatkan postion dari list
        String [] user = current.user.split("@"); //menyimpan array
        holder.user.setText(user[0]); //set text pd holder user
        holder.user.setTag(current.getKey()); //set tag pada pd holder user
        holder.title.setText(current.getTitle()); //set text tittle
        holder.caption.setText(current.getCaption()); //set text pd caption
        holder.caption.setTag(current.getImage()); //set text pd caption
        Glide.with(con).load(current.getImage()).placeholder(R.drawable.add_image).override(450, 450).into(holder.image);
    }

    //Mendapatkan jumlah item pada recyclerview
    @Override
    public int getItemCount() {
        return list.size();
    }

    //Subclass sebagai viewholder
    class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView image; TextView user, title, caption; //membuat variable
        public PostViewHolder(View itemView) {
            super(itemView);
            //menemukan id view dan menyimpan ke variable
            image = itemView.findViewById(R.id.postgambarnya);
            user = itemView.findViewById(R.id.postpengupload);
            title = itemView.findViewById(R.id.postjudul);
            caption = itemView.findViewById(R.id.postdeskripsi);

            //Operasi ketika item pada recyclerview diklik
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //membuat intent
                    Intent pindah = new Intent(con, post.class);
                    pindah.putExtra("user", user.getText());   //menambahkan put extra
                    pindah.putExtra("key", user.getTag().toString());   //menambahkan put extra
                    pindah.putExtra("title", title.getText());   //menambahkan put extra
                    pindah.putExtra("caption", caption.getText());   //menambahkan put extra
                    pindah.putExtra("image", caption.getTag().toString());   //menambahkan put extra
                    con.startActivity(pindah); // start intent
                }
            });
        }
    }
}
