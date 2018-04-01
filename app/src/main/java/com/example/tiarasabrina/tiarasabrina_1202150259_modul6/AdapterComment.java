package com.example.tiarasabrina.tiarasabrina_1202150259_modul6;

/**
 * Created by ASUS on 4/1/2018.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterComment extends  RecyclerView.Adapter<AdapterComment.CommentHolder>{

    Context con; //membuat variable dr context
    List<DBcomment> list; //membuat variable dr list<DBcomment>

    //konstruktor
    public AdapterComment(Context con, List<DBcomment> list) {
        this.con = con;
        this.list = list;
    }

    //Return ViewHolder dari Recyclerview
    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentHolder(LayoutInflater.from(con).inflate(R.layout.rec_comment, parent, false));
    }

    //Mengikat nilai dari list dengan view
    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        DBcomment cur = list.get(position); //mendapatkan posisi
        holder.yangkomen.setText(cur.getYangkomen()); //melakukann settxt pd holder
        holder.komennya.setText(cur.getKomennya()); //melakukann settxt pd holder
    }

    //Mendapatkan jumlah item pada recyclerview
    @Override
    public int getItemCount() {
        return list.size();
    }

    //Subclass sebagai viewholder
    class CommentHolder extends RecyclerView.ViewHolder{
        TextView yangkomen, komennya; //membuat variable
        public CommentHolder(View itemView) {
            super(itemView);
            //menemukan id view
            yangkomen = itemView.findViewById(R.id.yangkomen);
            komennya = itemView.findViewById(R.id.komennya);
        }
    }
}
