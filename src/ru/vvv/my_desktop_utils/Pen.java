package ru.vvv.my_desktop_utils;


public class Pen extends DesktopItem {
    private int thickness;

    /**
     * Конструктор - создание новой ручки.
     *
     * @param cost - стоимость ручки
     * @param thickness - толщина линии ручки
     */
    public Pen(int cost, int thickness) {
        super("Pen",cost);
        this.thickness = thickness;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)){
            return false;
        }
        Pen pen = (Pen) o;
        return pen.thickness == this.thickness;
    }

    @Override
    public Pen clone() {
        Pen clone = (Pen) super.clone();
        clone.thickness = this.thickness;
        return clone;
    }

    @Override
    public String toString() {
        return this.getName() + " [cost=" + this.getCost() + ", thickness=" + thickness
                + "]";
    }
}
