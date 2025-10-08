package model;

public class Student {

    private String name;
    private boolean active;
    private int[] grades;

    public Student() {
        this.name = "Unknown";
        this.active = false;
        this.grades = new int[0];
    }

    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

}
