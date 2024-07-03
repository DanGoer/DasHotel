import java.util.ArrayList;
import java.util.Scanner;

public class Checkin {

    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> kundenListe = new ArrayList<>();
        
        // Beispielkunden
        String[][] beispielKunden = {
            {"Musterman", "Max", "Berlin", "Sonnenallee 1", "10001"},
            {"Musterfrau", "Maria", "Hamburg", "Mondallee 2", "20002"},
            {"Fischer", "Helene", "München", "Schlagerstrasse 3", "30003"},
            {"Mann", "Thomas", "Köln", "Autorenweg 4", "40004"},
            {"Bleibtreu", "Moritz", "Frankfurt", "Schaustellerstrasse 5", "50005"}
        };

        while (true) {
            System.out.println("Willkommen im Kundenverwaltungs-System");
            System.out.println("1. Neuen Kunden erstellen");
            System.out.println("2. Alle Kunden anzeigen");
            System.out.println("3. Programm beenden");

            int auswahl = scanner.nextInt();
            scanner.nextLine();  

            if (auswahl == 1) {
                String[] neuerKunde = new String[5];
                System.out.print("Nachname: ");
                neuerKunde[0] = scanner.nextLine();
                System.out.print("Vorname: ");
                neuerKunde[1] = scanner.nextLine();
                System.out.print("Wohnort: ");
                neuerKunde[2] = scanner.nextLine();
                System.out.print("Straße: ");
                neuerKunde[3] = scanner.nextLine();
                System.out.print("PLZ: ");
                neuerKunde[4] = scanner.nextLine();

                kundenListe.add(neuerKunde);
                System.out.println("Kunde erfolgreich hinzugefügt!\n");
                
            } else if (auswahl == 2) {
                System.out.println("Alle Kunden:");
                for (String[] kunde : kundenListe) {
                    System.out.println("Nachname: " + kunde[0] + ", Vorname: " + kunde[1] + ", Wohnort: " + kunde[2] + ", Straße: " + kunde[3] + ", PLZ: " + kunde[4]);
                }
                System.out.println();
            } else if (auswahl == 3) {
                System.out.println("Programm wird beendet.");
                break;
            } else {
                System.out.println("Ungültige Auswahl. Bitte wählen Sie 1, 2 oder 3.\n");
            }
        }

        scanner.close();
    }
    
}
