
CREATE TABLE Client(
id_c VARCHAR (20),
nume VARCHAR(20),
adresa VARCHAR(40)
);


CREATE TABLE Factura(
id_f VARCHAR(20),
data  DATE,
nr_slideuri FLOAT,
cost_slide FLOAT,
nr_zile FLOAT,
total FLOAT,
id_c VARCHAR(20)
);


CREATE TABLE Localitate(
id_l VARCHAR(20),
denumire VARCHAR(20)
);


CREATE TABLE Difuzare(
id_f VARCHAR(20),
id_l VARCHAR(20),
datai DATE,
datas DATE
);

ALTER TABLE Client ADD PRIMARY KEY (id_c);
ALTER TABLE Factura ADD PRIMARY KEY (id_f);
ALTER TABLE Localitate ADD PRIMARY KEY (id_l);

ALTER TABLE Factura ADD FOREIGN KEY(id_c) REFERENCES Client(id_c);
ALTER TABLE Difuzare ADD FOREIGN KEY(id_f) REFERENCES Factura(id_f);
ALTER TABLE Difuzare ADD FOREIGN KEY(id_l) REFERENCES Localitate(id_l);


ALTER TABLE Factura
MODIFY nr_slideuri FLOAT NOT NULL;
ALTER TABLE Factura
MODIFY nr_zile FLOAT NOT NULL;
ALTER TABLE Factura
MODIFY cost_slide FLOAT NOT NULL;

ALTER TABLE Factura 
ADD tva FLOAT ; 



ALTER TABLE Factura ADD CONSTRAINT factura_nr_slideuri_ck CHECK(nr_slideuri BETWEEN 1 AND 40);


ALTER TABLE Client ADD CONSTRAINT client_nume_ck CHECK( (nume LIKE 'firma%' AND adresa LIKE '%sediu social%') OR(nume NOT LIKE 'firma%' AND adresa NOT LIKE '%sediu social%') );



INSERT INTO Client(id_c,nume,adresa) VALUES('c1','Leonard','bld 5, Paris,Franta');
INSERT INTO Client(id_c,nume,adresa) VALUES('c2','Ionescu Paul','Observator,  Cluj Napoca, Romania');
INSERT INTO Client(id_c,nume,adresa) VALUES('c3','firma Dedeman','sediu social: sct 2, Bucuresti, Romania');
INSERT INTO Client(id_c,nume,adresa) VALUES('c4','Bill Gates','Seattle, Washington, SUA');
INSERT INTO Client(id_c,nume,adresa) VALUES('c5','Maria Dumitru','Alba Iulia, Romania');
INSERT INTO Client(id_c,nume,adresa) VALUES('c6','Lavinia Stoica','Cluj Napoca, Romania');
INSERT INTO Client(id_c,nume,adresa) VALUES('c7','Marina Popa','Brasov, Romania');

INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f1', '2016-03-25',5, 15, 11, 'c1');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile,id_c) VALUES('f2', '2018-06-01',10, 5, 11, 'c2');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f3', '2019-10-16',39, 25, 11,'c3');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f4', '2016-03-27',39, 50, 11, 'c4');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f5', '2015-04-11',22, 5, 22, 'c5');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f6', '2019-09-10',20, 5, 11, 'c6');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f7', '2019-09-11',15, 4, 11, 'c7');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f8', '2019-09-11',10, 4, 11, 'c7');
INSERT INTO Factura(id_f,data,nr_slideuri, cost_slide, nr_zile, id_c) VALUES('f9', '2019-09-12',11, 4, 11, 'c7');

UPDATE Factura
SET Total=nr_slideuri*cost_slide*nr_zile;

UPDATE Factura
SET tva=nr_slideuri*cost_slide*nr_zile*0.19;

INSERT INTO Localitate(id_l, denumire) VALUES('l1', 'Alba Iulia');
INSERT INTO Localitate(id_l, denumire) VALUES('l2', 'Sebes');
INSERT INTO Localitate(id_l, denumire) VALUES('l3', 'Cluj Napoca');
INSERT INTO Localitate(id_l, denumire) VALUES('l4', 'Radauti');
INSERT INTO Localitate(id_l, denumire) VALUES('l5', 'Medias');

INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f1','l1', '2016-03-26', '2016-04-06');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f2','l2', '2018-06-02', '2018-06-13');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f3','l3', '2019-10-17', '2019-10-28');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f4','l4', '2016-03-28', '2016-04-08');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f5','l5', '2015-04-12', '2015-04-23');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f5','l2', '2015-04-12', '2015-04-23');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f6','l2', '2019-09-11', '2019-09-22');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f7','l4', '2019-09-12', '2019-09-23');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f8','l4', '2019-09-12', '2019-09-23');
INSERT INTO Difuzare(id_f, id_l, datai, datas) VALUES('f9','l2', '2019-09-13', '2019-09-24');