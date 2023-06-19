/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.logging.Logger;

/**
 *
 * @author momchil.hristov
 */
public class Code {
    private static int code;

    public Code(int code) {
        this.code = code;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        Code.code = code;
    }
    public Code() {
        this(0);
    }
    
}
