package ru.vvv.students;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentGroup<T> {
private Subject subject;
private Map<Student,T> students;

    public StudentGroup(Subject subject) {
        this.subject = subject;
        this.students = new HashMap();
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void addStudent(Student student){
        this.students.put(student,null);
    }

    public void removeStudent(Student student){
        if(this.students.containsKey(student)) {
            this.students.remove(student);
            student.leaveGroup(this);
        }
    }

    public void setScore(Student student,T score){
        students.put(student, score);
//        if(this.students.containsKey(student)) {
//            if(score instanceof Integer && this.getSubject().isScoretype()){
//                this.students.put(student, new NumberScore((Integer)score));
//            }else if(score instanceof Boolean && !this.getSubject().isScoretype()){
//                this.students.put(student, new BoolScore((Boolean) score));
//            }else {
//                throw new RuntimeException("Incorrect mark type");
//            }
//        }else {
//            throw new RuntimeException("Not a student");
//        }
    }

    public T getStudentscore(Student student){
        return this.students.get(student);
    }
}
