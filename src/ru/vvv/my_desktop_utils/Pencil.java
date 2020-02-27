package ru.vvv.my_desktop_utils;

public class Pencil extends DesktopItem {
    private int thickness;

    public Pencil(int cost, int thickness) {
        super("Pencil", cost);
        this.thickness = thickness;
    }

    @Override
    public Pencil clone() {
        Pencil clone = (Pencil) super.clone();
        clone.thickness = this.thickness;
        return clone;
    }

    @Override
    public String toString() {
        return this.getName() + " [cost=" + this.getCost() + ", thickness=" + thickness
                + "]";
    }
}
