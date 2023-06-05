/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author nikolavn1
 */
public class Data{

    private static String logemail;
    private static String logpass;

    public Data(String logemail, String logpass) {
        this.logemail = logemail;
        this.logpass = logpass;
    }

    public static String getLogemail() {
        return logemail;
    }

    public static String getLogpass() {
        return logpass;
    }

    public static void setLogemail(String logemail) {
        Data.logemail = logemail;
    }

    public static void setLogpass(String logpass) {
        Data.logpass = logpass;
    }

    public Data() {
        this("", "");
    }

    @Override
    public String toString() {
        return "data{" + "logemail=" + logemail + ", logpass=" + logpass + '}';
    }
}
