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

    private String logemail;
    private String logpass;

    public Data(String logemail, String logpass) {
        this.logemail = logemail;
        this.logpass = logpass;
    }

    public String getLogemail() {
        return logemail;
    }

    public String getLogpass() {
        return logpass;
    }

    public void setLogemail(String logemail) {
        this.logemail = logemail;
    }

    public void setLogpass(String logpass) {
        this.logpass = logpass;
    }

    public Data() {
        this("", "");
    }

    @Override
    public String toString() {
        return "data{" + "logemail=" + logemail + ", logpass=" + logpass + '}';
    }
}
