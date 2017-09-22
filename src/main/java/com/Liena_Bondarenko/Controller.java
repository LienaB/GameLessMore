package com.Liena_Bondarenko;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private Scanner in;
    private Model model;
    private View view;
    private ArrayList guessesList = new ArrayList();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void guessingSecretNumber() {

        int random_number = (int) (Math.random() * model.maxValue);
        int guess = model.minValue - 1;
        //System.out.println(random_number);

        System.out.println(View.INPUT);

        do {
            in = new Scanner(System.in);
            try {
                guess = in.nextInt();
                guessesList.add(guess);
            }
            catch (InputMismatchException e) {
                System.out.println(view.EXEPTION_MESSAGE);
            }

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
                    System.out.println(View.SUCCESS + guess);
                }
            }
            if (guess < model.minValue || guess > model.maxValue) {
                System.out.println(View.INPUT_IN_RANGE + model.minValue + View.TO + model.maxValue);
                model.attemptCount++;
            }

        } while (guess != random_number);

        System.out.println(View.WIN + model.attemptCount + View.STEPS);
        System.out.println(View.GUESSES_LIST + guessesList);
    }
}
