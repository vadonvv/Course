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
            return new Desktop("Some Error");
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void addItem(DesktopItem item) {
        boolean flag = false;
        for (int i = 0; i<items.length; i++){
            if(items[i] == null) {
                items[i] = item;
                flag = true;
                break;
            }
        }
        if (!flag){ //Array full
            int index = this.items.length;
            this.extendArray();
            items[index] = item;
        }
    }

    private void extendArray() {
        this.items = Arrays.copyOf(this.items,this.items.length + listSize);
    }

    public void removeItem(DesktopItem item) {
        int deleteItemIndex;
        deleteItemIndex = items.length; //Чтобы не удалить первый элемент если в массиве не найдется переданного

        for (int i = 0; i<items.length && items[i] != null; i++) {
            if(items[i].equals(item)){
                deleteItemIndex = i;
                break;
            }
        }

        for (int i = deleteItemIndex; i<items.length-1 && items[i] != null; i++) {
            items[i] = items[i+1];
        }
    }
    @Override
    public String toString(){
        String out = "Desktop items of employee " + employeeName + ":\n";
        for (int i = 0; i<items.length && items[i] != null; i++) {
            out += items[i].toString() + "\n";
        }
        out += "Полная стоимость канцтоваров: " + calcDeskCost() + "\n";
        return out;
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
