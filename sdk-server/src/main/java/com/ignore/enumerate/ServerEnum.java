package com.ignore.enumerate;

public enum ServerEnum {
    MAIL_SERVER("mail-server" , "7004"),
    COMMON_SERVER("common-server" , "7006");


    private String name;
    private String port;

    private ServerEnum(String name , String port) {
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }
}
