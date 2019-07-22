package com.example.fofe.wiatalk.connexion;

import android.util.Log;

import com.example.fofe.wiatalk.constants.constants;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class connexion {

    /////////////////////////////// server /////////////////////////////////////////////


    public static Socket ConnectToServer(Socket socket){
        try {
            socket = IO.socket(constants.getUri());
            socket.connect();
            return socket;

        } catch (URISyntaxException e) {
            Log.e("CONNECTION","can't connected to server",e);
return null;
        }
    }


    ////////////////////////////// database /////////////////////////////////////////////
}
