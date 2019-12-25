package ru.vvv.course;

import java.lang.Math;

public class Task3 {
    public static void run(double a, double b, double h){
        double xPos = a;
        double value = 0;

        while(xPos<=b){
            value = Math.tan(2*xPos)-3;
            System.out.println(xPos + ": " + value);

            xPos += h;
        }
    }
}
