package ru.vvv.myDesktopUtils;


public class Pen extends DesktopItem {
    private int thickness;

    public Pen() {
        super("Pen",10);
        this.thickness = 1;
    }
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
    public String toString() {
        return "Pen [cost=" + cost + ", thickness=" + thickness
                + "]";
    }
}
