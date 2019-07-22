package com.example.fofe.wiatalk.users;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class user {
    @DatabaseField( generatedId = true)
    private  int    idUser;
    @DatabaseField
    private  String name;
    @DatabaseField
    private  String email;
    @DatabaseField
    private  String pseudo;
    @DatabaseField
    private  String pwd;
    @DatabaseField
    private  int photoProfil;
    @DatabaseField
    private  String actuProfil;
    @DatabaseField
    private  String Tel;

    public user() {
    }

    public user(String name, String email, String pseudo, String pwd, int photoProfil, String actuProfil, String tel) {
        this.name = name;
        this.email = email;
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.photoProfil = photoProfil;
        this.actuProfil = actuProfil;
        Tel = tel;
    }




    public String getActuProfil() {
        return actuProfil;
    }

    public void setActuProfil(String actuProfil) {
        this.actuProfil = actuProfil;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(int photoProfil) {
        this.photoProfil = photoProfil;
    }




    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
