package ru.vvv.course;

import ru.vvv.notepad.NotePad;

public class Hello {
    public static void main(String[] args) {
        Task2.run();
        System.out.println();

        Task3.run(4,6,0.1);
        System.out.println();

        Task4.run(10);
        System.out.println();

        Task5.run(9);
        System.out.println();

        NotePad note = new NotePad();
        note.addRecord("aaaaa",0);
        note.addRecord("bbbbbb",1);
        note.addRecord("ccc",2);
        note.addRecord("in The Middle",1);
        note.listRecords();

        note.removeRecord(2);
        note.removeRecord(5);
        note.listRecords();
    }
}
