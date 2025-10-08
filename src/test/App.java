package test;

import model.Student;
import model.Team;

public class App {

    public static void main(String[] args) {
        Team team1 = new Team("Team A", "Room 101");
        Team team2 = new Team("Team B", "Room 102");

        Student student1 = new Student("Alice", true, new int[]{10, 7, 12});
        Student student2 = new Student("Bob", false, new int[]{4, 7, 10});
        Student student3 = new Student("Charlie", true, new int[]{12, 12, 12});
        Student student4 = new Student("Diana", true, new int[]{10, 10, 10});
        Student student5 = new Student("Eve", false, new int[]{02, 4, 10});
        Student student6 = new Student("Frank", true, new int[]{02, 7, 10});

        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);

        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

        System.out.println("\nAll students in " + team1.getName() + ":");
        for (Student student : team1.students) {
            System.out.println("- " + student.getName());
        }

        System.out.println("\nActive students in " + team1.getName() + ":");
        for (Student student : team1.getActiveStudentsArrayList()) {
            System.out.println("- " + student.getName());
        }

        System.out.println("\nActive students in " + team2.getName() + ":");
        for (Student student : team2.getActiveStudentsArrayList()) {
            System.out.println("- " + student.getName());
        }

        team1.removeStudent("Bob");
        System.out.println("\nStudents in " + team1.getName() + " after removing Bob:");
        for (Student student : team1.students) {
            System.out.println("- " + student.getName());
        }

    }
}
