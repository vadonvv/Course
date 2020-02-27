package ru.vvv.my_desktop_utils;

public class Worker {
    public static void main(String[] args) {
        Desktop desk = new Desktop("Petrov");
        desk.addItem(new Pen(10,1));
        desk.addItem(new NoteBook(25,true,50));
        desk.addItem(new Pen(15,5));
        System.out.println(desk.toString());

        //Набор новичка
        Desktop newEmplDesk = new Desktop("Набор новичка");
        newEmplDesk.addItem(new NoteBook(20,false,50));
        newEmplDesk.addItem(new Pen(10,2));
        newEmplDesk.addItem(new Pencil(10,3));

        //Назначение набора новичку
        Desktop idesk = newEmplDesk.clone();
        idesk.setEmployeeName("Ivanov");
        Desktop sdesk = newEmplDesk.clone();
        sdesk.setEmployeeName("Sidorov");
        sdesk.addItem(new Pen(100,10));
        // Сидорову добавили ручку, а у Иванова с того же шаблона она не появилась.
        System.out.println(idesk.toString());
    }
}
