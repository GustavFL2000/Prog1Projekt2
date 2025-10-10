package model;

public class Student {

    private final String name;
    private final boolean active;
    private final int[] grades;
    private char[] answers = new char[10];

    public int correctAnswersCount() {
        int count = 0;
        //char[] correctAnswers = MultipleChoiceTest.getCorrectAnswers(); 
        //Statisk variable kaldes direkte på klassen
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == MultipleChoiceTest.getCorrectAnswers()[i]) {
                count++;
            }
        }

        return count;
    }

    public char[] getAnswers() {
        return answers;
    }

    public void setAnswers(char[] answers) {
        this.answers = answers;
    }

    public Student() {
        this.name = "Unknown";
        this.active = false;
        this.grades = new int[0];
    }

    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
        this.answers = MultipleChoiceTest.generateRandomAnswers();
    }

    public int getMaxGrade() {
        if (grades.length == 0) {
            return -1; // ingen karakterer
        }
        int max = grades[0];
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    // Løber igennem grades arrayet og lægger dem sammen, dividerer med længden af arrayet
    public double getAverageGrade() {
        if (grades.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return name + " (Active: " + active + ") Grades: " + java.util.Arrays.toString(grades);
    }
}
