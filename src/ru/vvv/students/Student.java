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
        if(!groups.contains(gr)) {
            this.groups.add(gr);
            gr.addStudent(this);
        }
    }

    public void leaveGroup(StudentGroup gr){
        if(this.groups.remove(gr)){
            gr.removeStudent(this);
        }
    }

    public void listGroups(){
        String score;
        StringBuilder result = new StringBuilder();
        result.append("Предменты, изучаемые студентом ");
        result.append(this.getName());
        result.append(":\n");
        for (StudentGroup k:groups) {
            result.append("\t").append(k.getName()).append("; Оценки: ");
            result.append(k.printStudentScore(this));
            result.append("\n");
        }
        System.out.println(result);
    }
}
