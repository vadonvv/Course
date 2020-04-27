package ru.vvv.students;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private  String name;
    private Set<StudentGroup> groups;

    public Student(String name) {
        this.name = name;
        groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addToGroup(StudentGroup gr){
        gr.addStudent(this);
        this.groups.add(gr);
    }

    public void leaveGroup(StudentGroup gr){
        if(this.groups.remove(gr)){
            gr.removeStudent(this);
        }
    }

    public void listGroups(){
        System.out.println("Предменты, изучаемые студентом " + this.getName() + ":");
        String score;
        for (StudentGroup k:groups) {
            if(k.getStudentscore(this)!=null){
                score = k.getStudentscore(this).toString();
            }else {
                score = "нет оценки";
            }
            System.out.println("    " + k.getSubject().getName() + "; score: " + score);
        }
    }
}
