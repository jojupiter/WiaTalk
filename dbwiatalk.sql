-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 28 jan. 2019 à 10:17
-- Version du serveur :  10.1.26-MariaDB
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `dbwiatalk`
--

-- --------------------------------------------------------

--
-- Structure de la table `msg`
--

CREATE database IF NOT EXISTS dbwiatalk;
use dbwiatalk;

CREATE TABLE `msg` (
  `id_msg` int(11) NOT NULL,
  `heure_envoi` varchar(11) NOT NULL,
  `emetteur` varchar(11) NOT NULL,
  `recepteur` varchar(11) NOT NULL,
  `text_msg` text NOT NULL,
  `discussion` varchar(20) NOT NULL,
  `accuse` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `msg`
--

INSERT INTO `msg` (`id_msg`, `heure_envoi`, `emetteur`, `recepteur`, `text_msg`, `discussion`, `accuse`) VALUES
(10000, '11', '78', '154', '454145', '55', 1),
(10001, 'invalid', 'merci', 'correta', 'hi', 'invalid', 0),
(10002, 'invalid', 'merci', 'correta', 'hi', 'invalid', 0),
(10003, 'invalid', 'correta', 'merci', 'hello', 'invalid', 0),
(10004, 'invalid', 'correta', 'mandeng', 'hi', 'invalid', 0),
(10005, 'invalid', 'correta', 'mandeng', 'hello', 'invalid', 0),
(10006, 'invalid', 'mandeng', 'correta', 'hi', 'invalid', 0),
(10007, 'invalid', 'mandeng', 'correta', 'hola', 'invalid', 0),
(10008, 'invalid', 'carole', 'correta', 'hi', 'invalid', 0),
(10009, 'invalid', 'carole', 'correta', 'Hello', 'invalid', 0),
(10010, 'invalid', 'correta', 'carole', 'hi', 'invalid', 0),
(10011, 'invalid', 'correta', 'carole', 'hello', 'invalid', 0),
(10012, 'invalid', 'carole', 'fofe', 'hi', 'invalid', 0),
(10013, 'invalid', 'carole', 'fofe', 'hi', 'invalid', 0),
(10014, 'invalid', 'carole', 'fofe', 'hi', 'invalid', 0),
(10015, 'invalid', 'carole', 'fofe', 'hi', 'invalid', 0),
(10016, 'invalid', 'fofe', 'aime', 'hi', 'invalid', 0),
(10017, 'invalid', 'fofe', 'aime', 'yo', 'invalid', 0),
(10018, 'invalid', 'fofe', 'aime', 'ho', 'invalid', 0),
(10019, 'invalid', 'aime', 'fofe', 'hola', 'invalid', 0),
(10020, 'invalid', 'aime', 'fofe', 'yo', 'invalid', 0),
(10021, 'invalid', 'fofe', 'aime', 'pppp', 'invalid', 0),
(10022, 'invalid', 'aime', 'fofe', 'koka', 'invalid', 0),
(10023, 'invalid', 'fofe', 'aime', 'serieux', 'invalid', 0),
(10024, 'invalid', 'fofe', 'aime', 'pop', 'invalid', 0),
(10025, 'invalid', 'aime', 'fofe', 'top', 'invalid', 0),
(10026, 'invalid', 'fofe', 'aime', 'marche', 'invalid', 0),
(10027, 'invalid', 'aime', 'fofe', 'marche', 'invalid', 0),
(10028, 'invalid', 'fofe', 'aime', 'voler', 'invalid', 0),
(10029, 'invalid', 'fofe', 'aime', 'kona', 'invalid', 0),
(10030, 'invalid', 'aime', 'fofe', 'popo', 'invalid', 0),
(10031, 'invalid', 'fofe', 'aime', 'pp', 'invalid', 0),
(10032, 'invalid', 'fofe', 'aime', 'op', 'invalid', 0),
(10033, 'invalid', 'aime', 'fofe', 'ui', 'invalid', 0),
(10034, 'invalid', 'aime', 'fofe', 'ui', 'invalid', 0),
(10035, 'invalid', 'aime', 'fofe', '????????????????dggbbbb', 'invalid', 0),
(10036, 'invalid', 'aime', 'fofe', 'fhnn????', 'invalid', 0),
(10037, 'invalid', 'aime', 'fofe', 'fhnn????', 'invalid', 0),
(10038, 'invalid', 'aime', 'fofe', 'fffff', 'invalid', 0),
(10039, 'invalid', 'aime', 'fofe', 'ffgghh????????', 'invalid', 0),
(10040, 'invalid', 'aime', 'fofe', 'ffffffff', 'invalid', 0),
(10041, 'invalid', 'fofe', 'aime', 'ttggggg', 'invalid', 0),
(10042, 'invalid', 'fofe', 'aime', 'ttggggg????????????', 'invalid', 0),
(10043, 'invalid', 'fofe', 'aime', 'ttggggg????????????', 'invalid', 0),
(10044, 'invalid', 'fofe', 'aime', 'xxxxxxfffffffffffffff????????????????????x', 'invalid', 0),
(10045, 'invalid', 'fofe', 'carole', 'wesff', 'invalid', 0),
(10046, 'invalid', 'aime', 'fofe', 'popp', 'invalid', 0),
(10047, 'invalid', 'aime', 'carole', 'ffgg', 'invalid', 0),
(10048, 'invalid', 'aime', 'carole', 'ttttt', 'invalid', 0),
(10049, 'invalid', 'aime', 'carole', 'eerff', 'invalid', 0),
(10050, 'invalid', 'aime', 'fofe', ',ddddf', 'invalid', 0),
(10051, 'invalid', 'aime', 'carole', 'ttuujjhh', 'invalid', 0),
(10052, 'invalid', 'aime', 'carole', 'ffffff', 'invalid', 0),
(10053, 'invalid', 'aime', 'carole', 'ggggggg', 'invalid', 0),
(10054, 'invalid', 'aime', 'carole', 'uuuu', 'invalid', 0),
(10055, 'invalid', 'aime', 'carole', 'tyuu', 'invalid', 0),
(10056, 'invalid', 'aime', 'carole', 'ttttt', 'invalid', 0),
(10057, 'invalid', 'aime', 'carole', 'ggggg', 'invalid', 0),
(10058, 'invalid', 'aime', 'carole', 'g', 'invalid', 0),
(10059, 'invalid', 'aime', 'carole', 'y', 'invalid', 0),
(10060, 'invalid', 'aime', 'carole', 't', 'invalid', 0),
(10061, 'invalid', 'aime', 'carole', 'u', 'invalid', 0),
(10062, 'invalid', 'sedou', 'aime', '????', 'invalid', 0),
(10063, 'invalid', 'sedou', 'aime', 'ddd', 'invalid', 0),
(10064, 'invalid', 'sedou', 'aime', 'hhh', 'invalid', 0),
(10065, 'invalid', 'sedou', 'aime', 'hh', 'invalid', 0),
(10066, 'invalid', 'sedou', 'aime', 'yyy', 'invalid', 0),
(10067, 'invalid', 'sedou', 'aime', 'hhh', 'invalid', 0),
(10068, 'invalid', 'sedou', 'aime', 'hhhhfff', 'invalid', 0),
(10069, 'invalid', 'sedou', 'aime', 'dddd', 'invalid', 0),
(10070, 'invalid', 'sedou', 'aime', 'cvvvvv', 'invalid', 0),
(10071, 'invalid', 'sedou', 'aime', 'vvv', 'invalid', 0),
(10072, 'invalid', 'sedou', 'aime', 'rrr', 'invalid', 0),
(10073, 'invalid', 'sedou', 'aime', 'dddd', 'invalid', 0),
(10074, 'invalid', 'sedou', 'aime', 'dfgggg', 'invalid', 0),
(10075, 'invalid', 'aime', 'sedou', 'er', 'invalid', 0),
(10076, 'invalid', 'sedou', 'aime', 'hi', 'invalid', 0),
(10077, 'invalid', 'sedou', 'aime', 'ggg', 'invalid', 0),
(10078, 'invalid', 'sedou', 'aime', 'pas', 'invalid', 0),
(10079, 'invalid', 'sedou', 'aime', 'y', 'invalid', 0),
(10080, 'invalid', 'sedou', 'aime', 'hi oooooo', 'invalid', 0),
(10081, 'invalid', 'sedou', 'aime', 'aime', 'invalid', 0),
(10082, 'invalid', 'sedou', 'aime', 'ffff', 'invalid', 0),
(10083, 'invalid', 'sedou', 'aime', 'ffff', 'invalid', 0),
(10084, 'invalid', 'aime', 'sedou', 'ddddd', 'invalid', 0),
(10085, 'invalid', 'aime', 'sedou', 'd', 'invalid', 0),
(10086, 'invalid', 'aime', 'sedou', 'op', 'invalid', 0),
(10087, 'invalid', 'sedou', 'aime', 'op', 'invalid', 0),
(10088, 'invalid', 'sedou', 'aime', 'hi', 'invalid', 0),
(10089, 'invalid', 'belporo', 'Cantor', 'tes noyaux', 'invalid', 0),
(10090, 'invalid', 'fotso', 'belporo', 'vbbb', 'invalid', 0),
(10091, 'invalid', 'fotso', 'belporo', 'le big belporo', 'invalid', 0),
(10092, 'invalid', 'Cantor', 'belporo', 'tes noyaux', 'invalid', 0),
(10093, 'invalid', 'fotso', 'belporo', 'bjr', 'invalid', 0),
(10094, 'invalid', 'belporo', 'Cantor', 'ho', 'invalid', 0),
(10095, 'invalid', 'Cantor', 'belporo', 'tes noyaux ', 'invalid', 0),
(10096, 'invalid', 'belporo', 'fotso', 'tes noyaux', 'invalid', 0),
(10097, 'invalid', 'choplefac', 'belporo', 'ho', 'invalid', 0),
(10098, 'invalid', 'fotso', 'Cantor', ' cantor', 'invalid', 0),
(10099, 'invalid', 'fotso', 'belporo', ' pefit frere tu dem. ?? ', 'invalid', 0),
(10100, 'invalid', 'belporo', 'fotso', 'yes', 'invalid', 0),
(10101, 'invalid', 'fotso', 'belporo', ' mon petit calme toi', 'invalid', 0),
(10102, 'invalid', 'belporo', 'Cantor', 'cantor', 'invalid', 0),
(10103, 'invalid', 'Cantor', 'belporo', 'oui', 'invalid', 0),
(10104, 'invalid', 'Cantor', 'belporo', 'tu dis quoi?', 'invalid', 0),
(10105, 'invalid', 'belporo', 'Cantor', 'blabla', 'invalid', 0),
(10106, 'invalid', 'Ss', 'fotso', 'bjr fotso', 'invalid', 0),
(10107, 'invalid', 'Cantor', 'belporo', 'ohoh', 'invalid', 0),
(10108, 'invalid', 'belporo', 'Cantor', 'haha', 'invalid', 0),
(10109, 'invalid', 'fotso', 'Cantor', 'bjr ss', 'invalid', 0),
(10110, 'invalid', 'Ss', 'fotso', 'hvc', 'invalid', 0),
(10111, 'invalid', 'fotso', 'Ss', 'bjr ss', 'invalid', 0),
(10112, 'invalid', 'Ss', 'fotso', '????????', 'invalid', 0),
(10113, 'invalid', 'Cantor', 'belporo', 'ohoh', 'invalid', 0),
(10114, 'invalid', 'belporo', 'Cantor', 'blabla', 'invalid', 0),
(10115, 'invalid', 'belporo', 'fotso', 'haha', 'invalid', 0),
(10116, 'invalid', 'Ss', 'fotso', 'wiatalk', 'invalid', 0),
(10117, 'invalid', 'belporo', 'Cantor', 'ca fonctionne', 'invalid', 0),
(10118, 'invalid', 'fotso', 'belporo', 'conversation de groupe', 'invalid', 0),
(10119, 'invalid', 'Cantor', 'belporo', 'tes noyaux', 'invalid', 0),
(10120, 'invalid', 'belporo', 'Cantor', 'je vais aussi bien', 'invalid', 0),
(10121, 'invalid', 'fotso', 'Ss', 'yess c du tres haut niveau', 'invalid', 0),
(10122, 'invalid', 'Cantor', 'belporo', '????????????????????????????', 'invalid', 0),
(10123, 'invalid', 'fotso', 'Cantor', ' yess wiah talk', 'invalid', 0),
(10124, 'invalid', 'fotso', 'Cantor', '????????????????????', 'invalid', 0),
(10125, 'invalid', 'fotso', 'Cantor', 'test', 'invalid', 0),
(10126, 'invalid', 'Ss', 'fotso', 'qui reçoit?', 'invalid', 0),
(10127, 'invalid', 'belporo', 'Cantor', 'yo', 'invalid', 0),
(10128, 'invalid', 'fotso', 'Ss', 'sbdg', 'invalid', 0),
(10129, 'invalid', 'fotso', 'Ss', '????????', 'invalid', 0),
(10130, 'invalid', 'fotso', 'Ss', '????????sjdh', 'invalid', 0),
(10131, 'invalid', 'belporo', 'Cantor', 'hey', 'invalid', 0),
(10132, 'invalid', 'fotso', 'Ss', 'gggg', 'invalid', 0),
(10133, 'invalid', 'fotso', 'Ss', '????', 'invalid', 0),
(10134, 'invalid', 'belporo', 'fotso', 'mandeng', 'invalid', 0),
(10135, 'invalid', 'labo', 'sedou', 'gp', 'invalid', 0),
(10136, 'invalid', 'labo', 'sedou', 'bbnn', 'invalid', 0),
(10137, 'invalid', 'labo', 'sedou', 'cbnnn', 'invalid', 0),
(10138, 'invalid', 'labo', 'sedou', 'hnnn', 'invalid', 0),
(10139, 'invalid', 'labo', 'sedou', 'vnlkx', 'invalid', 0),
(10140, 'invalid', 'labo', 'sedou', 'xbbb', 'invalid', 0),
(10141, 'invalid', 'labo', 'sedou', 'vbnn', 'invalid', 0),
(10142, 'invalid', 'labo', 'sedou', 'vbbnnn', 'invalid', 0),
(10143, 'invalid', 'co', 'labo', 'hey', 'invalid', 0),
(10144, 'invalid', 'labo', 'co', 'hi', 'invalid', 0),
(10145, 'invalid', 'co', 'labo', 'hey', 'invalid', 0),
(10146, 'invalid', 'co', 'labo', 'ji', 'invalid', 0),
(10147, 'invalid', 'co', 'labo', 'hi', 'invalid', 0),
(10148, 'invalid', 'co', 'labo', '????????', 'invalid', 0),
(10149, 'invalid', 'co', 'labo', 'bon', 'invalid', 0),
(10150, 'invalid', 'christ', 'eug', 'yo', 'invalid', 0),
(10151, 'invalid', 'christ', 'eug', 'tyvaadbb', 'invalid', 0),
(10152, 'invalid', 'eug', 'christ', 'yn ', 'invalid', 0),
(10153, 'invalid', 'eug', 'christ', 'vbbb', 'invalid', 0),
(10154, 'invalid', 'christ', 'eug', 'rrff', 'invalid', 0),
(10155, 'invalid', 'christ', 'eug', 'gggg', 'invalid', 0),
(10156, 'invalid', 'christ', 'eug', 'ggggg ooooo', 'invalid', 0),
(10157, 'invalid', 'christ', 'eug', 'tttttt', 'invalid', 0),
(10158, 'invalid', 'eug', 'christ', 'hola', 'invalid', 0),
(10159, 'invalid', 'eug', 'christ', 'bo', 'invalid', 0),
(10160, 'invalid', 'eug', 'christ', 'v', 'invalid', 0),
(10161, 'invalid', 'eug', 'christ', 'vvbbnbccbn', 'invalid', 0),
(10162, 'invalid', 'eug', 'christ', 'pp', 'invalid', 0),
(10163, 'invalid', 'christ', 'eug', 'fffff', 'invalid', 0),
(10164, 'invalid', 'christ', 'eug', 'fttttffgg', 'invalid', 0),
(10165, 'invalid', 'eug', 'christ', 'holq', 'invalid', 0),
(10166, 'invalid', 'eug', 'christ', 'vb.    ', 'invalid', 0),
(10167, 'invalid', 'eug', 'christ', 'opm. v n', 'invalid', 0),
(10168, 'invalid', 'eug', 'christ', '????????????????????????????????????????', 'invalid', 0),
(10169, 'invalid', 'christ', 'eug', '????????????????????', 'invalid', 0),
(10170, 'invalid', 'christ', 'eug', '????????????????', 'invalid', 0),
(10171, 'invalid', 'christ', 'eug', 'eedffff', 'invalid', 0),
(10172, 'invalid', 'eug', 'christ', 'fhbn', 'invalid', 0),
(10173, 'invalid', 'christ', 'eug', 'eeefv. ', 'invalid', 0);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `pseudo` varchar(11) NOT NULL,
  `pwd` varchar(11) NOT NULL,
  `tel` int(20) NOT NULL,
  `name_user` varchar(12) NOT NULL,
  `photo_profil` varchar(30) NOT NULL,
  `actu_profil` varchar(20) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `pseudo`, `pwd`, `tel`, `name_user`, `photo_profil`, `actu_profil`, `email`) VALUES
