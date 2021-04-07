package pl.edu.pg;

public class Menu {

    public enum Options {
        EXIT("Wyjście"),
        CYCLE_PHASE("Sprawdź fazę cyklu"),
        FERTILE_DAYS("Zobacz kiedy dni płodne"),
        NEXT_MENSTRUAL("Data kolejnej miesiączki");

        private String value;

        Options(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    Options[] options = Options.values();

    public void showMenu() {
        for (int i = 1; i < options.length; i++) {
            System.out.println(i + ". " + options[i].getValue());
        }
        System.out.println(0 + ". " + Options.EXIT.getValue());
    }
}
