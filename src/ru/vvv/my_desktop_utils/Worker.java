package ru.vvv.my_desktop_utils;
import static ru.vvv.my_desktop_utils.DesktopItemComparator.*;

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

        //сортировка Иванова
        idesk.addItem(new Pen(150,13));
        idesk.addItem(new NoteBook(150, false,10));
        idesk.addItem(new Pen(48,20));
        idesk.addItem(new Pencil(11,10));
        idesk.addItem(new NoteBook(10, true,10));

        idesk.sort(COST_SORT);
        System.out.println(idesk.toString());

        idesk.sort(NAME_SORT);
        System.out.println(idesk.toString());

        idesk.sort(COST_SORT,NAME_SORT);
        System.out.println(idesk.toString());
    }
}
