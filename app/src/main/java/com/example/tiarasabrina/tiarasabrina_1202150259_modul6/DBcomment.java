package com.example.tiarasabrina.tiarasabrina_1202150259_modul6;

/**
 * Created by ASUS on 4/1/2018.
 */
import com.google.firebase.database.IgnoreExtraProperties;

//Enkapsulasi data comment
@IgnoreExtraProperties
public class DBcomment {
    String yangkomen, komennya, fotoyangdikomen; //membuat variable

    //Dibutuhkan kosong untuk membaca data
    public DBcomment(){

    }

    //Constructor dari class ini
    public DBcomment(String yangkomen, String komennya, String fotoyangdikomen) {
        this.yangkomen = yangkomen;
        this.komennya = komennya;
        this.fotoyangdikomen = fotoyangdikomen;
    }

    //getter untuk variabel dari class ini
    public String getFotoyangdikomen() {
        return fotoyangdikomen;
    }
    //getter untuk variabel dari class ini
    public String getYangkomen() {
        return yangkomen;
    }
    //getter untuk variabel dari class ini
    public String getKomennya() {
        return komennya;
    }

}
