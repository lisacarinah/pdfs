/*
AUFGABE 1
Aufstellung aller Vorführungen (Datum, Zeit, Film, Saal)
*/
SELECT v.datum, v.startzeit, s.name, f.titel FROM vorfuehrung v
JOIN film f
ON v.filmcode = f.filmcode
JOIN saal s
ON v.saal_nr= s.saal_nr;


/* AUFGABE 2
   Platzübersicht je Vorführung (freie, reservierte, verkaufte Plätze)
*/
### RESERVIERT
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'reserviert' as status FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is not null;
### VERKAUFT
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'verkauft' as status FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is null;

### RESERVIERT und VERKAUFT
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'reserviert' as status, s.platz_id FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is not null
UNION
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'verkauft' as status, s.platz_id FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is null;

### FREIE SITZPLÄTZE

SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'frei' as status FROM vorfuehrung v
JOIN saal
ON v.saal_nr=saal.saal_nr
JOIN sitzplatz s
ON s.saal_nr = saal.saal_nr
WHERE s.platz_id NOT IN
      (SELECT s.platz_id FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is not null
UNION
SELECT s.platz_id FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is null
    );

### FREIE, RESERVIERTE und VERKAUFTE PLÄTZE
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'reserviert' as status FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is not null
UNION
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'verkauft' as status FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is null
UNION
SELECT v.datum, v.filmcode, s.nummer_in_reihe, s.reihennummer, 'frei' as status FROM vorfuehrung v
JOIN saal
ON v.saal_nr=saal.saal_nr
JOIN sitzplatz s
ON s.saal_nr = saal.saal_nr
WHERE s.platz_id NOT IN
      (SELECT s.platz_id FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is not null
UNION
SELECT s.platz_id FROM karte k
JOIN sitzplatz s
ON k.karten_id = s.platz_id
JOIN vorfuehrung v
ON k.vorfuehrungs_id=v.vorfuehrungs_id
WHERE k.reservierungs_id is null
    );

/*
 AUFGABE 3
 Anzahl der Verkäufe für einen bestimmten Zeitraum
 */
SELECT * FROM karte;
#wir haben noch kein VErkaufsdatum
ALTER TABLE karte ADD verkaufsdatum date;
UPDATE karte set verkaufsdatum= now() WHERE karte.verkaufsdatum is null;

SELECT v.name, verkaufsdatum, count(karten_id) AS 'Verkaufte Karten' FROM karte k
JOIN verkaeufer v
ON k.verkaeufer_svnr = v.verkaeufer_svnr
WHERE k.verkaufsdatum< '2020-11-26'
GROUP BY k.verkaeufer_svnr;

/*
 Zusatzaufgaben
*/

### AUFGABE 1: Wie oft wurde ein bestimmter Kinofilm gespielt?
SELECT * FROM vorfuehrung;
SELECT count(*) FROM vorfuehrung;

select f.titel, count(v.filmcode) as Anzahl FROM vorfuehrung v
JOIN film f
on v.filmcode = f.filmcode
WHERE f.filmcode='KOE0120'
GROUP BY v.filmcode;

### Aufgabe 2: Verfasse ein SQL Statement, das alle abgelaufenen Reservierungen aus dem System löscht

### ZUERST FOREIGN KEY ANPASSEN, DAMIT KIND TABELLE MIT GELÖSCHT WIRD:
SHOW CREATE TABLE karte;
ALTER TABLE karte DROP FOREIGN KEY karte_ibfk_5;
ALTER TABLE karte ADD FOREIGN KEY (reservierungs_id) REFERENCES reservierung(reservierungs_id) ON DELETE CASCADE;

### DANN DELETE STATEMENT
DELETE FROM reservierung
WHERE reservierungs_id IN (SELECT k.reservierungs_id FROM karte k
JOIN vorfuehrung v
ON k.vorfuehrungs_id = v.vorfuehrungs_id
WHERE v.datum < now()) ;

/*
AUFGABE 3: Liste wie viele verkauften Karten es pro Film gibt (Hitlist)
 */
SELECT * FROM karte;
SELECT * FROM vorfuehrung;
SELECT count(karten_id), f.titel FROM karte k
JOIN vorfuehrung v
ON v.vorfuehrungs_id = k.vorfuehrungs_id
JOIN film f
ON v.filmcode= f.filmcode
WHERE reservierungs_id IS NULL
GROUP BY f.titel;




### PROBLEME
