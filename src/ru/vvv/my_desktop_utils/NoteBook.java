package ru.vvv.my_desktop_utils;

public class NoteBook extends DesktopItem {
    private boolean hardCover;
    private int pages;
    /**
     * Конструктор - создание нового блокнота.
     *
     * @param cost - стоимость блокнота
     * @param hardCover - твердая или магкая обложка
     * @param pages - количество страниц
     */
    public NoteBook(int cost, boolean hardCover, int pages) {
        super("NoteBook", cost);
        this.hardCover = hardCover;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        NoteBook note = (NoteBook) obj;
        return note.hardCover == this.hardCover && note.pages == this.pages;
    }

    @Override
    public NoteBook clone() {
        NoteBook clone = (NoteBook) super.clone();
        clone.hardCover = this.hardCover;
        clone.pages = this.pages;
        return clone;
    }

    @Override
    public String toString() {
        return this.getName() + " [cost=" + this.getCost() + ", hardCover=" + hardCover + ", pages=" + pages
                + "]";
    }
}

