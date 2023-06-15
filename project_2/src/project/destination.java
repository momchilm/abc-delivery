/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.logging.Logger;

/**
 *
 * @author nikolavn1
 */
public class destination {
    public static String destination;
    //private static final Logger LOG = Logger.getLogger(destination.class.getName());

    public static String getDestination() {
        return destination;
    }

    public static void  setDestination(String destination) {
        destination = destination;
    }

    public destination(String destination) {
        this.destination = destination;
    }
    
    public destination() {
        this("");
    }
}
