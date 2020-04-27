package ru.vvv.students;

public class NumberScore implements SubjectScore {
    private int value;
    public NumberScore(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
