
import java.util.Scanner;


public class Buchung {
    
        // Klasse zur Darstellung eines Zimmers
    static class Zimmer {
        String name;
        int preis;
        int verfuegbareZimmer;

        Zimmer(String name, int preis, int verfuegbareZimmer) {
            this.name = name;
            this.preis = preis;
            this.verfuegbareZimmer = verfuegbareZimmer;
        }
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Zimmerangebote erstellen
        Zimmer[] zimmerListe = {
            new Zimmer("Einzelzimmer", 100, 10),
            new Zimmer("Doppelzimmer", 200, 8),
            new Zimmer("Suite", 300, 5),
            new Zimmer("Penthouse", 400, 0)
        };
        // While Schleife damit die Abfrage am laufen bleibt solange der Buchungsvorgang noch läuft
        while (true) {
            
            // Zimmerliste anzeigen
            System.out.println("Willkommen im Java Top Hotel! Bitte wählen Sie ein Zimmer:");
            for (int i = 0; i < zimmerListe.length; i++) {
                Zimmer zimmer = zimmerListe[i];
                System.out.println((i + 1) + ". " + zimmer.name + " - " + zimmer.preis + " Euro/Nacht - Verfügbar: " + zimmer.verfuegbareZimmer);
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

            Zimmer gewaehltesZimmer = zimmerListe[auswahl - 1];

            if (gewaehltesZimmer.verfuegbareZimmer == 0) {
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
            int gesamtKosten = gewaehltesZimmer.preis * naechte;
            
            // Rabatt anwenden
            if (rabattAnwenden) {
                gesamtKosten = (int) (gesamtKosten * 0.9); // 10% Rabatt
            }

            // Buchungsbestätigung anzeigen und Angabe wie es weiter geht
            System.out.println("Sie haben ein " + gewaehltesZimmer.name + " für " + naechte + " Nächte gebucht.");
            System.out.println("Gesamtkosten: " + gesamtKosten + " Euro.");
            System.out.println("Bitte fahren Sie mit dem Zimmer Service fort");

            

            break;  // Buchung erfolgreich, Schleife wird beendet
        }

        scanner.close();
    }
}
