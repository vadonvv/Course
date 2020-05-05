package ru.vvv.students;

import java.util.*;

public class StudentGroup<T> {
private String name;
private Map<Student, List<T>> students;

    public StudentGroup(String subject) {
        name = subject;
        this.students = new HashMap();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student){
        if(!this.students.containsKey(student)){
            this.students.put(student,new ArrayList<T>());
            student.addToGroup(this);
        }

    }

    public void removeStudent(Student student){
        if(this.students.containsKey(student)) {
            this.students.remove(student);
            student.leaveGroup(this);
        }
    }

    public void addScore(Student student, T score){
        List<T> studentScores;
        if(!students.containsKey(student)){
            throw new RuntimeException("Not a student");
        }else{
            studentScores = students.get(student);
            studentScores.add(score);
        }
    }

    public List<T> getStudentscore(Student student){
        return this.students.get(student);
    }

    public String printStudentScore(Student student) {
        StringBuilder str = new StringBuilder();
        for (T i:this.getStudentscore(student)) {
            str.append(i.toString()).append(", ");
        }
        return str.toString();
    }
}
