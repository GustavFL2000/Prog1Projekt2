package test;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;
import model.Team;

public class App3b {

    private ArrayList<Team> teams = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App3b().run();
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nMENU");
            System.out.println("1: Opret et team");
            System.out.println("2: Opret en studerende");
            System.out.println("3: Vis en studerendes info og resultater");
            System.out.println("4: Vis et teams info og resultater");
            System.out.println("5: Vis info og resultater for alle teams");
            System.out.println("6: Afslut program");
            System.out.print("Vælg: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    showOneStudent();
                    break;
                case 4:
                    showOneTeam();
                    break;
                case 5:
                    showAllTeams();
                    break;
                case 6:
                    System.out.println("Program afsluttet.");
                    running = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void createTeam() {
        System.out.print("Teamnavn: ");
        String teamName = scanner.nextLine();
        System.out.print("Lokale: ");
        String room = scanner.nextLine();

        Team team = new Team(teamName, room);
        teams.add(team);
        System.out.println("Team oprettet: " + teamName + " (lokale " + room + ")");
    }

    private void createStudent() {
        if (teams.isEmpty()) {
            System.out.println("Der findes ingen teams endnu. Opret et team først.");
            return;
        }

        System.out.println("Tilgængelige teams:");
        for (Team team : teams) {
            System.out.println("- " + team.getName());
        }

        System.out.print("Navn på team: ");
        String teamName = scanner.nextLine();
        Team team = findTeamByName(teamName);
        if (team == null) {
            System.out.println("Ingen team med det navn. Opret det først.");
            return;
        }

        System.out.print("Studerendes navn: ");
        String studentName = scanner.nextLine();
        System.out.print("Er den studerende aktiv? (true/false): ");
        boolean active = scanner.nextBoolean();
        System.out.print("Antal karakterer: ");
        int n = scanner.nextInt();

        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Karakter " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
        scanner.nextLine();

        Student student = new Student(studentName, active, grades);
        team.addStudent(student);

        System.out.println("Studerende tilføjet: " + studentName + " til team " + teamName);
    }

    private void showOneStudent() {
        //Tejker om der er studernede i teams
        if (teams.isEmpty()) {
            System.out.println("Ingen teams oprettet endnu.");
            return;
        }
        //Lister studernede i teams
        System.out.println("Tilgængelige studerende:");
        for (Team team : teams) {
            for (Student student : team.getActiveStudents()) {
                System.out.println("- " + student.getName() + " (Team: " + team.getName() + ")");
            }
        }
        System.out.print("Navn på studerende: ");
        String studentName = scanner.nextLine();

        for (Team team : teams) {
            for (Student student : team.getActiveStudents()) {
                if (student.getName().equalsIgnoreCase(studentName)) {
                    System.out.println("Fundet i team: " + team.getName());
                    System.out.println("Navn: " + student.getName());
                    System.out.println("Aktiv: " + student.isActive());
                    System.out.println("Gennemsnit: " + student.getAverageGrade());
                    System.out.println("Bedste karakter: " + student.getMaxGrade());
                    System.out.println("Antal korrekte svar: " + student.correctAnswersCount());
                    return;
                }
            }
        }
        System.out.println("Ingen studerende fundet med det navn.");
    }

    private void showOneTeam() {
        if (teams.isEmpty()) {
            System.out.println("Ingen teams oprettet endnu.");
            return;
        }
        System.out.println("Tilgængelige teams:");
        for (Team team : teams) {
            System.out.println("- " + team.getName());
        }
        System.out.print("Teamnavn: ");
        String teamName = scanner.nextLine();

        Team team = findTeamByName(teamName);
        if (team == null) {
            System.out.println("Team ikke fundet.");
            return;
        }

        System.out.println("\nTeam: " + team.getName() + " (" + team.getRoom() + ")");
        String[] studentInfo = team.studentText();
        for (String line : studentInfo) {
            System.out.println(line);
        }

        System.out.printf("Teamets gennemsnitlige karakter: %.2f%n", team.getTeamAverageGrade());
    }

    private void showAllTeams() {
        if (teams.isEmpty()) {
            System.out.println("Ingen teams oprettet endnu.");
            return;
        }

        for (Team team : teams) {
            System.out.println("\nTeam: " + team.getName() + " (" + team.getRoom() + ")");
            String[] studentInfo = team.studentText();
            for (String line : studentInfo) {
                System.out.println(line);
            }
        }
    }

    private Team findTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }
}
