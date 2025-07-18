-- DROP TABLES IF EXISTENT (ordre pour éviter contraintes FK)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ANIMAL_HABITAT CASCADE CONSTRAINTS';
    EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ANIMAL CASCADE CONSTRAINTS';
    EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ESPECE CASCADE CONSTRAINTS';
    EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE FAMILLE CASCADE CONSTRAINTS';
    EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE HABITAT CASCADE CONSTRAINTS';
    EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE CONTINENT CASCADE CONSTRAINTS';
    EXCEPTION WHEN OTHERS THEN NULL;
END;
/


CREATE TABLE CONTINENT(
   continent_id NUMBER(20) PRIMARY KEY,
   nom_continent VARCHAR2(255) NOT NULL
);


CREATE TABLE FAMILLE(
   famille_id NUMBER(20) PRIMARY KEY,
   nom_famille VARCHAR2(255) NOT NULL,
   description_famille VARCHAR2(2000)
);


CREATE TABLE ESPECE(
   espece_id NUMBER(20) PRIMARY KEY,
   nom_espece VARCHAR2(255) NOT NULL,
   description_espece VARCHAR2(2000),
   famille_id NUMBER(20),
   CONSTRAINT fk_famille FOREIGN KEY (famille_id) REFERENCES FAMILLE(famille_id)
   
);


CREATE TABLE HABITAT(
   habitat_id NUMBER(20) PRIMARY KEY,
   nom_habitat VARCHAR2(255) NOT NULL,
   continent_id NUMBER(20),
   CONSTRAINT fk_continent FOREIGN KEY (continent_id) REFERENCES CONTINENT(continent_id)
   
);



CREATE TABLE ANIMAL (
    animal_id NUMBER(20) PRIMARY KEY,
    nom_animal VARCHAR2(255) NOT NULL,
    poids NUMBER(20,6),
    taille NUMBER(20,6),
    description_animal VARCHAR2(2000),
    esperance_de_vie NUMBER(20),
    photo_url VARCHAR2(2000),
    regime_alimentaire VARCHAR2(1),
    espece_id NUMBER(20),
    CONSTRAINT fk_espece FOREIGN KEY (espece_id) REFERENCES ESPECE(espece_id)
);




CREATE TABLE ANIMAL_HABITAT(
   animal_id NUMBER(20),
   habitat_id NUMBER(20),
   PRIMARY KEY (animal_id , habitat_id),
   FOREIGN KEY(animal_id) REFERENCES ANIMAL(animal_id),
   FOREIGN KEY(habitat_id) REFERENCES HABITAT(habitat_id)
  
);

INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (1, 'AFRIQUE');
INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (2, 'ASIE');
INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (3, 'EUROPE');
INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (4, 'AMERIQUE DU NORD');
INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (5, 'AMERIQUE DU SUD');
INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (6, 'ANTARCTIQUE');
INSERT INTO CONTINENT(continent_id, nom_continent) VALUES (7, 'OCEANIE');


INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (1, 'savane',1);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (2, 'Fôret équatoriale',1);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (3, 'Desert',1);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (4, 'Jungle',2);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (5, 'Steppe',2);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (6, 'Banquise',6);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (7, 'Forêt boréale',4);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (8, 'Montagne',3);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (9, 'Forêt tropicale',5);
INSERT INTO HABITAT(habitat_id, nom_habitat,continent_id) VALUES (10, 'Récif corallien',7);


INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (1, 'Felidae', 'Famille des félins');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (2, 'Elephantidae', 'Famille des éléphants');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (3, 'Giraffidae', 'Famille des girafes');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (4, 'Hominidae', 'Famille des grands singes');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (5, 'Camelidae', 'Famille des camélidés');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (6, 'Pythonidae', 'Famille des pythons');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (7, 'Bovidae', 'Famille des bovins');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (8, 'Spheniscidae', 'Famille des manchots');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (9, 'Canidae', 'Famille des canidés');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (10, 'Cervidae', 'Famille des cervidés');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (11, 'Bradypodidae', 'Famille des paresseux');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (12, 'Cheloniidae', 'Famille des tortues marines');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (13, 'Phasianidae', 'Famille des paons et apparentés');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (14, 'Ursidae', 'Famille des ours');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (15, 'Equidae', 'Famille des chevaux');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (16, 'Phascolarctidae', 'Famille des koalas');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (17, 'Macropodidae', 'Famille des kangourous');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (18, 'Crocodylidae', 'Famille des crocodiles');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (19, 'Hippopotamidae', 'Famille des hippopotames');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (20, 'Accipitridae', 'Famille des rapaces');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (21, 'Dromaiidae', 'Famille des émeus');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (22, 'Delphinidae', 'Famille des dauphins et orques');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (23, 'Phoenicopteridae', 'Famille des flamants roses');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (24, 'Ramphastidae', 'Famille des toucans');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (25, 'Manidae', 'Famille des pangolins');
INSERT INTO FAMILLE (famille_id, nom_famille, description_famille) VALUES (26, 'Physeteridae', 'Famille des cachalots');


INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (1, 'Félin', 'Espèces de la famille des félins', 1);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (2, 'Éléphant', 'Grand mammifère terrestre', 2);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (3, 'Girafe', 'Le plus grand animal terrestre', 3);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (4, 'Grand singe', 'Gorilles, chimpanzés, etc.', 4);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (5, 'Camélidé', 'Chameaux et dromadaires', 5);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (6, 'Python', 'Serpents constricteurs', 6);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (7, 'Bovin', 'Boeufs, yaks, chevaux de Przewalski', 7);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (8, 'Manchot', 'Oiseaux de l''Antarctique', 8);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (9, 'Canidé', 'Loups, renards, chiens', 9);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (10, 'Cervidé', 'Cerfs, rennes, orignaux', 10);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (11, 'Paresseux', 'Mammifères lents et arboricoles', 11);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (12, 'Tortue marine', 'Reptiles marins', 12);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (13, 'Paon', 'Oiseau coloré', 13);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (14, 'Ours', 'Famille des ours', 14);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (15, 'Cheval', 'Chevaux et apparentés', 15);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (16, 'Koala', 'Marsupial herbivore', 16);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (17, 'Kangourou', 'Marsupiaux bondissants', 17);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (18, 'Crocodile', 'Grand reptile carnivore', 18);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (19, 'Hippopotame', 'Mammifère semi-aquatique', 19);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (20, 'Rapace', 'Aigles et oiseaux de proie', 20);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (21, 'Émeu', 'Grand oiseau australien', 21);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (22, 'Dauphin', 'Mammifère marin carnivore', 22);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (23, 'Flamant rose', 'Oiseau échassier', 23);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (24, 'Toucan', 'Oiseau tropical', 24);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (25, 'Pangolin', 'Mammifère insectivore', 25);
INSERT INTO ESPECE(espece_id, nom_espece, description_espece, famille_id) VALUES (26, 'Cachalot', 'Plus grand cétacé à dents', 26);



