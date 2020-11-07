
CREATE DATABASE leichtathletik_martina;
# ion MY SQL ist das Schema das gleiche wie eine Datenbank
# So würde man ein Shema erzeugen:
# CREATE SCHEMA leichtathletik;

USE leichtathletik_martina;

# Tabellen ohne Foreignkeys zuerst
# Vorsicht bei auto_increment - zuerst überlegen und nicht später hinzufügen
CREATE TABLE austragungsort (
    austragungsort_id int auto_increment NOT NULL, -- PK
    stadt varchar(30),
    plz int NOT NULL,
    adresse varchar(30),
    PRIMARY KEY (austragungsort_id)
);

# Mit DESCRIBE kann ich mir ansehen, welche Columns meine Tabelle hat und wie diese definiert sind.
DESCRIBE austragungsort;

# da nun die Tabelle angelegt ist, auf die die veranstaltungstabelle verweist, kann ich nun diese anlegen und den ForeignKey erstellen
CREATE TABLE veranstaltung (
    veranstaltungs_id int auto_increment NOT NULL, -- PK
    disziplin varchar(30),
    zeitpunkt date NOT NULL,
    austragungsort_id int NOT NULL, -- FK
    PRIMARY KEY (veranstaltungs_id),
    FOREIGN KEY (austragungsort_id) REFERENCES austragungsort (austragungsort_id)
);

DESCRIBE veranstaltung;

# Mit SHOW CREATE TABLE erhalte ich die information wie die Tabelle erstellt wurde
SHOW CREATE TABLE veranstaltung;

CREATE TABLE athlet (
    athlet_id int auto_increment NOT NULL , -- PK
    teilnehmernummer int NOT NULL,
    name varchar(30),
    nation varchar(30),
    PRIMARY KEY (athlet_id)
);

CREATE TABLE ergebnis (
    ergebnis_id int NOT NULL, -- PK
    rang int NOT NULL,
    wert int NOT NULL,
    athlet_id int NOT NULL, -- FK
    veranstaltungs_id int NOT NULL, -- FK
    PRIMARY KEY (ergebnis_id),
    FOREIGN KEY (athlet_id) REFERENCES athlet(athlet_id),
    FOREIGN KEY (veranstaltungs_id) REFERENCES veranstaltung(veranstaltungs_id)
);

#Beim Erstellen kann man immer wieder die tables droppen und wieder neu erzeugen, da noch keine Inhalte in den Tabellen sind
# Das funktioniert so:
# DROP TABLE ergebnis;

CREATE TABLE helfer (
    helfer_id int auto_increment NOT NULL , -- PK
    name varchar(30),
    art varchar(30),
    PRIMARY KEY (helfer_id)
);

# Hier ist die Kreuztabelle mit einem zusammengesetzten Primary Key
CREATE TABLE helferveranstaltungsliste (
    helfer_id int NOT NULL, -- PK & FK
    veranstaltungs_id int NOT NULL, -- PK & FK
    PRIMARY KEY (helfer_id, veranstaltungs_id),
    FOREIGN KEY (helfer_id) REFERENCES helfer (helfer_id),
    FOREIGN KEY (veranstaltungs_id) REFERENCES veranstaltung(veranstaltungs_id))
;

# So kann ich eine Datenbank löschen
DROP DATABASE leichtathletik;

# Veranstalungsorte anlegen
# Step 1 mit DESCRIBE schauen was ich angeben muss
DESCRIBE austragungsort;
# Step 2 INSERT INTO formulieren (die colums mit auto_increment brauche ich nicht händisch befüllen und kann ich weg lassen)
INSERT INTO austragungsort (stadt, plz, adresse) VALUES ('Linz', '4020', 'Stadionstraße 1'), ('Wien', '1010', 'Olympiaplatz 1');
# STEP 3 mit einem SELECT überprüfen was eingefügt wurde
SELECT * FROM austragungsort;

# Veranstaltungen erzeugen (wieder die 3 Steps) Wichtig: hier haben wir einen Fremdkey und wir müssen die IDs einfügen die in der anderen Tabelle erzeugt wurden.
DESCRIBE veranstaltung;
INSERT INTO veranstaltung(disziplin, zeitpunkt, austragungsort_id) VALUES ('100-Meter-Lauf', '2020-12-01', 1);
INSERT INTO veranstaltung(disziplin, zeitpunkt, austragungsort_id) VALUES ('100-Meter-Lauf', '2020-12-30', 2);
SELECT * FROM veranstaltung;

