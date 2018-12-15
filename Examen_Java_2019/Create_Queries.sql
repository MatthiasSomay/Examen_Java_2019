CREATE TABLE `Cruiseship` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Cruiseship_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Cruiseship_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Cruiseship_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Cruiseship_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Luchthaven` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Luchthaven_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Seaking` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Seaking_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Seaking_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Seaking_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Seaking_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Speedboot` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Speedboot_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Speedboot_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Speedboot_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Speedboot_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Tanker` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Tanker_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Tanker_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Tanker_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Tanker_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Vrachtschip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Vrachtschip_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Vrachtschip_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Vrachtschip_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Vrachtschip_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Vuurtoren` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Vuurtoren_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Zeehaven` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Zeehaven_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Zeepolitie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Zeepolitie_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Zeepolitie_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Zeepolitie_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Zeepolitie_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Zeilboot` (
  `snelheid` double NOT NULL,
  `grootte` double NOT NULL,
  `wendbaarheid` double NOT NULL,
  `capaciteit` int(11) NOT NULL,
  `personenAanBoord` int(11) NOT NULL,
  `koers` double NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Zeilboot_Locatie_FK` FOREIGN KEY (`ID`) REFERENCES `locatie` (`id`),
  CONSTRAINT `Zeilboot_Luchthaven_FK` FOREIGN KEY (`ID`) REFERENCES `luchthaven` (`id`),
  CONSTRAINT `Zeilboot_Vuurtoren_FK` FOREIGN KEY (`ID`) REFERENCES `vuurtoren` (`id`),
  CONSTRAINT `Zeilboot_Zeehaven_FK` FOREIGN KEY (`ID`) REFERENCES `zeehaven` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Locatie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `lengte` double NOT NULL,
  `breedte` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
