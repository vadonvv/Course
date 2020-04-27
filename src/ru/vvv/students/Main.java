package ru.vvv.students;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student peter = new Student("Peter");
        Student ivan = new Student("Ivan");
        StudentGroup<Integer> math = new StudentGroup<>(new Subject("Math",true));
        StudentGroup<Boolean> literature = new StudentGroup<>(new Subject("Literature",false));
        StudentGroup<Integer> java = new StudentGroup<>(new Subject("java",true));
        peter.addToGroup(math);
        ivan.addToGroup(math);
        ivan.addToGroup(literature);
        ivan.addToGroup(java);
        // на информатике плохо себя вел и был исключен
        java.removeStudent(ivan);
        //peter отличился на математике и досрочно получил 5
        math.setScore(peter, 3);
        //и получил зачет по литре
        literature.setScore(ivan,true);
        ivan.listGroups();
    }
}
