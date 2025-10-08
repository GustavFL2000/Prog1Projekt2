package model;

import java.util.Random;

public class MultipleChoiceTest {

    private static final char[] ANSWERS = {'A', 'B', 'C', 'D'};
    private static final int NUM_ANSWERS = 10;

    public static char[] generateRandomAnswers() {
        char[] answers = new char[NUM_ANSWERS];
        Random random = new Random();
        for (int i = 0; i < NUM_ANSWERS; i++) {

            answers[i] = ANSWERS[random.nextInt(ANSWERS.length)];
        }
        return answers;
    }

}
