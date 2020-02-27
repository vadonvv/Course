package ru.vvv.my_desktop_utils;

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

    /**
     * Количество канцелярии на столе
     */
    private int recordCount;

    /**
     * Текущая величина массива(под который выделена память)
     */
    private int maxSize;

    public Desktop(String emp) {
        employeeName = emp;
        maxSize = listSize;
        recordCount = 0;
        this.items = new DesktopItem[maxSize];
    }

    @Override
    public Desktop clone() {
        try {
            Desktop clone = (Desktop) super.clone();
            clone.maxSize = this.maxSize;
            clone.recordCount = this.recordCount;
            clone.items = new DesktopItem[maxSize];
            clone.employeeName = this.employeeName;
            for (int i = 0; i < recordCount; i++) {
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
        if (recordCount == maxSize) {
            this.extendArray();
        }
        items[recordCount] = item;
        recordCount++;
    }

    private void extendArray() {
        DesktopItem[] tmpList = new DesktopItem[maxSize + listSize];
        for (int i = 0; i < maxSize; i++) {
            tmpList[i] = items[i];
        }
        this.items = tmpList;
        maxSize += listSize;
    }

    public void removeItem(DesktopItem item) {
        int deleteItem = recordCount;
        for (int i = 0; i < recordCount; i++) {
            if(items[i].equals(item)){
                deleteItem = i;
                break;
            }
        }
        for (int i = deleteItem; i < recordCount-1; i++) {
            items[i] = items[i+1];
        }
        recordCount--;
    }
    @Override
    public String toString(){
        String out = "Desktop items of employee " + employeeName + ":\n";
        for (int i = 0; i < recordCount; i++) {
            out += items[i].toString();
        }
        out += "Полная стоимость канцтоваров: " + calcDeskCost();
        return out;
    }

    public int calcDeskCost(){
        int sum = 0;
        for (int i = 0; i < recordCount; i++) {
            sum += items[i].getCost();
        }
        return sum;
    }

    public void sort(){

    }
}
