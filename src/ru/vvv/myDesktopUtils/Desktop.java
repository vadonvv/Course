package ru.vvv.myDesktopUtils;

public class Desktop {
    String employeeName;
    /**
     * Массив канцелярии на рабочем столе
     */
    DesktopItem[] items;

    /**
     * Размер массива для учета канцелярии
     */
    static int listSize = 100;

    /**
     * Количество канцелярии на столе
     */
    int recordCount;

    /**
     * Текущая величина массива(под который выделена память)
     */
    int maxSize;

    public Desktop(String emp) {
        employeeName = emp;
        this.items = new DesktopItem[listSize];
        maxSize = listSize;
        recordCount = 0;
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
            }
            if(i >= deleteItem){
                if(i==recordCount-1){ //чтобы не выйти за границы массива при взятии i+1 записи
                    items[i] = null;
                }else{
                    items[i] = items[i+1];
                }
            }

        }
        recordCount--;
    }

    public void printDesk(){
        System.out.println("Desktop items of employee " + employeeName + ":");
        for (int i = 0; i < recordCount; i++) {
            System.out.println(items[i].toString());
        }
        System.out.println("Полная стоимость канцтоваров: " + calcDeskCost());
    }

    public int calcDeskCost(){
        int sum = 0;
        for (int i = 0; i < recordCount; i++) {
            sum += items[i].getCost();
        }
        return sum;
    }
}
