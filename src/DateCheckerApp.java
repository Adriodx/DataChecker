import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class DateCheckerApp {
    final String DATE_FORMAT = "dd-mm-yyyy";
    private String date;
    private String year;

    private void enterData() {
        System.out.println("Wprowadź date w formacie: dd-mm-yyyy (dzień-miesiąc-rok)" +
                "\ndostępny zakres od 2001-2099 roku: ");
        Scanner d = new Scanner(System.in);
        date = d.nextLine();
    }

    private void checkDate() {
        try {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateFormat.setLenient(false);
            dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Niepoprawny zapis daty!");
        }
        year = date.substring(6, 10);
        int yearNumber = Integer.parseInt(year);
        if (yearNumber < 2001 || yearNumber > 2099) {
            throw new IllegalArgumentException("Niepoprwany rok!");
        }
        System.out.println("Data: " + date + " jest poprawna.");
    }

    private void analyzeDate() {
        while (true) {
            enterData();
            try {
                checkDate();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Niepoprawna data, wprowadź ponownie!");
            }
        }
    }

    public void runChecking() {
        analyzeDate();
    }

}
