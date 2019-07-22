package com.example.fofe.wiatalk.constants;

public class constants {
    private static String uri = "http://172.16.1.197:3000";

    private static boolean connect =false;
    public static String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    public static boolean isConnect() {
        return connect;
    }

    public static void setConnect(boolean connect) {
        constants.connect = connect;
    }
}
