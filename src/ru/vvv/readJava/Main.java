package ru.vvv.readJava;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args){
        JavaReader reader = new JavaReader();
        reader.loadFile("code.txt");
        reader.printKeyWords();
    }
}
