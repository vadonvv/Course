package ru.vvv.students;

public class BoolScore implements SubjectScore {
    private boolean value;

    public BoolScore(boolean value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value ? "зачет!" : "незачет";
    }
}
