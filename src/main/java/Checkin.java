// Willkommen zum Checkin für alte und neue Kunden
// Nach einem manuellem Start werden alle weiteren Optionen in der Konsole ausgegeben
// Nach dem Abschluss geht es weiter mit der Buchung

import java.util.ArrayList;
import java.util.Scanner;

public class Checkin {

    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        // Erstellt ein noch leeres Array
        ArrayList<String[]> kundenListe = new ArrayList<>();
        
        // Beispielkunden
        String[][] beispielKunden = {
            {"Musterman", "Max", "Berlin", "Sonnenallee 1", "10001"},
            {"Musterfrau", "Maria", "Hamburg", "Mondallee 2", "20002"},
            {"Fischer", "Helene", "München", "Schlagerstrasse 3", "30003"},
            {"Mann", "Thomas", "Köln", "Autorenweg 4", "40004"},
            {"Bleibtreu", "Moritz", "Frankfurt", "Schaustellerstrasse 5", "50005"}
        };
        
        // Fügt dem Array die Beispielkunden hinzu
        for (String[] kunde : beispielKunden) {
            kundenListe.add(kunde);
        }

        // Begrüßung im Kundenverwaltungs-System und auswahl der Optionen
        while (true) {
            System.out.println("Willkommen im Kundenverwaltungs-System");
            System.out.println("1. Neuen Kunden erstellen");
            System.out.println("2. Alle Kunden anzeigen");
            System.out.println("3. Vorhandenen Kunden abfragen");
            System.out.println("4. Programm beenden");

            int auswahl = scanner.nextInt();
            scanner.nextLine();  
            
            // Eingabe für die temporäre Erweiterung des Arrays
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
                
             // Wirft die Liste der vorhandenen Kunden in der Konsole aus
            } else if (auswahl == 2) {
                System.out.println("Alle Kunden:");
                for (String[] kunde : kundenListe) {
                    System.out.println("Nachname: " + kunde[0] + ", Vorname: " + kunde[1] + ", Wohnort: " + kunde[2] + ", Straße: " + kunde[3] + ", PLZ: " + kunde[4]);
                }
                System.out.println();
                
             // Ermöglicht nach einem Vorhandenem Kunden zu suchen
            } else if (auswahl == 3) {
                System.out.print("Geben Sie den Nachnamen des Kunden ein: ");
                String nachname = scanner.nextLine();
                System.out.print("Geben Sie den Vornamen des Kunden ein: ");
                String vorname = scanner.nextLine();
                
                
              // Boolsche Abfrage ob die Eingabe korrekt war
                boolean kundeGefunden = false;
                for (String[] kunde : kundenListe) {
                    if (kunde[0].equalsIgnoreCase(nachname) && kunde[1].equalsIgnoreCase(vorname)) {
                        System.out.println("Willkommen zurück, " + kunde[1] + " " + kunde[0] + "!");
                        kundeGefunden = true;
                        break;
                    }
                }
                if (!kundeGefunden) {
                    System.out.println("Kunde nicht gefunden.\n");
                }
             // Beendet das Programm und weißt auf den weiteren Verlauf hin
            } else if (auswahl == 4) {
                System.out.println("Programm wird beendet. Bitte fahren Sie mit der Buchung fort.");
                break;
                
             // Sollte eine Falsche Eingabe erfolgen, wird darauf hingewiesen
            } else {
                System.out.println("Ungültige Auswahl. Bitte wählen Sie 1, 2, 3 oder 4.\n");
            }
        }

        scanner.close();
    }
    
}
