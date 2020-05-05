package ru.vvv.students;

public class Main {
    public static void main(String[] args) {
        Student peter = new Student("Peter");
        Student ivan = new Student("Ivan");
        StudentGroup<Integer> math = new StudentGroup<>("Math");
        StudentGroup<Boolean> literature = new StudentGroup<>("Literature");
        StudentGroup<Integer> java = new StudentGroup<>("java");
        peter.addToGroup(math);
        ivan.addToGroup(math);
        ivan.addToGroup(literature);
        ivan.addToGroup(java);
        // на информатике плохо себя вел и был исключен
        java.removeStudent(ivan);
        //peter отличился на математике и досрочно получил 5
        math.addScore(peter, 3);
        //и получил зачет по литре
        literature.addScore(ivan,true);
        literature.addScore(ivan,false);
        math.addScore(ivan,4);
        math.addScore(ivan,3);
        math.addScore(ivan,3);
        ivan.listGroups();
    }
}
