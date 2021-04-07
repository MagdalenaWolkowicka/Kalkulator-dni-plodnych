package pl.edu.pg.functions;

import java.time.LocalDate;

public class FertileDays {

    public void calculateAndShowTheFertileDays(LocalDate firstDayOfTheLastMenstrual) {
        System.out.println("Początek dni płodnych " + firstDayOfTheLastMenstrual.plusDays(10));
        System.out.println("Koniec dni płodnych " + firstDayOfTheLastMenstrual.plusDays(15));
        System.out.println("Największa szansa zajścia w ciążę " + firstDayOfTheLastMenstrual.plusDays(13) + "\n");
    }
}