# Um sicherzugehen, dass die Disziplin immer gleich geschrieben wird, können wir eine eigene Tabelle dafür anlegen:
CREATE TABLE disziplin (
    disziplin varchar(30) NOT NULL,
    primary key (disziplin)
);

INSERT INTO disziplin (disziplin) VALUES ('100-Meter-Lauf'), ('150-Meter-Lauf'), ('Weitspringen');

#Da wir schon werte in der tabelle haben setzen wir, diese zuerst auf NULL damit wir dann die Fremdschlüsselzuweigung machen können.
#Wir testen unser WHERE Statement
SELECT * FROM veranstaltung
WHERE disziplin LIKE '%100%Meter%';
#und setzen dann die Werte auf NULL
UPDATE veranstaltung
SET disziplin = NULL
WHERE disziplin LIKE '%100%Meter%';

SELECT * FROM veranstaltung;
SELECT * FROM disziplin;

#Nun weisen wir den Fremdschlüssel zu
ALTER TABLE veranstaltung ADD FOREIGN KEY (disziplin) REFERENCES disziplin(disziplin);

#Da wir nur Einträge vom 100-Meter-Lauf hatten, weisen allen veranstaltungen den 100-Meter-Lauf zu
UPDATE veranstaltung
SET disziplin = '100-Meter-Lauf';

# ANFORDERTUNGEN AN UNSER SYSTEM
# ES soll ein Webformular geben, womit sich die Athleten zu einer Veranstaltung anmelden können
# Wir sehen dabei das erste Problem: der Athlet ist nur über das Ergebnis mit der Veranstaltung verbunden.
# Damit sich die Athleten ohne bereits ein Ergebnis zu haben, zu einer Veranstaltung anmelden können, 
# müssen wir eine direkte Beziehung von Athlet zur Verantaltung erstellen. Da es sich hierbei um eine 
# N zu M Beziehung handelt, müssen wir eine Krezztabelle erzeugen.
# Die Teilnehmernummer ist abhängig vom Athleten und der Veranstaltung und wird so zur Kreuztabelle hinzugefügt: 

CREATE TABLE veranstaltungs_athleten_liste (
    athlet_id int NOT NULL,
    veranstaltungs_id int NOT NULL,
    teilnehmernummer int,
    PRIMARY KEY (athlet_id,veranstaltungs_id),
    FOREIGN KEY (athlet_id) REFERENCES athlet(athlet_id),
    FOREIGN KEY (veranstaltungs_id) REFERENCES veranstaltung(veranstaltungs_id)
);

#Die Teilnehmernummer vom Athleten können wir nun löschen
ALTER TABLE athlet DROP COLUMN teilnehmernummer;

#Um später ein Dropdown Menü für unsere Nationen erstellen zu können, legen wir eine eigene Tabelle mit den Nationen an. 
CREATE TABLE nation (
    nation varchar(3),
    PRIMARY KEY (nation)
);

DESCRIBE nation;

#Nun fügen wir Werte ein
INSERT INTO nation (nation) VALUES ('AUT'), ('GER');
SELECT * FROM nation;

# In der Tabelle Athlet wird die Nation zum Fremdschlüssel und verweist auf die Tabelle Nation
ALTER TABLE athlet ADD FOREIGN KEY (nation) REFERENCES nation(nation);

# Nun fügen wir Athleten ein
INSERT INTO athlet (name, nation) VALUES ('Karl', 'AUT');
SELECT * FROM athlet;

# und lassen sie an einer Veranstaltung teilnehmen
INSERT INTO veranstaltungs_athleten_liste (athlet_id, veranstaltungs_id) VALUES ((SELECT MAX(athlet_id) FROM athlet),1); -- SELECT MAX, wurde hier nur gemacht um herauszufinden welche ID, die größte ist also als letztes eingefügt wurde
SELECT * FROM veranstaltungs_athleten_liste;

SHOW CREATE TABLE athlet;
# Wir können den Zähler von AUTO_INCREMENT auch umsetzen
ALTER TABLE athlet AUTO_INCREMENT = 100;

