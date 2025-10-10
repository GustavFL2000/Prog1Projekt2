package test;

import java.util.Arrays;
import model.MultipleChoiceTest;
import model.Student;
import model.Team;

public class App {

    public static void main(String[] args) {

        Team team1 = new Team("Team A", "Room 101");
        Team team2 = new Team("Team B", "Room 102");

        Student student1 = new Student("Alice", true, new int[]{7, 8, 9});
        Student student2 = new Student("Bob", false, new int[]{4, 7, 10});
        Student student3 = new Student("Charlie", true, new int[]{12, 12, 12});
        Student studentx = new Student("Gustav", true, new int[]{12, 12, 12});
        Student student4 = new Student("Diana", true, new int[]{10, 10, 10});
        Student student5 = new Student("Eve", false, new int[]{2, 4, 10});
        Student student6 = new Student("Frank", true, new int[]{2, 7, 10});

        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        team1.addStudent(studentx);

        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

        System.out.println("\nAll students in " + team1.getName() + ":");
        System.out.println(team1);

        System.out.println("\nAll students in " + team2.getName() + ":");
        System.out.println(team2);

        System.out.println("\nActive students in " + team1.getName() + ":");
        System.out.println(Arrays.toString(team1.getActiveStudents()));

        System.out.println("\nActive students in " + team2.getName() + ":");
        System.out.println(Arrays.toString(team2.getActiveStudents()));

        team1.removeStudent("Bob");
        System.out.println("\nStudents in " + team1.getName() + " after removing Bob:");
        System.out.println(team1);

        team2.removeStudent("Diana");
        System.out.println("\nStudents in " + team2.getName() + " after removing Diana:");
        System.out.println(team2);

        System.out.println("\nMax grade of Frank: " + student6.getMaxGrade());
        System.out.println("Average grade of Frank: " + student6.getAverageGrade());

        System.out.println("\nAverage grade of " + team1.getName() + ": " + team1.getTeamAverageGrade());
        System.out.println("Average grade of " + team2.getName() + ": " + team2.getTeamAverageGrade());

        //Opgave 2.5
        team1.generateAnswersForActiveStudents();
        team1.printAnswers();

        team2.generateAnswersForActiveStudents();
        team2.printAnswers();

        //Opgave2.6
        System.out.println("\nKorrekte svar: " + Arrays.toString(MultipleChoiceTest.getCorrectAnswers()));

        System.out.println("\nAntal korrekte svar pr. student i " + team1.getName() + ":");
        System.out.println(Arrays.toString(team1.correctAnswersCountArray()) + "\n");

        //2.7
        System.out.println(Arrays.toString(team1.studentText()));
        System.out.println(Arrays.toString(team2.studentText()));

        //2.8
        System.out.println("\nFordeling af korrekte svar i " + team1.getName() + ":");
        int[] distribution1 = team1.correctCountPerQuestion();
        for (int i = 0; i < distribution1.length; i++) {
            System.out.println("Spørgsmål " + (i + 1) + ": " + distribution1[i] + " korrekte svar");
        }

    }
}
