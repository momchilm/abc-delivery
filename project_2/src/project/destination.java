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
public class Destination {
    private static String destination;

    public Destination(String destination) {
        this.destination = destination;
    }
    
    public static String getDestination() {
        return destination;
    }

    public static void  setDestination(String destination) {
        Destination.destination = destination;
    }

    
    
    public Destination() {
        this("");
    }
    
}