INSERT INTO ANIMAL VALUES (1, 'Lion', 190, 1.2, 'Grand félin carnivore d''Afrique', 15, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (2, 'Éléphant d''Afrique', 6000, 3.3, 'Plus grand mammifère terrestre', 70, NULL, 'H', 2);
INSERT INTO ANIMAL VALUES (3, 'Girafe', 1200, 5.5, 'Le plus grand animal terrestre', 25, NULL, 'H', 3);
INSERT INTO ANIMAL VALUES (4, 'Gorille', 160, 1.7, 'Grand singe puissant', 35, NULL, 'O', 4);
INSERT INTO ANIMAL VALUES (5, 'Chameau', 600, 2.1, 'Camélidé du désert', 40, NULL, 'H', 5);
INSERT INTO ANIMAL VALUES (6, 'Python', 100, 5, 'Serpent constricteur', 30, NULL, 'C', 6);
INSERT INTO ANIMAL VALUES (7, 'Boeuf', 700, 1.5, 'Bovin domestique', 20, NULL, 'H', 7);
INSERT INTO ANIMAL VALUES (8, 'Manchot empereur', 30, 1.1, 'Oiseau de l''Antarctique', 20, NULL, 'C', 8);
INSERT INTO ANIMAL VALUES (9, 'Loup', 45, 0.8, 'Canidé carnivore', 13, NULL, 'C', 9);
INSERT INTO ANIMAL VALUES (10, 'Cerf', 120, 1.2, 'Cervidé herbivore', 20, NULL, 'H', 10);
INSERT INTO ANIMAL VALUES (11, 'Paresseux', 6, 0.6, 'Mammifère lent arboricole', 20, NULL, 'H', 11);
INSERT INTO ANIMAL VALUES (12, 'Tortue marine', 150, 1.5, 'Reptile marin', 80, NULL, 'H', 12);
INSERT INTO ANIMAL VALUES (13, 'Tigre', 220, 1.1, 'Grand félin carnivore', 20, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (14, 'Léopard', 65, 0.7, 'Félin agile et carnivore', 15, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (15, 'Chimpanzé', 50, 1.2, 'Grand singe intelligent', 40, NULL, 'O', 4);
INSERT INTO ANIMAL VALUES (16, 'Fennec', 1.5, 0.3, 'Petit canidé du désert', 12, NULL, 'C', 9);
INSERT INTO ANIMAL VALUES (17, 'Dromadaire', 600, 2.0, 'Camélidé du désert', 40, NULL, 'H', 5);
INSERT INTO ANIMAL VALUES (18, 'Yak', 500, 1.5, 'Bovin des montagnes', 25, NULL, 'H', 7);
INSERT INTO ANIMAL VALUES (19, 'Cheval de Przewalski', 350, 1.4, 'Cheval sauvage d''Asie', 25, NULL, 'H', 7);
INSERT INTO ANIMAL VALUES (20, 'Paon', 4, 1.0, 'Oiseau coloré', 15, NULL, 'H', 13);
INSERT INTO ANIMAL VALUES (21, 'Manchot Adélie', 6, 0.7, 'Oiseau antarctique', 15, NULL, 'C', 8);
INSERT INTO ANIMAL VALUES (22, 'Ours brun', 300, 1.8, 'Grand mammifère carnivore', 25, NULL, 'O', 14);
INSERT INTO ANIMAL VALUES (23, 'Lynx', 20, 0.7, 'Félin sauvage d''Europe', 15, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (24, 'Bouquetin', 70, 1.0, 'Cervidé de montagne', 18, NULL, 'H', 10);
INSERT INTO ANIMAL VALUES (25, 'Jaguar', 90, 1.2, 'Félin carnivore d''Amérique', 15, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (26, 'Python royal', 30, 3.5, 'Serpent constricteur', 25, NULL, 'C', 6);
INSERT INTO ANIMAL VALUES (27, 'Tortue luth', 600, 2.0, 'Grande tortue marine', 50, NULL, 'H', 12);
INSERT INTO ANIMAL VALUES (28, 'Ours polaire', 400, 2.0, 'Carnivore polaire', 25, NULL, 'C', 14);
INSERT INTO ANIMAL VALUES (29, 'Orignal', 500, 1.5, 'Grand cervidé', 20, NULL, 'H', 10);
INSERT INTO ANIMAL VALUES (30, 'Koala', 15, 0.8, 'Marsupial herbivore', 13, NULL, 'H', 16);
INSERT INTO ANIMAL VALUES (31, 'Kangourou', 85, 1.6, 'Marsupial bondissant', 20, NULL, 'H', 17);
INSERT INTO ANIMAL VALUES (32, 'Crocodile du Nil', 500, 5, 'Reptile carnivore', 70, NULL, 'C', 18);
INSERT INTO ANIMAL VALUES (33, 'Hippopotame', 1500, 1.5, 'Mammifère semi-aquatique', 40, NULL, 'H', 19);
INSERT INTO ANIMAL VALUES (34, 'Chimpanzé pygmée', 40, 1.0, 'Petit grand singe', 40, NULL, 'O', 4);
INSERT INTO ANIMAL VALUES (35, 'Aigle royal', 6, 0.9, 'Rapace puissant', 20, NULL, 'C', 20);
INSERT INTO ANIMAL VALUES (36, 'Cerf rouge', 160, 1.2, 'Grand cervidé', 15, NULL, 'H', 10);
INSERT INTO ANIMAL VALUES (37, 'Puma', 60, 1.1, 'Félin d''Amérique', 15, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (38, 'Renne', 90, 1.2, 'Cervidé du nord', 15, NULL, 'H', 10);
INSERT INTO ANIMAL VALUES (39, 'Zèbre', 350, 1.3, 'Bovin d''Afrique', 25, NULL, 'H', 7);
INSERT INTO ANIMAL VALUES (40, 'Grizzli', 300, 1.8, 'Ours d''Amérique du Nord', 25, NULL, 'O', 14);
INSERT INTO ANIMAL VALUES (41, 'Émeu', 45, 1.7, 'Grand oiseau australien', 20, NULL, 'H', 21);
INSERT INTO ANIMAL VALUES (42, 'Orque', 8000, 8, 'Grand cétacé carnivore', 60, NULL, 'C', 22);
INSERT INTO ANIMAL VALUES (43, 'Flamant rose', 3, 1.2, 'Oiseau échassier', 30, NULL, 'H', 23);
INSERT INTO ANIMAL VALUES (44, 'Toucan', 0.5, 0.6, 'Oiseau tropical', 20, NULL, 'H', 24);
INSERT INTO ANIMAL VALUES (45, 'Pangolin', 15, 0.9, 'Mammifère insectivore', 15, NULL, 'C', 25);
INSERT INTO ANIMAL VALUES (46, 'Serpent corail', 1, 1, 'Serpent venimeux', 10, NULL, 'C', 6);
INSERT INTO ANIMAL VALUES (47, 'Dauphin', 200, 2.5, 'Mammifère marin intelligent', 30, NULL, 'C', 22);
INSERT INTO ANIMAL VALUES (48, 'Tigre de Sibérie', 230, 1.2, 'Sous-espèce du tigre', 20, NULL, 'C', 1);
INSERT INTO ANIMAL VALUES (49, 'Cachalot', 57000, 18, 'Plus grand cétacé à dents', 70, NULL, 'C', 26);
INSERT INTO ANIMAL VALUES (50, 'Chimpanzé commun', 50, 1.2, 'Grand singe intelligent', 40, NULL, 'O', 4);



INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (1, 1);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (2, 1);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (3, 1);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (4, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (5, 3);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (6, 4);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (7, 1);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (8, 6);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (9, 7);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (10, 8);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (11, 9);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (12, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (13, 4);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (14, 4);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (15, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (16, 3);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (17, 3);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (18, 5);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (19, 5);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (20, 4);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (21, 6);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (22, 7);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (23, 8);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (24, 8);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (25, 9);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (26, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (27, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (28, 6);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (29, 7);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (30, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (31, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (32, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (33, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (34, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (35, 8);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (36, 8);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (37, 9);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (38, 7);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (39, 1);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (40, 7);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (41, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (42, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (43, 9);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (44, 2);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (45, 9);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (46, 9);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (47, 4);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (48, 10);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (49, 5);
INSERT INTO ANIMAL_HABITAT(animal_id, habitat_id) VALUES (50, 10);

COMMIT;

UPDATE ANIMAL SET photo_url = './static/images/lion.jpg' WHERE animal_id = 1;
UPDATE ANIMAL SET photo_url = './static/images/elephant_afrique.jpg' WHERE animal_id = 2;
UPDATE ANIMAL SET photo_url = './static/images/giraffe.jpg' WHERE animal_id = 3;
UPDATE ANIMAL SET photo_url = './static/images/gorille.jpg' WHERE animal_id = 4;
UPDATE ANIMAL SET photo_url = './static/images/chameau.jpg' WHERE animal_id = 5;
UPDATE ANIMAL SET photo_url = './static/images/python.jpg' WHERE animal_id = 6;
UPDATE ANIMAL SET photo_url = './static/images/boeuf.jpg' WHERE animal_id = 7;
UPDATE ANIMAL SET photo_url = './static/images/manchot-empereur.jpg' WHERE animal_id = 8;
UPDATE ANIMAL SET photo_url = './static/images/loup.jpg' WHERE animal_id = 9;
UPDATE ANIMAL SET photo_url = './static/images/cerf.jpg' WHERE animal_id = 10;
UPDATE ANIMAL SET photo_url = './static/images/paresseux.jpg' WHERE animal_id = 11;
UPDATE ANIMAL SET photo_url = './static/images/tortue_marine.jpg' WHERE animal_id = 12;
UPDATE ANIMAL SET photo_url = './static/images/tigre.jpg' WHERE animal_id = 13;
UPDATE ANIMAL SET photo_url = './static/images/leopard.jpg' WHERE animal_id = 14;
UPDATE ANIMAL SET photo_url = './static/images/chimpanze.jpg' WHERE animal_id = 15;
UPDATE ANIMAL SET photo_url = './static/images/fennec.jpg' WHERE animal_id = 16;
UPDATE ANIMAL SET photo_url = './static/images/dromadaire.jpg' WHERE animal_id = 17;
UPDATE ANIMAL SET photo_url = './static/images/yak.jpg' WHERE animal_id = 18;
UPDATE ANIMAL SET photo_url = './static/images/cheval_przewalski.jpg' WHERE animal_id = 19;
UPDATE ANIMAL SET photo_url = './static/images/paon.jpg' WHERE animal_id = 20;
UPDATE ANIMAL SET photo_url = './static/images/manchot_adelie.jpg' WHERE animal_id = 21;
UPDATE ANIMAL SET photo_url = './static/images/ours_brun.jpg' WHERE animal_id = 22;
UPDATE ANIMAL SET photo_url = './static/images/lynx.jpg' WHERE animal_id = 23;
UPDATE ANIMAL SET photo_url = './static/images/bouquetin.jpg' WHERE animal_id = 24;
UPDATE ANIMAL SET photo_url = './static/images/jaguar.jpg' WHERE animal_id = 25;
UPDATE ANIMAL SET photo_url = './static/images/python_royal.jpg' WHERE animal_id = 26;
UPDATE ANIMAL SET photo_url = './static/images/tortue_luth.jpg' WHERE animal_id = 27;
UPDATE ANIMAL SET photo_url = './static/images/ours_polaire.jpg' WHERE animal_id = 28;
UPDATE ANIMAL SET photo_url = './static/images/orignal.jpg' WHERE animal_id = 29;
UPDATE ANIMAL SET photo_url = './static/images/koala.jpg' WHERE animal_id = 30;
UPDATE ANIMAL SET photo_url = './static/images/kangourou.jpg' WHERE animal_id = 31;
UPDATE ANIMAL SET photo_url = './static/images/crocodile_du_nil.jpg' WHERE animal_id = 32;
UPDATE ANIMAL SET photo_url = './static/images/hippopotame.jpg' WHERE animal_id = 33;
UPDATE ANIMAL SET photo_url = './static/images/chimpanze_pygmee.jpg' WHERE animal_id = 34;
UPDATE ANIMAL SET photo_url = './static/images/aigle-royal.jpg' WHERE animal_id = 35;
UPDATE ANIMAL SET photo_url = './static/images/cerf_rouge.jpg' WHERE animal_id = 36;
UPDATE ANIMAL SET photo_url = './static/images/puma.jpg' WHERE animal_id = 37;
UPDATE ANIMAL SET photo_url = './static/images/renne.jpg' WHERE animal_id = 38;
UPDATE ANIMAL SET photo_url = './static/images/zebre.jpg' WHERE animal_id = 39;
UPDATE ANIMAL SET photo_url = './static/images/grizily.jpg' WHERE animal_id = 40;
UPDATE ANIMAL SET photo_url = './static/images/emeu.jpg' WHERE animal_id = 41;
UPDATE ANIMAL SET photo_url = './static/images/orque.jpg' WHERE animal_id = 42;
UPDATE ANIMAL SET photo_url = './static/images/flamants_roses.jpg' WHERE animal_id = 43;
UPDATE ANIMAL SET photo_url = './static/images/toucan.jpg' WHERE animal_id = 44;
UPDATE ANIMAL SET photo_url = './static/images/pangolin.jpg' WHERE animal_id = 45;
UPDATE ANIMAL SET photo_url = './static/images/serpent_corail.jpg' WHERE animal_id = 46;
UPDATE ANIMAL SET photo_url = './static/images/dauphin.jpg' WHERE animal_id = 47;
UPDATE ANIMAL SET photo_url = './static/images/tigre_de_siberie.jpg' WHERE animal_id = 48;
UPDATE ANIMAL SET photo_url = './static/images/cachalot.jpg' WHERE animal_id = 49;
UPDATE ANIMAL SET photo_url = './static/images/chimpanze_commun.jpg' WHERE animal_id = 50;

COMMIT;




