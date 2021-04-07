package pl.edu.pg.functions;

public class PhasesOfTheMenstrualCycle {

    public void checkFertility(long daysBetween) {
        if (daysBetween <= 4) {
            System.out.println("Krwawienie, dni niepłodne\n");
        } else if ((daysBetween > 4) && (daysBetween < 10) || (daysBetween > 15)) {
            System.out.println("Dni niepłodne\n");
        } else if ((daysBetween >= 10) && (daysBetween <= 12) || (daysBetween >= 14) && (daysBetween <= 15)) {
            System.out.println("Dni płodne\n");
        } else if (daysBetween == 13) {
            System.out.println("Dziś jest największa szansa zajścia w ciążę!\n");
        }
    }
}
