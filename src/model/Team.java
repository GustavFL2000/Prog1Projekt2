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

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
