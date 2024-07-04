// Willkommen zum Zimmer Service des Java Main Hotels
// 


import java.util.ArrayList;
import java.util.Scanner;

public class ZimmerService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Angebotene Leistungen
        String[][] leistungen = {
            {"Frühstück", "15"},
            {"Mittagessen", "25"},
            {"Abendessen", "30"},
            {"Zimmerreinigung", "20"},
            {"Wäscheservice", "10"}
        };

        // Erstellt die Liste der gebuchten Leistungen
        ArrayList<String[]> gebuchteLeistungen = new ArrayList<>();

        while (true) {
            // Leistungen anzeigen
            System.out.println("Zimmer-Service Leistungen:");
            for (int i = 0; i < leistungen.length; i++) {
                System.out.println((i + 1) + ". " + leistungen[i][0] + " - " + leistungen[i][1] + " Euro");
            }

            // Leistungsauswahl
            System.out.print("Bitte geben Sie die Nummer der gewünschten Leistung ein (oder 0 zum Beenden): ");
            int auswahl = scanner.nextInt();
            scanner.nextLine();  
            
            // beendet die Auswahl
            if (auswahl == 0) {
                break;  
            }

            if (auswahl < 1 || auswahl > leistungen.length) {
                System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                continue;
            }

            int leistungIndex = auswahl - 1;

            // Fügt Leistungen zur Liste der gebuchten Leistungen hinzu und gibt aus was hinzu gefügt wurde
            gebuchteLeistungen.add(leistungen[leistungIndex]);
            System.out.println(leistungen[leistungIndex][0] + " wurde zur Buchung hinzugefügt.");
        }

        // Gesamtkosten berechnen
        int gesamtKosten = 0;
        System.out.println("\nGebuchte Leistungen:");
        for (String[] leistung : gebuchteLeistungen) {
            System.out.println(leistung[0] + " - " + leistung[1] + " Euro");
            gesamtKosten += Integer.parseInt(leistung[1]);
        }

        System.out.println("Gesamtkosten: " + gesamtKosten + " Euro.");

        scanner.close();
    }
}
