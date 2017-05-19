/****************************/
/*	        USER    	      */
/****************************/
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (100,'el mardi','abdel','aelmardi','azerty');
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (101,'senecat','quentin','qsenecat','azerty');
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (102,'adminNom','adminPrenom','admin','azerty');
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (103,'site','site','ECOMMERCE','azerty');

/****************************/
/*	        UserRole    	  */
/****************************/
INSERT INTO UserRole (idClient, role) VALUES (100, 'ROLE_USER');
INSERT INTO UserRole (idClient, role) VALUES (101, 'ROLE_USER');
INSERT INTO UserRole (idClient, role) VALUES (102, 'ROLE_ADMIN');
INSERT INTO UserRole (idClient, role) VALUES (103, 'ROLE_USER');

/****************************/
/*	        COMPTE    	    */
/****************************/
INSERT INTO COMPTE (TYPE_COMPTE,IDCOMPTE,SOLDE,DECOUVERT,IDCLIENT,DATECOMPTE) VALUES ('CompteCourant',100,500,500,100,'2016-12-19');
INSERT INTO COMPTE (TYPE_COMPTE,IDCOMPTE,SOLDE,DECOUVERT,IDCLIENT,DATECOMPTE) VALUES ('CompteCourant',101,200,500,101,'2016-12-12');
INSERT INTO COMPTE (TYPE_COMPTE,IDCOMPTE,SOLDE,IDCLIENT,DATECOMPTE) VALUES ('CompteEpargne',102,1000,101,'2016-12-19');
INSERT INTO COMPTE (TYPE_COMPTE,IDCOMPTE,SOLDE,DECOUVERT,IDCLIENT,DATECOMPTE) VALUES ('CompteCourant',103,5000000,100000,103,'2017-03-16');

/****************************/
/*	        Operation    	  */
/****************************/