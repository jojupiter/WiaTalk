package com.example.fofe.wiatalk.Sms;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Sms {
    @DatabaseField(generatedId = true)
    private  int   id_sms;
    @DatabaseField
    private String time_sent;
    @DatabaseField
    private String time_receive="inconnu ";
    @DatabaseField
    private String emetter;
    @DatabaseField
    private String receiver="0";
    @DatabaseField
    private String TextMsg;
    @DatabaseField
    private String Discussion;

// discussion is the name of the contact. Why i put this attribut ? because i want

    public Sms() {
    }

    public Sms(String time_sent, String time_receive, String emetter, String receiver, String textMsg,String discussion) {
        this.time_sent = time_sent;
        this.time_receive = time_receive;
        this.emetter = emetter;
        this.receiver = receiver;
        TextMsg = textMsg;
        Discussion=discussion;
    }

    public String getTime_sent() {
        return time_sent;
    }

    public void setTime_sent(String time_sent) {
        this.time_sent = time_sent;
    }

    public String getTime_receive() {
        return time_receive;
    }

    public void setTime_receive(String time_receive) {
        this.time_receive = time_receive;
    }

    public String getEmetter() {
        return emetter;
    }

    public void setEmetter(String emetter) {
        this.emetter = emetter;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        receiver = receiver;
    }

    public String getTextMsg() {
        return TextMsg;
    }

    public void setTextMsg(String textMsg) {
        TextMsg = textMsg;
    }


    public String getDiscussion() {
        return Discussion;
    }

    public void setDiscussion(String discussion) {
        Discussion = discussion;
    }
}
