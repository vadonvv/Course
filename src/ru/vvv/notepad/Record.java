package ru.vvv.notepad;

class Record {
    private String text;

    Record(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}
