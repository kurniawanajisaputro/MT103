package com.danamon.project.connection;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
public class Constants {
    public static final int TIMEOUT = 5;
    public static final int TIMEOUT_DELAY = 3;
    public static final String GLOB_PARAM_DELAY = "y";
    public static final String CHROME = "Chrome";
    public static final String FIREFOX = "Firefox";
    public static final String EDGE = "Edge";
    public static final String OPERA = "Opera";
    public static final String IE = "IE";
    public static final String SAFARI = "Safari";

    public class UserData {
        private static String username;

        public static void setUsername(String user) {
            username = user;
        }

        public static String getUsername() {
            return username;
        }
    }
    public static final String URL_LOGIN = "https://192.168.220.42:8443/AppCM/";
}
