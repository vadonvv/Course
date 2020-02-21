package ru.vvv.myDesktopUtils;

public class Worker {
    public static void main(String[] args) {
        Desktop desk = new Desktop("Petrov");
        desk.addItem(new Pen(10,1));
        desk.addItem(new NoteBook(20,true,50));
        desk.addItem(new Pen(15,5));
        desk.printDesk();

        System.out.println("Еще раз отдельно полная стоимость товаров: " + desk.calcDeskCost());
    }
}
