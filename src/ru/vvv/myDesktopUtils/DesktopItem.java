package ru.vvv.myDesktopUtils;

public class DesktopItem {
    int cost;
    String name;

    public DesktopItem(String name, int cost) {
        this.cost = cost;
        this.name = name;
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