INSERT INTO athlet (name, nation) VALUES ('Max', 'GER');
INSERT INTO veranstaltungs_athleten_liste (athlet_id, veranstaltungs_id) VALUES (2,2), (2,1);

DELETE FROM athlet WHERE athlet_id = 3;

#Liste mit Name von Athlet und dem Namen der Veranstaltung + der Disziplin
#NAME ATHLET, DISZIPLIN, ZEITPUNKT
SELECT a.name, v.disziplin, v.zeitpunkt, o.stadt FROM athlet a
JOIN veranstaltungs_athleten_liste vl
ON a.athlet_id = vl.athlet_id
JOIN veranstaltung v
ON vl.veranstaltungs_id = v.veranstaltungs_id
JOIN austragungsort o
ON v.austragungsort_id= o.austragungsort_id;

# Um einen Eintrag zu löschen, setzen wir ein DELETE FROM Statement ab
# Was passiert aber nun mit dem Eintrag in der veranstaltungs_athleten_liste?
# Der sollte automatisch aus der Datenbank gelöscht werden, das passiert aber nicht
# um das zu ermöglichen müssen wir bei der FOREIGN KEY Zuweisung ON DELETE CASCADE setzen
DELETE FROM athlet WHERE athlet_id =1;
#DELETE FROM veranstaltungs_athleten_liste WHERE athlet_id=1; -- Dieses Statement soll zukünftig automatisch abgesetzt werden, wenn ich einen Athleten lsöche

#Wir löschen die alte Fremdschlüsselzuweisung und erzeugen sie neu mit ON DELETE CASCADE
ALTER TABLE veranstaltungs_athleten_liste DROP CONSTRAINT veranstaltungs_athleten_liste_ibfk_1;
ALTER TABLE veranstaltungs_athleten_liste ADD FOREIGN KEY (athlet_id) REFERENCES athlet(athlet_id) ON DELETE CASCADE;

# Das gleiche machen wir bei der Veranstaltung
ALTER TABLE veranstaltungs_athleten_liste DROP CONSTRAINT veranstaltungs_athleten_liste_ibfk_2;
ALTER TABLE veranstaltungs_athleten_liste ADD FOREIGN KEY (veranstaltungs_id) REFERENCES veranstaltung(veranstaltungs_id) ON DELETE CASCADE;

# Nun soll es auch ein Formular geben, womit sich ein Helfer anmelden kann
DESCRIBE helfer;
DESCRIBE helferveranstaltungsliste;

# Der Helfertyp soll in der Kreuztabelle abgespeichert werden, denn ein Helfer kann bei einer Veranstaltung ein Schiedrichter sein und in der anderen ein Ordner
ALTER TABLE helferveranstaltungsliste ADD COLUMN typ varchar(30);

#Wir enscheiden uns dafür, dass wir die Helfertypen in einer eigenen Tabelle speichern
CREATE TABLE helfertyp (
    typ varchar(30),
    PRIMARY KEY (typ)
);

# Wenn nun ein solcher Typ gelöscht wird, haben wir uns dafür entschieden, dass der Helfertyp von den Helfern auf NULL gesetzt wird.
ALTER TABLE helferveranstaltungsliste ADD FOREIGN KEY (typ) REFERENCES helfertyp(typ) ON DELETE SET NULL;
#ALTER TABLE helferveranstaltungsliste DROP CONSTRAINT helferveranstaltungsliste_ibfk_3;

# in der Helfertabelle brauchen wir nun die Spalte art nicht mehr.
ALTER TABLE helfer DROP COLUMN art;

# Wir fügen Helfer ein
INSERT INTO  helfer (name) VALUES ('Klaus'), ('Peter'), ('David'), ('Susanne');
SELECT * FROM helfer;

# Wir fügen Helfertypen ein
INSERT INTO helfertyp (typ) VALUES ('Schiedsrichter'), ('Ordner');
SELECT * From helfertyp;

describe helferveranstaltungsliste;

#Wir fügen die Helfer mit dem entsprechenden Typen zur Veranstaltung hinzu
INSERT INTO helferveranstaltungsliste(helfer_id, veranstaltungs_id, typ) VALUES (1,1,'Schiedsrichter');
INSERT INTO helferveranstaltungsliste(helfer_id, veranstaltungs_id, typ) VALUES (2,1, 'Ordner');


