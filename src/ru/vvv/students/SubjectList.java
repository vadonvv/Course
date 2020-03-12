package ru.vvv.students;

import java.util.HashMap;

public class SubjectList {
    private HashMap<String,Boolean> subjects;

    public SubjectList() {
        this.subjects = new HashMap();
    }

    public void addSubject(String name){
        subjects.put(name,false);
    }

    public void addSubject(String name, boolean isFloatmarks){
        subjects.put(name,isFloatmarks);
    }

    public int getSubjectCount(){
        return subjects.size();
    }

    public boolean getIsFloatMarks(String name){
        return subjects.get(name);
    }

    public void removeSubject(String name){
        subjects.remove(name);
    }
}
