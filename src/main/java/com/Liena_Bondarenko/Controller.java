package com.Liena_Bondarenko;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    Scanner in = new Scanner(System.in);
    int minValue = 0;
    int maxValue = 100;
    int attemptCount = 0;
    int a = 0;
    int b = 100;
    boolean result = false;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void guessingSecretNumber() {

        int random_number = a + (int) (Math.random() * b);
        //System.out.println(random_number);

        System.out.println(View.INPUT);

        do {
            int guess = in.nextInt();

            if (guess >= minValue && guess <= maxValue) {

                if (guess > random_number) {
                    maxValue = guess;
                    attemptCount++;
                    System.out.println(View.WRONG_LESS);
                    System.out.println(View.INPUT_IN_RANGE + minValue + View.TO + maxValue);
                }
                if (guess < random_number) {
                    minValue = guess;
                    attemptCount++;
                    System.out.println(View.WRONG_MORE);
                    System.out.println(View.NEW_RANGE + minValue + View.TO + maxValue);
                }
                if (guess == random_number) {
                    attemptCount++;
                    result = true;
                    System.out.println(View.SUCCESS + guess);
                }
            }
            if (guess < minValue || guess > maxValue) {
                System.out.println(View.INPUT_IN_RANGE + minValue + " - " + maxValue);
                attemptCount++;
            }

        } while (!result);

        System.out.println(View.WIN + attemptCount + View.STEPS);
    }
}
