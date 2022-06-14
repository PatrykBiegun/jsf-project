-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 11 Lut 2022, 15:28
-- Wersja serwera: 10.4.19-MariaDB
-- Wersja PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `jezioro`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategorie`
--

CREATE TABLE `kategorie` (
  `ID_Kategorii` int(11) NOT NULL,
  `nazwa` varchar(45) DEFAULT NULL,
  `opis` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `kategorie`
--

INSERT INTO `kategorie` (`ID_Kategorii`, `nazwa`, `opis`) VALUES
(1, 'wędka', 'Sprzet słuzacy do połowu ryb w wedkarstwie'),
(2, 'łódka', 'mała jednostka pływająca (statek wodny)'),
(3, 'wiadro', 'stalowe wiadro z przykrywką (dobre to trzymania ryb)'),
(4, 'zanęta', 'różnego rodzaju robaki i suche zanęty na ryby'),
(5, 'krzesło', 'Krzesło wędkarskie (waga do 120kg)');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ryby`
--

CREATE TABLE `ryby` (
  `ID_Ryby` int(11) NOT NULL,
  `Nazwa_ryby` varchar(45) NOT NULL,
  `nr_stawu` int(11) NOT NULL,
  `cena_za_kilogram` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `ryby`
--

INSERT INTO `ryby` (`ID_Ryby`, `Nazwa_ryby`, `nr_stawu`, `cena_za_kilogram`) VALUES
(39, 'Sum', 2, 32),
(40, 'Karaś', 2, 21),
(41, 'Sandacz', 1, 31),
(42, 'Leszcz', 2, 31),
(43, 'Leszcz', 0, 15),
(44, 'Kleń', 2, 18),
(45, 'Sandacz', 2, 33),
(46, 'Brzana', 0, 25),
(47, 'Karp', 0, 22),
(48, 'Lin', 1, 30),
(49, 'Sum', 2, 32),
(50, 'Karaś', 2, 21),
(51, 'Sandacz', 1, 31),
(52, 'Leszcz', 2, 31),
(53, 'Leszcz', 0, 15),
(54, 'Kleń', 2, 18),
(55, 'Sandacz', 2, 33),
(57, 'Karp', 0, 22),
(58, 'Lin', 1, 30),
(59, 'Sum', 2, 32),
(60, 'Karaś', 2, 21),
(61, 'Sandacz', 1, 31),
(62, 'Leszcz', 2, 31),
(63, 'Leszcz', 0, 15),
(64, 'Kleń', 2, 18),
(65, 'Sandacz', 2, 33),
(66, 'Brzana', 1, 25),
(67, 'Karp', 0, 22),
(68, 'Lin', 1, 30),
(69, 'Sum', 2, 32),
(70, 'Karaś', 2, 21),
(71, 'Sandacz', 1, 31),
(72, 'Leszcz', 2, 31),
(73, 'Leszcz', 0, 15),
(74, 'Kleń', 2, 18),
(75, 'Sandacz', 2, 33),
(77, 'Karp', 0, 22),
(78, 'Lin', 1, 30),
(79, 'Sum', 2, 32),
(80, 'Karaś', 2, 21),
(81, 'Sandacz', 1, 31),
(82, 'Leszcz', 2, 31),
(83, 'Leszcz', 0, 15),
(84, 'Kleń', 2, 18),
(85, 'Sandacz', 2, 33),
(86, 'Brzana', 1, 25),
(87, 'Karp', 0, 22),
(88, 'sum', 1, 20),
(89, 'sum', 1, 20),
(90, 'Abba', 1, 12);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sprzet`
--

CREATE TABLE `sprzet` (
  `id_sprzetu` int(11) NOT NULL,
  `nazwa_sprzetu` varchar(60) NOT NULL,
  `cena` int(45) NOT NULL,
  `uzytkownicy_ID` int(11) DEFAULT NULL,
  `kategorie_ID_Kategorii` int(11) NOT NULL,
  `czy_wypozyczono` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `sprzet`
--

INSERT INTO `sprzet` (`id_sprzetu`, `nazwa_sprzetu`, `cena`, `uzytkownicy_ID`, `kategorie_ID_Kategorii`, `czy_wypozyczono`) VALUES
(1, 'Okuma Magnetic Telepole 400', 79, NULL, 1, 0),
(2, 'Okuma Magnetic Telepole 400', 79, 21, 1, 1),
(3, 'Okuma Magnetic Telepole 400', 79, 21, 1, 1),
(4, 'Okuma Magnetic Telepole 400', 79, 21, 1, 1),
(5, 'Okuma Magnetic Telepole 400', 79, NULL, 1, 0),
(6, 'Shimano Wędka Vengeance CX Spinning', 149, NULL, 1, 0),
(7, 'Shimano Wędka Vengeance CX Spinning', 149, NULL, 1, 1),
(8, 'Shimano Wędka Vengeance CX Spinning', 149, NULL, 1, 0),
(9, 'Shimano Wędka Vengeance CX Spinning', 149, NULL, 1, 0),
(10, 'Shimano Wędka Vengeance CX Spinning', 149, NULL, 1, 0),
(11, 'Prologic C.O.M. Raw 8', 219, NULL, 1, 0),
(12, 'Prologic C.O.M. Raw 8', 219, 21, 1, 1),
(13, 'Prologic C.O.M. Raw 8', 219, NULL, 1, 0),
(14, 'Prologic C.O.M. Raw 8', 219, NULL, 1, 0),
(15, 'Prologic C.O.M. Raw 8', 219, NULL, 1, 0),
(16, 'wędka mistrall stratus method', 50, NULL, 1, 0),
(17, 'wędka mistrall stratus method', 50, NULL, 1, 0),
(18, 'wędka mistrall stratus method', 50, NULL, 1, 0),
(19, 'wędka mistrall stratus method', 50, NULL, 1, 0),
(20, 'wędka mistrall stratus method', 50, NULL, 1, 0),
(21, 'Łódka drewniana z wiosłami', 140, NULL, 2, 0),
(22, 'Łódka drewniana z wiosłami', 140, NULL, 2, 0),
(23, 'Łódka drewniana z wiosłami', 140, NULL, 2, 0),
(24, 'Łódka drewniana z wiosłami', 140, NULL, 2, 0),
(25, 'Łódka drewniana z wiosłami', 140, NULL, 2, 0),
(26, 'wiadro stalowe', 15, NULL, 3, 0),
(27, 'wiadro stalowe', 15, NULL, 3, 0),
(28, 'wiadro stalowe', 15, NULL, 3, 0),
(29, 'wiadro stalowe', 15, NULL, 3, 0),
(30, 'wiadro stalowe', 15, NULL, 3, 0),
(31, 'wiadro stalowe', 15, NULL, 3, 0),
(32, 'wiadro stalowe', 15, NULL, 3, 0),
(33, 'wiadro stalowe', 15, NULL, 3, 0),
(34, 'wiadro stalowe', 15, NULL, 3, 0),
(35, 'wiadro stalowe', 15, NULL, 3, 0),
(36, 'wiadro stalowe', 15, NULL, 3, 0),
(37, 'wiadro stalowe', 15, NULL, 3, 0),
(38, 'wiadro stalowe', 15, NULL, 3, 0),
(39, 'wiadro stalowe', 15, NULL, 3, 0),
(40, 'wiadro stalowe', 15, NULL, 3, 0),
(41, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(42, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(43, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(44, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(45, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(46, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(47, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(48, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(49, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(50, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(51, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(52, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(53, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(54, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(55, 'wiadro stalowe', 15, NULL, 3, 0),
(56, 'wiadro stalowe', 15, NULL, 3, 0),
(57, 'wiadro stalowe', 15, NULL, 3, 0),
(58, 'wiadro stalowe', 15, NULL, 3, 0),
(59, 'wiadro stalowe', 15, NULL, 3, 0),
(60, 'wiadro stalowe', 15, NULL, 3, 0),
(61, 'zanęta organiczna (małe rybki) 20g', 6, NULL, 4, 0),
(62, 'wiadro stalowe', 15, NULL, 3, 0),
(63, 'wiadro stalowe', 15, NULL, 3, 0),
(64, 'wiadro stalowe', 15, NULL, 3, 0),
(65, 'wiadro stalowe', 15, NULL, 3, 0),
(66, 'wiadro stalowe', 15, NULL, 3, 0),
(67, 'wiadro stalowe', 15, NULL, 3, 0),
(68, 'zanęta nieorganiczna  15g', 4, NULL, 4, 0),
(69, 'zanęta nieorganiczna  15g', 4, NULL, 4, 0),
(70, 'zanęta nieorganiczna  15g', 4, NULL, 4, 0),
(71, 'zanęta nieorganiczna  15g', 4, NULL, 4, 0),
(72, 'zanęta nieorganiczna  15g', 4, NULL, 4, 0),
(73, 'zanęta nieorganiczna  15g', 4, NULL, 4, 0),
(74, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(75, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(76, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(77, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(78, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(79, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(80, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(81, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(82, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(83, 'krzesło wędkarskie taboret składane podręczne', 20, NULL, 5, 0),
(84, 'krzesło wędkarskie turystyczne fotel na ryby ', 30, NULL, 5, 0),
(85, 'krzesło wędkarskie turystyczne fotel na ryby duże', 30, NULL, 5, 0),
(86, 'krzesło wędkarskie turystyczne fotel na ryby duże', 30, NULL, 5, 0),
(87, 'krzesło wędkarskie turystyczne fotel na ryby duże', 30, NULL, 5, 0),
(88, 'krzesło wędkarskie turystyczne fotel na ryby duże', 30, NULL, 5, 0),
(89, 'krzesło wędkarskie turystyczne fotel na ryby duże', 30, NULL, 5, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `ID` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  `haslo` varchar(45) NOT NULL,
  `imie` varchar(45) NOT NULL,
  `nazwisko` varchar(45) NOT NULL,
  `pesel` varchar(45) NOT NULL,
  `data_Modyfiakcji` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `kiedy_dezaktywowana` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `kto_stworzyl` int(11) NOT NULL,
  `kto_modyfikowal` int(11) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `suma` int(11) DEFAULT NULL,
  `Rola` varchar(16) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`ID`, `login`, `haslo`, `imie`, `nazwisko`, `pesel`, `data_Modyfiakcji`, `kiedy_dezaktywowana`, `kto_stworzyl`, `kto_modyfikowal`, `Email`, `suma`, `Rola`) VALUES
(1, 'admin', 'YWRtaW4=', 'Patryke', 'Biegun', '12312312321', '2022-02-11 09:30:04', '2022-02-11 09:30:04', 1, 5, '', 0, 'system'),
(5, 'biegun', 'YmllZ3Vu', 'biegun', 'biegun', '12312312322', '2022-02-09 09:18:10', '2022-02-09 09:18:10', 1, NULL, '', 1047, 'admin'),
(19, 'system', 'system', 'system', 'system', 'system', '2022-02-08 21:12:51', '2022-02-08 21:12:51', 1, NULL, 'system', 1, 'admin'),
(20, 'eee', 'eee', 'tom', 'jerry', 'eee', '2022-02-09 11:48:01', '2022-02-09 11:48:01', 19, NULL, 'eee', 100, 'admin'),
(21, 'eeee', 's', 'eee', 'eee', 'eee', '2022-02-09 14:38:31', '2022-02-09 14:38:31', 19, NULL, 'eee', 398, 'admin'),
(22, 'eeee', 'eeeeeeeeeeeeeeeee', 'www', 'eee', '22222222222', NULL, NULL, 19, NULL, 'asews@gmail.com', 0, ''),
(24, 'wwwwww', 'wwwwwwwwwwwwwwwwww', 'eee', 'aaa', '22222222222', NULL, NULL, 19, NULL, 'ewwww@gmail.com', 0, 'uzytkownik'),
(25, 'eeeeee', 'wwqqqqqqqqqqqqqq', 'wss', 'sadsa', '22222222222', NULL, NULL, 19, NULL, 'ewwww@gmail.com', 0, 'uzytkownik'),
(26, 's', 'aasss', 's', 's', '22222222225', NULL, NULL, 19, NULL, 'assws@gmail.com', 0, 'uzytkownik');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `kategorie`
--
ALTER TABLE `kategorie`
  ADD PRIMARY KEY (`ID_Kategorii`);

--
-- Indeksy dla tabeli `ryby`
--
ALTER TABLE `ryby`
  ADD PRIMARY KEY (`ID_Ryby`);

--
-- Indeksy dla tabeli `sprzet`
--
ALTER TABLE `sprzet`
  ADD PRIMARY KEY (`id_sprzetu`),
  ADD KEY `fk_sprzęt_użytkownicy1_idx` (`uzytkownicy_ID`),
  ADD KEY `fk_sprzęt_kategorie1_idx` (`kategorie_ID_Kategorii`);

--
-- Indeksy dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_użytkownicy_użytkownicy1_idx` (`kto_stworzyl`),
  ADD KEY `fk_użytkownicy_użytkownicy2_idx` (`kto_modyfikowal`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `kategorie`
--
ALTER TABLE `kategorie`
  MODIFY `ID_Kategorii` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `ryby`
--
ALTER TABLE `ryby`
  MODIFY `ID_Ryby` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT dla tabeli `sprzet`
--
ALTER TABLE `sprzet`
  MODIFY `id_sprzetu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `sprzet`
--
ALTER TABLE `sprzet`
  ADD CONSTRAINT `fk_sprzęt_kategorie1` FOREIGN KEY (`kategorie_ID_Kategorii`) REFERENCES `kategorie` (`ID_Kategorii`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sprzęt_użytkownicy1` FOREIGN KEY (`uzytkownicy_ID`) REFERENCES `uzytkownicy` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD CONSTRAINT `fk_użytkownicy_użytkownicy1` FOREIGN KEY (`kto_stworzyl`) REFERENCES `uzytkownicy` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_użytkownicy_użytkownicy2` FOREIGN KEY (`kto_modyfikowal`) REFERENCES `uzytkownicy` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
