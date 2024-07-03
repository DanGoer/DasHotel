// Dies ist die Startseite meines Hotel Projektes
// Nach dem manuellen Start dieser Seite werden die weiteren Anweisungen in der Konsole ausgegeben

import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       // Sie betreten die gemütliche Lobby des Hotels ihrer Wahl

        System.out.println("Willkommen im Java Top Hotel! Wie kann ich Ihnen helfen?");
        System.out.println("1. Erstkunde");
        System.out.println("2. Zurückkehrender Gast");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Bitte fahren Sie mit First Checkin weiter fort.");
        } else if (choice == 2) {
            System.out.println("Bitte fahren Sie mit Checkin weiter fort.");
        } else {
            System.out.println("Ungültige Eingabe. Bitte starten Sie das Programm neu und wählen Sie 1 oder 2."); // Mehr oder weniger elegante Lösung für eine falsche Eingabe
        }

        scanner.close();
    
    }
}
