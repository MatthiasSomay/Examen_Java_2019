CREATE TABLE `Locatie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `lengte` double NOT NULL,
  `breedte` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Actor` (
  `actorID` int(11) NOT NULL AUTO_INCREMENT,
  `locatieID` int(11) NOT NULL,
  PRIMARY KEY (`actorID`),
  KEY `Actor_Locatie_FK` (`locatieID`),
  CONSTRAINT `Actor_Locatie_FK` FOREIGN KEY (`locatieID`) REFERENCES `locatie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Verkeerstoren` (
  `verkeerstorenID` int(11) NOT NULL AUTO_INCREMENT,
  `actorID` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`verkeerstorenID`),
  KEY `Verkeerstoren_Actor_FK` (`actorID`),
  CONSTRAINT `Verkeerstoren_Actor_FK` FOREIGN KEY (`actorID`) REFERENCES `actor` (`actorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Vervoermiddel` (
  `vervoermiddelID` int(11) NOT NULL AUTO_INCREMENT,
  `actorID` int(11) NOT NULL,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`vervoermiddelID`),
  KEY `Vervoermiddel_Actor_FK` (`actorID`),
  CONSTRAINT `Vervoermiddel_Actor_FK` FOREIGN KEY (`actorID`) REFERENCES `actor` (`actorID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Schip` (
  `schipID` int(11) NOT NULL AUTO_INCREMENT,
  `vervoermiddelID` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`schipID`),
  KEY `Schip_Vervoermiddel_FK` (`vervoermiddelID`),
  CONSTRAINT `Schip_Vervoermiddel_FK` FOREIGN KEY (`vervoermiddelID`) REFERENCES `vervoermiddel` (`vervoermiddelid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Hulpdienst` (
  `hulpdienstID` int(11) NOT NULL AUTO_INCREMENT,
  `vervoermiddelID` int(11) NOT NULL,
  PRIMARY KEY (`hulpdienstID`),
  KEY `Hulpdienst_Vervoermiddel_FK` (`vervoermiddelID`),
  CONSTRAINT `Hulpdienst_Vervoermiddel_FK` FOREIGN KEY (`vervoermiddelID`) REFERENCES `vervoermiddel` (`vervoermiddelid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `HulpdienstenVerkeerstoren` (
  `verkeerstorenID` int(11) NOT NULL,
  `hulpdienstID` int(11) NOT NULL,
  KEY `HulpdienstenVerkeerstoren_Hulpdienst_FK` (`hulpdienstID`),
  KEY `HulpdienstenVerkeerstoren_Verkeerstoren_FK` (`verkeerstorenID`),
  CONSTRAINT `HulpdienstenVerkeerstoren_Hulpdienst_FK` FOREIGN KEY (`hulpdienstID`) REFERENCES `hulpdienst` (`hulpdienstid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `HulpdienstenVerkeerstoren_Verkeerstoren_FK` FOREIGN KEY (`verkeerstorenID`) REFERENCES `verkeerstoren` (`verkeerstorenid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `GeregistreerdeSchepenVerkeerstoren` (
  `verkeerstorenID` int(11) NOT NULL,
  `schipID` int(11) NOT NULL,
  KEY `GeregistreerdeSchepenVerkeerstoren_Verkeerstoren_FK` (`verkeerstorenID`),
  KEY `GeregistreerdeSchepenVerkeerstoren_Schip_FK` (`schipID`),
  CONSTRAINT `GeregistreerdeSchepenVerkeerstoren_Schip_FK` FOREIGN KEY (`schipID`) REFERENCES `schip` (`schipid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `GeregistreerdeSchepenVerkeerstoren_Verkeerstoren_FK` FOREIGN KEY (`verkeerstorenID`) REFERENCES `verkeerstoren` (`verkeerstorenid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
