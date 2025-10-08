package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private String name;
    private String room;
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Team() {
        this.name = "Unknown";
        this.room = "Unknown";
    }

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public Student[] getActiveStudents() {
        ArrayList<Student> activeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents.toArray(new Student[0]);
    }

    public void removeStudent(String name) {
        int i = 0;
        while (i < students.size()) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                return;
            } else {
                i++;
            }
        }
    }

    // Bruger averageGrade metoden fra Student klassen til at summere dem op og dele med antallet af studerende
    public double getTeamAverageGrade() {
        double total = 0;
        for (Student student : students) {
            total += student.getAverageGrade();
        }
        return total / students.size();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + room + ") " + "\nStudents: " + Arrays.toString(students.toArray());
    }
}
