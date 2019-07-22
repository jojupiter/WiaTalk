package com.example.fofe.wiatalk.Contacts;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Contact {
    @DatabaseField(generatedId = true)
    private int idContact;
    @DatabaseField
private String NameContact;
    @DatabaseField
private int  Tel;
    @DatabaseField
private int PhotoProfil;
    @DatabaseField
private String Pseudo;
    @DatabaseField
private String actuProfil;

    public Contact() {
    }

    public Contact(String nameContact, int tel, int photoProfil, String pseudo, String actuProfil) {
        NameContact = nameContact;
        Tel = tel;
        PhotoProfil = photoProfil;
        Pseudo = pseudo;
        this.actuProfil = actuProfil;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getNameContact() {
        return NameContact;
    }

    public void setNameContact(String nameContact) {
        NameContact = nameContact;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int tel) {
        Tel = tel;
    }

    public int getPhotoProfil() {
        return PhotoProfil;
    }

    public void setPhotoProfil(int photoProfil) {
        PhotoProfil = photoProfil;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public String getActuProfil() {
        return actuProfil;
    }

    public void setActuProfil(String actuProfil) {
        this.actuProfil = actuProfil;
    }
}
