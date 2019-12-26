package ru.vvv.notepad;

/**
 * <p>Блокнот. Позволяет добавлять, удалять и выводить список записей</p>
 *
 * @version 1.0
 * @autor Вадим Волков
 */

public class NotePad {
    /**
     * Размер листа - величина блокнота по умолчанию. при нехватке расширяется листами
     */
    static int listSize = 10;

    /**
     * Массив записей блокнота
     */
    Record[] recordList;

    /**
     * Количество заполненных записей в блокноте
     */
    int recordCount;

    /**
     * Текущая величина блокнота(под которые выделена память)
     */
    int maxSize;

    /**
     * Конструктор - создание нового блокнота.
     *
     * @see NotePad#NotePad(int)
     */
    public NotePad() {
        this.recordList = new Record[listSize];
        maxSize = listSize;
        recordCount = 0;
    }

    /**
     * Конструктор - создание нового блокнота.
     *
     * @param size - стартовый размер блокнота - позволяет заранее выделить необходимый размер памяти
     */
    public NotePad(int size) {
        this.recordList = new Record[size];
        maxSize = size;
        recordCount = 0;
    }

    /**
     * Метод добавления записей в блокнот в заданную позицию
     *
     * @param text - текст записи
     * @param pos  - положение для вставки записи(отсчет с 0)
     */
    public void addRecord(String text, int pos) {
        if (recordCount == maxSize) {
            this.extendArray();
        }
        if (pos > recordCount) {
            pos = recordCount;
        }
        for (int i = recordCount; i > pos; i--) {
            recordList[i] = recordList[i - 1];
        }
        recordList[pos] = new Record(text);
        recordCount++;
    }

    private void extendArray() {
        Record[] tmpList = new Record[maxSize + listSize];
        for (int i = 0; i < maxSize; i++) {
            tmpList[i] = recordList[i];
        }
        this.recordList = tmpList;
        maxSize += listSize;
    }

    /**
     * Метод удаления записи из заданной позиции блокнота
     *
     * @param pos - позиция записи для удаления
     */
    public void removeRecord(int pos) {
        if (pos > recordCount) {
            return;
        }
        for (int i = pos; i < recordCount - 1; i++) {
            recordList[i] = recordList[i + 1];
        }
        recordCount--;
    }

    /**
     * Метод вывода текущих записей блокнота в консоль
     */
    public void listRecords() {
        System.out.println();
        if (recordCount > 0) {
            System.out.println("Notepad Records list:");
            for (int i = 0; i < recordCount; i++) {
                System.out.println("Record # " + i + "  is: " + recordList[i].getText());
            }
        } else {
            System.out.println("Notepad is empty");
        }
    }
}
