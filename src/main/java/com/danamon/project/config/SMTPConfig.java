package com.danamon.project.config;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
public class SMTPConfig {private static String emailUserName;
    private static String emailPassword;
    private static String emailHost;
    private static String emailPort;
    private static String emailPortSSL;
    private static String emailPortTLS;
    private static String emailAuth;
    private static String emailStartTLSEnable;
    private static String emailSMTPSocketFactoryClass;
    private static String emailSMTPTimeout;


    public SMTPConfig(String xEmailUserName,
                      String xEmailPassword,
                      String xEmailHost,
                      String xEmailPort,
                      String xEmailPortSSL,
                      String xEmailPortTLS,
                      String xEmailAuth,
                      String xEmailStartTLSEnable,
                      String xEmailSMTPSocketFactoryClass,
                      String xEmailSMTPTimeout) {
        emailUserName = xEmailUserName;
        emailPassword = xEmailPassword;
        emailHost = xEmailHost;
        emailPort = xEmailPort;
        emailPortSSL = xEmailPortSSL;
        emailPortTLS = xEmailPortTLS;
        emailAuth = xEmailAuth;
        emailStartTLSEnable = xEmailStartTLSEnable;
        emailSMTPSocketFactoryClass = xEmailSMTPSocketFactoryClass;
        emailSMTPTimeout = xEmailSMTPTimeout;
    }

    public static String getEmailUserName() {
        return emailUserName;
    }

    public static String getEmailPassword() {
        return emailPassword;
    }

    public static String getEmailHost() {
        return emailHost;
    }

    public static String getEmailPort() {
        return emailPort;
    }

    public static String getEmailPortSSL() {
        return emailPortSSL;
    }

    public static String getEmailPortTLS() {
        return emailPortTLS;
    }

    public static String getEmailAuth() {
        return emailAuth;
    }

    public static String getEmailStartTLSEnable() {
        return emailStartTLSEnable;
    }

    public static String getEmailSMTPSocketFactoryClass() {
        return emailSMTPSocketFactoryClass;
    }

    public static String getEmailSMTPTimeout() {
        return emailSMTPTimeout;
    }
}
