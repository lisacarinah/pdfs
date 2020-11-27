-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 27. Nov 2020 um 10:55
-- Server-Version: 10.4.14-MariaDB
-- PHP-Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `kino`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `film`
--

CREATE TABLE `film` (
  `filmcode` varchar(30) NOT NULL,
  `dauer` time DEFAULT NULL,
  `fsk` int(11) DEFAULT NULL,
  `titel` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `film`
--

INSERT INTO `film` (`filmcode`, `dauer`, `fsk`, `titel`) VALUES
('GRE112020', '02:05:00', 11, 'Greenland'),
('KOE0120', '01:45:00', 0, 'König der Löwen');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `gutschein`
--

CREATE TABLE `gutschein` (
  `gutschein_id` int(11) NOT NULL,
  `gueltigkeit` date DEFAULT NULL,
  `verkaeufer_svnr` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `karte`
--

CREATE TABLE `karte` (
  `karten_id` int(11) NOT NULL,
  `reservierungs_id` int(11) DEFAULT NULL,
  `platz_id` int(11) DEFAULT NULL,
  `verkaeufer_svnr` int(11) DEFAULT NULL,
  `vorfuehrungs_id` int(11) DEFAULT NULL,
  `verkaufsdatum` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `karte`
--

INSERT INTO `karte` (`karten_id`, `reservierungs_id`, `platz_id`, `verkaeufer_svnr`, `vorfuehrungs_id`, `verkaufsdatum`) VALUES
(1, NULL, 1, 4345324, 1, '2020-11-20'),
(2, NULL, 1, 35135324, 2, '2020-11-20'),
(4, NULL, 2, 43409324, 5, '2020-11-27'),
(5, NULL, 2, 43409324, 5, '2020-11-27');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kartenabreisser`
--

CREATE TABLE `kartenabreisser` (
  `kartenabreisser_svnr` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kartenabreisser`
--

INSERT INTO `kartenabreisser` (`kartenabreisser_svnr`, `name`) VALUES
(12345, 'Hans'),
(12346, 'Eva'),
(12347, 'Martina'),
(12348, 'Klaus');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservierung`
--

CREATE TABLE `reservierung` (
  `reservierungs_id` int(11) NOT NULL,
  `kundenname` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `saal`
--

CREATE TABLE `saal` (
  `saal_nr` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `saal`
--

INSERT INTO `saal` (`saal_nr`, `name`) VALUES
(1, 'Dolby'),
(2, 'kleiner Saal'),
(3, 'großer Saal');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `sitzplatz`
--

CREATE TABLE `sitzplatz` (
  `platz_id` int(11) NOT NULL,
  `nummer_in_reihe` int(11) DEFAULT NULL,
  `reihennummer` int(11) DEFAULT NULL,
  `saal_nr` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `sitzplatz`
--

INSERT INTO `sitzplatz` (`platz_id`, `nummer_in_reihe`, `reihennummer`, `saal_nr`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 3, 1, 1),
(4, 4, 1, 1),
(5, 5, 1, 1),
(6, 6, 1, 1),
(7, 7, 1, 1),
(8, 8, 1, 1),
(9, 1, 1, 2),
(10, 2, 1, 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `verkaeufer`
--

CREATE TABLE `verkaeufer` (
  `verkaeufer_svnr` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `verkaeufer`
--

INSERT INTO `verkaeufer` (`verkaeufer_svnr`, `name`) VALUES
(4345324, 'Sonja'),
(35135324, 'Lucas'),
(43409324, 'David');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `vorfuehrung`
--

CREATE TABLE `vorfuehrung` (
  `vorfuehrungs_id` int(11) NOT NULL,
  `startzeit` time DEFAULT NULL,
  `endzeit` time DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `saal_nr` int(11) DEFAULT NULL,
  `filmcode` varchar(30) NOT NULL,
  `kartenabreisser_svnr` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `vorfuehrung`
--

INSERT INTO `vorfuehrung` (`vorfuehrungs_id`, `startzeit`, `endzeit`, `datum`, `saal_nr`, `filmcode`, `kartenabreisser_svnr`) VALUES
(1, '20:15:00', '22:00:00', '2020-11-20', 1, 'KOE0120', 12345),
(2, '20:00:00', '21:00:00', '2020-11-20', 2, 'KOE0120', 12345),
(5, '19:15:00', '21:00:00', '2020-12-01', 1, 'GRE112020', 12345);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`filmcode`);

--
-- Indizes für die Tabelle `gutschein`
--
ALTER TABLE `gutschein`
  ADD PRIMARY KEY (`gutschein_id`),
  ADD KEY `verkaeufer_svnr` (`verkaeufer_svnr`);

--
-- Indizes für die Tabelle `karte`
--
ALTER TABLE `karte`
  ADD PRIMARY KEY (`karten_id`),
  ADD KEY `platz_id` (`platz_id`),
  ADD KEY `verkaeufer_svnr` (`verkaeufer_svnr`),
  ADD KEY `vorfuehrungs_id` (`vorfuehrungs_id`),
  ADD KEY `reservierungs_id` (`reservierungs_id`);

--
-- Indizes für die Tabelle `kartenabreisser`
--
ALTER TABLE `kartenabreisser`
  ADD PRIMARY KEY (`kartenabreisser_svnr`);

--
-- Indizes für die Tabelle `reservierung`
--
ALTER TABLE `reservierung`
  ADD PRIMARY KEY (`reservierungs_id`);

--
-- Indizes für die Tabelle `saal`
--
ALTER TABLE `saal`
  ADD PRIMARY KEY (`saal_nr`);

--
-- Indizes für die Tabelle `sitzplatz`
--
ALTER TABLE `sitzplatz`
  ADD PRIMARY KEY (`platz_id`),
  ADD KEY `saal_nr` (`saal_nr`);

--
-- Indizes für die Tabelle `verkaeufer`
--
ALTER TABLE `verkaeufer`
  ADD PRIMARY KEY (`verkaeufer_svnr`);

--
-- Indizes für die Tabelle `vorfuehrung`
--
ALTER TABLE `vorfuehrung`
  ADD PRIMARY KEY (`vorfuehrungs_id`),
  ADD KEY `saal_nr` (`saal_nr`),
  ADD KEY `filmcode` (`filmcode`),
  ADD KEY `kartenabreisser_svnr` (`kartenabreisser_svnr`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `gutschein`
--
ALTER TABLE `gutschein`
  MODIFY `gutschein_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `karte`
--
ALTER TABLE `karte`
  MODIFY `karten_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT für Tabelle `reservierung`
--
ALTER TABLE `reservierung`
  MODIFY `reservierungs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `vorfuehrung`
--
ALTER TABLE `vorfuehrung`
  MODIFY `vorfuehrungs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `gutschein`
--
ALTER TABLE `gutschein`
  ADD CONSTRAINT `gutschein_ibfk_1` FOREIGN KEY (`verkaeufer_svnr`) REFERENCES `verkaeufer` (`verkaeufer_svnr`);

--
-- Constraints der Tabelle `karte`
--
ALTER TABLE `karte`
  ADD CONSTRAINT `karte_ibfk_2` FOREIGN KEY (`platz_id`) REFERENCES `sitzplatz` (`platz_id`),
  ADD CONSTRAINT `karte_ibfk_3` FOREIGN KEY (`verkaeufer_svnr`) REFERENCES `verkaeufer` (`verkaeufer_svnr`),
  ADD CONSTRAINT `karte_ibfk_4` FOREIGN KEY (`vorfuehrungs_id`) REFERENCES `vorfuehrung` (`vorfuehrungs_id`),
  ADD CONSTRAINT `karte_ibfk_5` FOREIGN KEY (`reservierungs_id`) REFERENCES `reservierung` (`reservierungs_id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `sitzplatz`
--
ALTER TABLE `sitzplatz`
  ADD CONSTRAINT `sitzplatz_ibfk_1` FOREIGN KEY (`saal_nr`) REFERENCES `saal` (`saal_nr`);

--
-- Constraints der Tabelle `vorfuehrung`
--
ALTER TABLE `vorfuehrung`
  ADD CONSTRAINT `vorfuehrung_ibfk_1` FOREIGN KEY (`saal_nr`) REFERENCES `saal` (`saal_nr`),
  ADD CONSTRAINT `vorfuehrung_ibfk_2` FOREIGN KEY (`filmcode`) REFERENCES `film` (`filmcode`),
  ADD CONSTRAINT `vorfuehrung_ibfk_3` FOREIGN KEY (`kartenabreisser_svnr`) REFERENCES `kartenabreisser` (`kartenabreisser_svnr`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
