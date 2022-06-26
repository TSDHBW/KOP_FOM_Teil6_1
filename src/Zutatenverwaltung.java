import java.util.InputMismatchException;
import java.util.Scanner;

public class Zutatenverwaltung {

    private Zutat[] zutaten;

    public Zutatenverwaltung (){

        zutaten = new Zutat[1000];

    }

    public void nehmeZutatAuf (Zutat zutat){

        boolean aktualisiert = false;
        for (int i = 0; i < zutaten.length; i++){

            if (zutaten[i] != null){

                if (zutaten[i].getName().equals(zutat.getName()) == true){

                    // Aktualisieren von Rezept
                    zutaten[i] = zutat;
                    aktualisiert = true;
                    break;

                }
            }
        }

        if (aktualisiert == false){

            for (int i = 0; i < zutaten.length; i++){

                if (zutaten[i] == null){

                    // Hinzufügen von Rezept
                    zutaten[i] = zutat;
                    break;

                }
            }
        }
    }

    public void zeigeAlleZutatenAn () {

        for (int i = 0; i < zutaten.length; i++){

            if (zutaten[i] != null){

                System.out.println(zutaten[i].getName());

            }
        }

    }

    public void loescheZutat (String zutatenname){

        for (int i = 0; i < zutaten.length; i++){

            if (zutaten[i] != null){

                if (zutaten[i].getName().equals(zutatenname) == true){

                    zutaten[i] = null;

                }
            }
        }
    }

    public void zeigeZutatAn (String zutatenname){

        for (int i = 0; i < zutaten.length; i++){

            if (zutaten[i] != null){

                if (zutaten[i].getName().equals(zutatenname)){

                    System.out.println("Anzeige von Rezept:");
                    System.out.println("Name: " + zutaten[i].getName());
                    System.out.println("Preis: " + zutaten[i].getPreis());

                }
            }
        }
    }

    public int ermittleAnzahlZutaten (){

        int anzahl = 0;

        for (int i = 0; i < zutaten.length; i++){

            if (zutaten[i] != null){

                anzahl++;

            }
        }
        return anzahl;
    }

    public Zutat getZutat (String zutatenname){

        boolean ZutatEnthalten = false;
        for (int i = 0; i < zutaten.length; i++){

            if (zutaten[i] != null){

                if (zutaten[i].getName().equals(zutatenname) == true){

                    System.out.println("Rezept gefunden");
                    ZutatEnthalten = true;
                    return zutaten[i];

                }
            }
        }
        if (ZutatEnthalten == false){
            System.out.println("Rezept nicht enthalten");
        }
        return null;
    }

    public Zutat sucheZutat(){
        Scanner scanner = new Scanner(System.in);
        boolean zutatGefunden = false;
        try{
            String name = scanner.nextLine();
            for (int i = 0; i < zutaten.length; i++){
                if (zutaten[i] != null){
                    if (zutaten[i].getName().equals(name)){
                        zutatGefunden = true;
                        return zutaten[i];
                    }
                }
            }
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            System.out.println("Ungeültige Eingabe");
        } finally {
            //scanner.close();
        }
        if (zutatGefunden == false){
            System.out.println("Zutat nicht gefunden");
        }
        return null;
    }

    public void aendereZutatenPreis(){
        // zu implementieren
    }

    public Zutat[] getRezepte() {
        return zutaten;
    }

    public void setZutaten(Zutat[] zutaten) {
        this.zutaten = zutaten;
    }

}
