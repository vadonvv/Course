package ru.vvv.Logger;
/*
/ Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как накопитель
объект типа StringBuilder. Логгер должен содержать методы поиска определенной информации
в таком логе [с возможностью вывода ее в поток ввода вывода]. Информацию логгер хранит в
форматированном виде: dd-mm-YYYY : hh-mm – message;.*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrazyLogger {
    private StringBuilder sb = new StringBuilder();

    public void log(String logItem){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        sb.append(dateFormat.format(date)).append(" - ").append(logItem).append("\n");
    }

    public void printLog(){
        System.out.println(sb.toString());
    }

    public String findMatches(String str){
        StringBuilder result = new StringBuilder();
        String[] strs = sb.toString().split("\n");
        for (String curr:strs) {
            if(curr.contains(str)){
                result.append(curr);
            }
        }
        return result.toString();
    }
}
