package pl.edu.pg.functions;

import java.time.LocalDate;

public class NextMenstruation {

    public void calculateDateOfTheNextMenstrual(LocalDate firstDayOfTheLastMenstrual, int lengthOfTheMenstrualCycle) {
        LocalDate dateOfTheNextMenstruation = firstDayOfTheLastMenstrual.plusDays(lengthOfTheMenstrualCycle - 1);
        System.out.println("Data kolejnej miesiączki to " + dateOfTheNextMenstruation + "\n");
        CheckIfPeriodIsLate(dateOfTheNextMenstruation);
    }

    private void CheckIfPeriodIsLate(LocalDate dateOfTheNextMenstruation) {
        if (dateOfTheNextMenstruation.isBefore(LocalDate.now())) {
            System.out.println("Miesiączka się spóźnia\n");
        }
    }
}
