package ru.vvv.my_desktop_utils;

import java.util.Arrays;
import static ru.vvv.my_desktop_utils.DesktopItemComparator.*;

public class Desktop implements Cloneable{
    private String employeeName;
    /**
     * Массив канцелярии на рабочем столе
     */
    private DesktopItem[] items;

    /**
     * Размер массива для учета канцелярии
     */
    private static int listSize = 100;

    public Desktop(String emp) {
        employeeName = emp;
        this.items = new DesktopItem[listSize];

    }

    @Override
    public Desktop clone() {
        try {
            Desktop clone = (Desktop) super.clone();
            clone.items = new DesktopItem[this.items.length];
            clone.employeeName = this.employeeName;
            for (int i = 0; i<items.length && items[i] != null; i++) {
                clone.items[i] = this.items[i].clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void addItem(DesktopItem item) {
        for (int i = 0; i<items.length; i++){
            if(items[i] == null) {
                items[i] = item;
                return;
            }
        }
        int index = this.items.length;
        this.extendArray();
        items[index] = item;
    }

    private void extendArray() {
        this.items = Arrays.copyOf(this.items,this.items.length + listSize);
    }

    public void removeItem(DesktopItem item) {
        for (int i = 0; i<items.length && items[i] != null; i++) {
            if(items[i].equals(item)){
                shiftItemsFromIndex(i);
                break;
            }
        }
    }

    private void shiftItemsFromIndex(int index){
        for (int i = index; i<items.length-1 && items[i] != null; i++) {
            items[i] = items[i+1];
        }
    }
    @Override
    public String toString(){
        StringBuilder out = new StringBuilder("Desktop items of employee " + employeeName + ":\n");
        for (int i = 0; i<items.length && items[i] != null; i++) {
            out.append(items[i].toString()).append("\n");
        }
        out.append("Полная стоимость канцтоваров: ").append(calcDeskCost()).append("\n");
        return out.toString();
    }

    public int calcDeskCost(){
        int sum = 0;
        for (int i = 0; i<items.length && items[i] != null; i++) {
            sum += items[i].getCost();
        }
        return sum;
    }

    public void sort(final DesktopItemComparator... multipleOptions){
        Arrays.sort(items,getComparator(multipleOptions));
    }
}
