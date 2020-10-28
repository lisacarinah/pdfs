public class Main {
    public static void main(String[] args) {
        ////// Exercise 1: Erzeugen einer Liste
        // Erzeuge eine Liste mit dem Namen "namenListe", welche Personennamen
        // (welche Strings sind) speichern soll.
        // Die Liste kann entweder vom Typ ArrayList oder LinkedList sein.
        // Von der Konsole sollen 8 Namen eingelesen werden und sukzessive an die Liste
        // angehängt werden.
        // z.B: namenListe ist am Anfange leer
        // Input von der Konsole: Hans
        // namenListe hat folgenden Inhalt: Hans
        // Input von der Konsole: Rudolf
        // namenListe hat folgenden Inhalt: Rudolf
        // usw.

        ////// Exercise 2: Paarweises vertauschen
        // Schreibe eine Funktion auf "paarweisesVertauschen", 
        // welche namenListe als Parameter entgegen nimmt
        // und eine paarweise vertauschte Liste zurückgibt.
        // Die Funktion bekommt z.B. folgende Liste übergeben:
        // namenListe = [Anna, Christian, Bernd, Maria, Max, Rudolf, Hans, Moritz]
        // Rückgabe: [Christian, Anna, Maria, Bernd, Rudolf, Max, Moritz, Hans]
        // Ein kompletter Funktionsaufruf sieht dann so aus:
        // ArrayList<String> result = paarweisesVertauschen(namenListe);

        ////// Exercise 3: Element zurückgeben
        // Schreibe eine Funktion, die wie folgt aufgerufen wird:
        // String name = nameZurueckgeben(4);
        // Die Funktion nimmt den Index der namenListe entgegen und gibt
        // den passenden Namen zurück. Prüfe, ob der Index gültig ist.
        // Wenn der Index nicht im gültigen Bereich ist, gib
        // als Fehlermeldung zurück: "Index ist nicht gültig."
        // Z.B. wenn wir die Liste aus Exercise 2 nehmen:
        // String name = nameZurueckgeben(4); => name wäre hier: Max
        // String name = nameZurueckgeben(0); => name wäre hier: Anna
        // String name = nameZurueckgeben(-1); => name wäre hier: Index ist nicht gültig.
        // String name = nameZurueckgeben(8); => name wäre hier: Index ist nicht gültig.

        ////// Exercise 4: Erzeuge ein HashSet mit dem Namen "farbenSet".
        // Füge in farbenSet mehrere Farben als Strings ein.
        // Z.B. farbenSet = {rot, gruen, blau, orange, schwarz}
        // Führe folgende Funktionen auf farbenSet aus:
        // 1. Lösche die Farbe blau: remove("blau")
        // 2. Prüfe, ob die Farbe rot im farbenSet ist: contains("rot")
        // 3. Kopiere das farbenSet in ein neues HashSet: clone()
        // Beispielaufruf eines HashSets mit dem Namen "set": cloned_set = (HashSet)set.clone();
        // 4. Lösche alle Farben mit clear()

        ////// Exercise 5: Erzeuge ein zweites HashSet mit dem Namen "pruefFarben".
        // Füge folgende Farben in dieses Set ein:
        // Braun, Grau, Schwarz
        // Ergebnis: pruefFarben = {blau, grau, schwarz}
        // Schreibe eine Funktion
        // boolean[] istVorhanden = checkVorhanden(farbenSet, pruefFarben);
        // Diese Funktion prüft für jedes Element in farbenSet, ob es in pruefFarben vorhanden
        // ist und gibt ein boolsches Array zurück, welches angibt, ob die Farbe in pruefFarben
        // vorhanden ist oder nicht.
        // z.B. farbenSet = {rot, gruen, blau, orange, schwarz}
        //      pruefFarben = {blau, grau, schwarz}
        //      istVorhanden wäre jetzt: [False, False, True, False, True]
        // Erkärung:
        // rot ist nicht in pruefFarben => False
        // gruen ist nicht in pruefFarben => False
        // blau ist in pruefFarben => True
        // orange ist nicht in pruefFarben => False
        // schwarz ist in pruefFarben => True


    }
}