(1000043, 'aime', 'po', 22, 'aime', '0', NULL, 'po'),
(1000044, 'sedou', 's', 223, 'sedou', '0', NULL, 's'),
(1000045, 'jules', 'belporo', 695538144, 'belporo', '0', NULL, 'belporojules@gm'),
(1000046, 'fotso', 'fotso', 695952769, 'fotso', '0', NULL, 'paulaudrup21@gm'),
(1000047, 'ktr98', 'chefd\'ak', 655702190, 'Cantor', '0', NULL, 'ndjiengale@yaho'),
(1000048, 'ss', 'ss', 699880055, 'Ss', '0', NULL, 'ss@gmail.com'),
(1000049, 'labo', 'labl', 458937, 'labo', '0', NULL, 'b'),
(1000050, 'co', 'co', 699988, 'co', '0', NULL, 'coretta'),
(1000051, 'eug', 'po', 709356, 'eug', '0', NULL, 'po'),
(1000052, 'christ', 'sn=hrist', 7863450, 'christ', '0', NULL, 'dsds');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `msg`
--
ALTER TABLE `msg`
  ADD PRIMARY KEY (`id_msg`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `tel` (`tel`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `msg`
--
ALTER TABLE `msg`
  MODIFY `id_msg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10174;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000053;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
