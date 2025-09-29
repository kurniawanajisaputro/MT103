package main.java.com.danamon.project.config;

/*
IntelliJ IDEA 2025.1 (Community Edition)
Build #IC-251.23774.435, built on April 14, 2025
@Author T460 a.k.a. Kurniawan Adji Saputro
Software Quality Assurance
Created on 23/09/2025 12:04
@Last Modified 23/09/2025 12:04
Version1.0
*/
public class BaseConfig {
    /** ditulis ini minimal apa kek gitu */
    private static int timeout;
    private static int delay;
    private static String baseUrl;
    private static String browser;
    private static String delayParam;

    public BaseConfig(int xTimeout,int xDelay,String xBaseUrl,String xBrowser,String xDelayParam) {
        timeout = xTimeout;
        delay = xDelay;
        baseUrl = xBaseUrl;
        browser = xBrowser;
        delayParam = xDelayParam;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static int getDelay() {
        return delay;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getDelayParam() {
        return delayParam;
    }
}
