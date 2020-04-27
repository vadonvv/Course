package ru.vvv.students;

public class Subject {
    private String name;
    private boolean scoretype;

    public String getName() {
        return name;
    }

    public Subject(String name, boolean scoretype) {
        this.name = name;
        this.scoretype = scoretype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isScoretype() {
        return scoretype;
    }

    public void setScoretype(boolean scoretype) {
        this.scoretype = scoretype;
    }
}
