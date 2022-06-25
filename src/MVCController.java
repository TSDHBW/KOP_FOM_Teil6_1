/**
 * Klasse MVCController ist für die Erzeugung des User Interface und des Datenmodells verantwortlich.
 * Zusätzlich werden alle Benutzeraktionen im User Interface in Form von ActionEvents behandelt.
 * @author Timo
 * @version 1.0
 */
public class MVCController {

    private MVCView view;
    private MVCModel model;

    public MVCController() {
        //Erzeugung des User Interface durch ein Objekt der Klasse MVCView
        this.view = new MVCView(this);
        //Erzeugung des Datenmodells durch ein Objekt der Klasse MVCModel
        this.model = new MVCModel();

        testeRezeptverwaltung();

    }

    public void testeRezeptverwaltung(){

        Zutat zitrone = new Zutat("Zitrone", 1.00);
        model.zutatenverwaltung.nehmeZutatAuf(zitrone);
        Zutat orange = new Zutat("Orange", 1.50);
        model.zutatenverwaltung.nehmeZutatAuf(orange);
        Zutat minze = new Zutat("Minze", 0.75);
        model.zutatenverwaltung.nehmeZutatAuf(minze);
        Zutat zucker = new Zutat("Zucker", 0.25);
        model.zutatenverwaltung.nehmeZutatAuf(zucker);
        Zutat wasser = new Zutat("Wasser", 0.10);
        model.zutatenverwaltung.nehmeZutatAuf(wasser);
        Zutat eis = new Zutat("Eis", 0.50);
        model.zutatenverwaltung.nehmeZutatAuf(eis);
        Zutat limette = new Zutat("Limette", 2.00);
        model.zutatenverwaltung.nehmeZutatAuf(limette);

        Zutat[] zutatenOrangenlimo = {orange, minze, wasser, eis};
        Limonade orangenlimo = new Limonade("Orangenlimo", zutatenOrangenlimo, false,true, "Orange", true);

        Zutat[] zutatenZitronenlimo = {zitrone, minze, zucker, wasser, eis};
        Limonade zitronenlimo = new Limonade("Zitronenlimo", zutatenZitronenlimo, false, false, "Zitrone", false);

        Zutat[] zutatenCaipirinha = {minze, limette, zucker, wasser, eis};
        Cocktail caipirinha = new Cocktail("Caipirinha", zutatenCaipirinha, false, false, 0, true);

        model.rezeptverwaltung.nehmeRezeptAuf(orangenlimo);
        model.rezeptverwaltung.nehmeRezeptAuf(zitronenlimo);
        model.rezeptverwaltung.nehmeRezeptAuf(caipirinha);
        model.rezeptverwaltung.zeigeAlleRezepteAn();
        System.out.println("Anzahl: " + model.rezeptverwaltung.ermittleAnzahlRezepte());
        System.out.println("Anzahl Limo: " + model.rezeptverwaltung.ermittleAnzahlRezepte("Limonade"));
        model.rezeptverwaltung.loescheRezept("Zitronenlimo", "Limonade");
        System.out.println("Anzahl Limo: " + model.rezeptverwaltung.ermittleAnzahlRezepte("Limonade"));
        model.rezeptverwaltung.zeigeAlleRezepteAn();
        model.rezeptverwaltung.zeigeRezeptAn("Orangenlimo", "Limonade");
        System.out.println("");
        System.out.println("---");
        Zutat[] zutatenOrangenlimoNeu = {orange, zitrone, minze, wasser, eis};
        orangenlimo.setZutaten(zutatenOrangenlimoNeu);
        model.rezeptverwaltung.nehmeRezeptAuf(orangenlimo);
        model.rezeptverwaltung.zeigeAlleRezepteAn();
        model.rezeptverwaltung.zeigeRezeptAn("Orangenlimo", "Limonade");
        System.out.println("---");
        BasisRezept[] speisen = {zitronenlimo, orangenlimo, caipirinha, zitronenlimo};
        System.out.println("Gesamtpreis: " + ermittleGesamtpreis(speisen));


    }

        public double ermittleGesamtpreis(Verkaufspreis[]speisen){

            double verkaufspreis = 0.0;
            for (int i = 0; i < speisen.length; i++){
                if (speisen[i] != null){
                    verkaufspreis = verkaufspreis + speisen[i].ermittelVerkaufspreis();
                }
            }
            return verkaufspreis;
        }
}
