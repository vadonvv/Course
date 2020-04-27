package ru.vvv.Logger;
/*
/ Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как накопитель
объект типа StringBuilder. Логгер должен содержать методы поиска определенной информации
в таком логе [с возможностью вывода ее в поток ввода вывода]. Информацию логгер хранит в
форматированном виде: dd-mm-YYYY : hh-mm – message;.*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class CrazyLogger {
    private StringBuilder sb = new StringBuilder();

    public void log(String logItem){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        sb.append(dateFormat.format(date) + " - " + logItem + "\n");
    }

    public void printLog(){
        System.out.println(sb.toString());
    }

    public void findMatches(String str){
        String[] strs = sb.toString().split("\n");
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].contains(str)){
                System.out.println(strs[i]);
            }
        }
    }
}
