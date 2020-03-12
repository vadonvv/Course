package ru.vvv.students;

public class Student {
    private static long nextId = 0L;

    private final long id;
    private  String name;

    public Student(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
