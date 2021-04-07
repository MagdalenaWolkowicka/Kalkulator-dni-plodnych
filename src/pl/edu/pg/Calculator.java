package pl.edu.pg;

import pl.edu.pg.functions.FertileDays;
import pl.edu.pg.functions.NextMenstruation;
import pl.edu.pg.functions.PhasesOfTheMenstrualCycle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Calculator {

    long daysBetween;
    LocalDate firstDayOfTheLastMenstrual;
    int lengthOfTheMenstrualCycle;

    Scanner scanner = new Scanner(System.in);
    PhasesOfTheMenstrualCycle phasesOfTheMenstrualCycle = new PhasesOfTheMenstrualCycle();
    FertileDays fertileDays = new FertileDays();
    NextMenstruation nextMenstruation = new NextMenstruation();

    public void start() {
        Menu menu = new Menu();
        while (true) {
            menu.showMenu();
            actionMenu();
        }
    }

    public void actionMenu() {
        System.out.println("\nWybierz opcję: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                questions();
                if (checkIfTheDateIsCorrect()) break;
                if (lateMenstruation()) break;
                phasesOfTheMenstrualCycle.checkFertility(daysBetween);
                break;
            case 2:
                if (firstDayOfTheLastMenstrual == null) {
                    questions();
                    if (checkIfTheDateIsCorrect()) break;
                    fertileDays.calculateAndShowTheFertileDays(firstDayOfTheLastMenstrual);
                } else {
                    if (checkIfTheDateIsCorrect()) break;
                    fertileDays.calculateAndShowTheFertileDays(firstDayOfTheLastMenstrual);
                }
                break;
            case 3:
                if (firstDayOfTheLastMenstrual == null) {
                    questions();
                    if (checkIfTheDateIsCorrect()) break;
                    nextMenstruation.calculateDateOfTheNextMenstrual(firstDayOfTheLastMenstrual, lengthOfTheMenstrualCycle);
                } else {
                    if (checkIfTheDateIsCorrect()) break;
                    nextMenstruation.calculateDateOfTheNextMenstrual(firstDayOfTheLastMenstrual, lengthOfTheMenstrualCycle);
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Błędny wybór");
        }
    }

    private void questions() {
        System.out.println("Podaj datę pierwszego dnia ostatniej miesiączki (yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        firstDayOfTheLastMenstrual = LocalDate.parse(date);
        System.out.println("Ile dni ma cykl?");
        lengthOfTheMenstrualCycle = scanner.nextInt();
        daysBetween = ChronoUnit.DAYS.between(firstDayOfTheLastMenstrual, LocalDate.now());
    }

    private boolean lateMenstruation() {
        if (daysBetween > lengthOfTheMenstrualCycle * 2) {
            System.out.println("Idź do lekarza na kontrolę\n");
            return true;
        }
        return false;
    }

    private boolean checkIfTheDateIsCorrect() {
        if (firstDayOfTheLastMenstrual.isAfter(LocalDate.now())) {
            System.out.println("Błędna data, spróbuj jeszcze raz.\n");
            return true;
        }
        return false;
    }
}
