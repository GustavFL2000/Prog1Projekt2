package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private String name;
    private String room;
    private ArrayList<Student> students = new ArrayList<>();

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

        //return activeStudents.toArray(new Student[0]); //bedre måde Fra Java 11(fra stackoverflow)
        //eller // return highScoreStudents.toArray(Student[]::new);
        // kopiere til et array manuelt
        Student[] arr = new Student[activeStudents.size()];
        for (int i = 0; i < activeStudents.size(); i++) {
            arr[i] = activeStudents.get(i);
        }
        return arr;
    }

    public Student[] highScoreStudents(double minAverage) {
        ArrayList<Student> highScoreStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive() && student.getAverageGrade() >= minAverage) {
                highScoreStudents.add(student);
            }
        }

        //return highScoreStudents.toArray(new Student[0]); //bedre måde Fra Java 11(fra stackoverflow)
        //eller // return highScoreStudents.toArray(Student[]::new); fra chatGPT
        // Manuelt 
        Student[] arr = new Student[highScoreStudents.size()];
        for (int i = 0; i < highScoreStudents.size(); i++) {
            arr[i] = highScoreStudents.get(i);
        }
        return arr;
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
        if (students.isEmpty()) {
            return -1; // ingen studerende
        }

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
