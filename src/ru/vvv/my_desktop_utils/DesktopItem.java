package ru.vvv.my_desktop_utils;

public class DesktopItem implements Cloneable{
    private int cost;
    private String name;

    public DesktopItem(String name, int cost) {
        this.cost = cost;
        this.name = name;
    }
    @Override
    public DesktopItem clone() {
        try {
            DesktopItem clone = (DesktopItem) super.clone();
            clone.cost = this.cost;
            clone.name = this.name;
            return clone;
        } catch (CloneNotSupportedException e) {
            return new DesktopItem("Some Error",0);
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DesktopItem [name=" + name + ", cost=" + cost
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DesktopItem item = (DesktopItem) obj;
        return item.cost == this.cost && item.name == this.name;
    }
}
