// Willkommen zur Buchung der Zimmer des Java Main Hotels
// Verlangt einen weiteren Manuellen start
// Ermöglicht es aus einer Auwahl an Zimmer das richtige aus zu suchen und die Anzahl der gewünschten Tage einzugeben
// Ermöglicht die Eingabe eines Rabattcodes
// Kalkuliert die anfallenden Kosten

import java.util.Scanner;


public class Buchung {
    
    
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Zimmerangebote erstellen
        String[][] zimmerListe = {
            {"Einzelzimmer", "100", "10"},
            {"Doppelzimmer", "200", "8"},
            {"Suite", "300", "5"},
            {"Penthouse", "400", "0"}
        };

        // While Schleife damit die Abfrage am laufen bleibt solange der Buchungsvorgang noch läuft
        while (true) {
            
            // Zimmerliste anzeigen
            System.out.println("Willkommen im Java Main Hotel! Bitte wählen Sie ein Zimmer:");
            for (int i = 0; i < zimmerListe.length; i++) {
                System.out.println((i + 1) + ". " + zimmerListe[i][0] + " - " + zimmerListe[i][1] + " Euro/Nacht - Verfügbar: " + zimmerListe[i][2]);
            }

            // Zimmerauswahl
            // Akzeptiert nur Zahlen! Bei einer Eingabe die keine ganze Zahl ist, kommt es zu einem Absturz!
            // TODO einbauen der Option das bei einer Falscheingabe das Programm weiterläuft
            System.out.print("Bitte geben Sie die Nummer des gewünschten Zimmers ein: ");
            int auswahl = scanner.nextInt();
            scanner.nextLine();  
         
            if (auswahl < 1 || auswahl > zimmerListe.length) {
                System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                continue;
            }

            int zimmerIndex = auswahl - 1;
            int verfuegbareZimmer = Integer.parseInt(zimmerListe[zimmerIndex][2]);

            if (verfuegbareZimmer == 0) {
                System.out.println("Leider sind keine Zimmer dieses Typs mehr verfügbar. Bitte wählen Sie ein anderes Zimmer.");
                continue;
            }

            // Aufenthaltsdauer abfragen
            // Akzeptiert nur Zahlen! Bei einer Eingabe die keine ganze Zahl ist, kommt es zu einem Absturz!
            // TODO einbauen der Option das bei einer Falscheingabe das Programm weiterläuft
            System.out.print("Wie viele Nächte möchten Sie bleiben? ");
            int naechte = scanner.nextInt();
             scanner.nextLine(); 
            
            // Rabattcode abfragen
            boolean rabattAnwenden = false;
            
            // Weitere While Schleife in der WHileschleife selber, um den Vorgang der Rabattabfrage zu regeln
            while (true) {
                System.out.print("Haben Sie einen Rabattcode? (ja/nein): ");
                String rabattAntwort = scanner.nextLine().trim().toLowerCase();
            // Bricht die Rabatt Aktion ab
                if (rabattAntwort.equals("nein")) {
                    break;
                }
            //Startet die Abfrage für den Rabattcode
                if (rabattAntwort.equals("ja")) {
                    System.out.print("Bitte geben Sie den Rabattcode ein: ");
                    String rabattCode = scanner.nextLine().trim();
                    
                    // Beispielhafter Rabattcode, dieser kann nach belieben verändert werden
                    if (rabattCode.equals("777")) {
                        rabattAnwenden = true;
                        break;
                        
                    // Regelt eine falsche Eingabe    
                    } else {
                        System.out.println("Ungültiger Rabattcode.");
                        System.out.print("Möchten Sie es erneut versuchen? (ja/nein): ");
                        String erneutVersuchen = scanner.nextLine().trim().toLowerCase();
                        if (erneutVersuchen.equals("nein")) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                }
            }
            // Gesamtkosten berechnen
            int preisProNacht = Integer.parseInt(zimmerListe[zimmerIndex][1]);
            int gesamtKosten = preisProNacht * naechte;
            
            // Rabatt anwenden
            if (rabattAnwenden) {
                gesamtKosten = (int) (gesamtKosten * 0.9); // 10% Rabatt
            }

            // Buchungsbestätigung anzeigen und Angabe wie es weiter geht
            System.out.println("Sie haben ein " + zimmerListe[zimmerIndex][0] + " für " + naechte + " Nächte gebucht.");
            System.out.println("Gesamtkosten: " + gesamtKosten + " Euro.");
            System.out.println("Bitte fahren Sie mit dem Zimmer Service fort");

            

            break;  // Buchung erfolgreich, Schleife wird beendet
        }

        scanner.close();
    }
}
