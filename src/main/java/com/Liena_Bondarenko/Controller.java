package com.Liena_Bondarenko;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    Scanner in = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void guessingSecretNumber() {

        int random_number = model.a + (int) (Math.random() * model.b);
        //System.out.println(random_number);

        System.out.println(View.INPUT);

        do {
            int guess = in.nextInt();

            if (guess >= model.minValue && guess <= model.maxValue) {

                if (guess > random_number) {
                    model.maxValue = guess;
                    model.attemptCount++;
                    System.out.println(View.WRONG_LESS);
                    System.out.println(View.INPUT_IN_RANGE + model.minValue + View.TO + model.maxValue);
                }
                if (guess < random_number) {
                    model.minValue = guess;
                    model.attemptCount++;
                    System.out.println(View.WRONG_MORE);
                    System.out.println(View.NEW_RANGE + model.minValue + View.TO + model.maxValue);
                }
                if (guess == random_number) {
                    model.attemptCount++;
                    model.result = true;
                    System.out.println(View.SUCCESS + guess);
                }
            }
            if (guess < model.minValue || guess > model.maxValue) {
                System.out.println(View.INPUT_IN_RANGE + model.minValue + View.TO + model.maxValue);
                model.attemptCount++;
            }

        } while (!model.result);

        System.out.println(View.WIN + model.attemptCount + View.STEPS);
    }
}
