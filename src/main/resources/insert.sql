/****************************/
/*	        USER    	      */
/****************************/
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (100,'el mardi','abdel','aelmardi','azerty');
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (101,'senecat','quentin','qsenecat','azerty');
INSERT INTO USER (IDCLIENT,NOM,PRENOM,USERNAME,PASSWORD) VALUES (102,'adminNom','adminPrenom','admin','azerty');

/****************************/
/*	        UserRole    	  */
/****************************/
INSERT INTO UserRole (idClient, role) VALUES (100, 'ROLE_USER');
INSERT INTO UserRole (idClient, role) VALUES (101, 'ROLE_USER');
INSERT INTO UserRole (idClient, role) VALUES (102, 'ROLE_ADMIN');

/****************************/
/*	        COMPTE    	    */
/****************************/
INSERT INTO COMPTE (IDCOMPTE,TYPECOMPTE,DECOUVERT,IDCLIENT,DATECOMPTE) VALUES (100,'courant',500,100,'2016-12-19');
INSERT INTO COMPTE (IDCOMPTE,TYPECOMPTE,DECOUVERT,IDCLIENT,DATECOMPTE) VALUES (101,'courant',200,101,'2016-12-12');
INSERT INTO COMPTE (IDCOMPTE,TYPECOMPTE,DECOUVERT,IDCLIENT,DATECOMPTE) VALUES (102,'epargne',1000,101,'2016-12-19');

/****************************/
/*	        Operation    	  */
/****************************/