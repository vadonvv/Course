package ru.vvv.Logger;

public class Main {
    public static void main(String[] args){
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.log("sdfsfsfsdf");
        crazyLogger.log("test2");
        crazyLogger.printLog();
        crazyLogger.findMatches("es");
    }
}
