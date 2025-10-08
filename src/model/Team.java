package model;

import java.util.ArrayList;

public class Team {

    private String name;
    private String room;
    public ArrayList<Student> students = new ArrayList<>();

    public Team() {
        this.name = "Unknown";
        this.room = "Unknown";
    }

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public ArrayList<Student> getActiveStudentsArrayList() {
        ArrayList<Student> activeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }

    public void removeStudent(String name) {
        int i = 0;
        while (i < students.size()) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                break;
            } else {
                i++;
            }
        }
    }

    public void printStudentList(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            System.out.println("- " + student.getName());
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

}
