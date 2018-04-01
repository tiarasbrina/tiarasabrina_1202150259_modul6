package com.example.tiarasabrina.tiarasabrina_1202150259_modul6;

/**
 * Created by ASUS on 4/1/2018.
 */

import com.google.firebase.database.IgnoreExtraProperties;

//Enkapsulasi data post
@IgnoreExtraProperties
public class DBPost {
    public String image, title, caption, user, key; //membuat variable

    //Dibutuhkan kosong untuk membaca data
    public DBPost() {
    }

    //Constructor dari class ini
    public DBPost(String caption, String image, String title, String user) {
        this.image = image;
        this.title = title;
        this.caption = caption;
        this.user = user;
    }

    //Mendapatkan key dari Firebase
    public String getKey() {
        return key;
    }

    //Menentukan key dari Firebase
    public void setKey(String key) {
        this.key = key;
    }

    //getter variabel dari class ini
    public String getImage() {
        return image;
    }
    //getter variabel dari class ini
    public String getTitle() {
        return title;
    }
    //getter variabel dari class ini
    public String getCaption() {
        return caption;
    }
    //getter variabel dari class ini
    public String getUser() {
        return user;
    }

}
