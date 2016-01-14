CREATE TABLE usuario (uid int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
                      usuario varchar(60) NOT NULL,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                      senha varchar(60) NOT NULL);
                      
CREATE TABLE grafico (id int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
					  uid_usuario int(20) NOT NULL,	
                      nome_grafico varchar(60) NOT NULL,
                      eixo_y varchar(60) NOT NULL,
                      id_serie int(20) NOT NULL,
                      serie varchar(60) NOT NULL);      
                      
Insert into grafico ("id","uid_usuario","nome_grafico","eixo_y","id_serie","serie") values (1,1,'BKO_APOIO_7054','152',1,'3h');
Insert into grafico ("id","uid_usuario","nome_grafico","eixo_y","id_serie","serie") values (2,1,'BKO_APOIO_7054','213',1,'4h');
Insert into grafico ("id","uid_usuario","nome_grafico","eixo_y","id_serie","serie") values (3,1,'BKO_APOIO_7054','253',1,'5h');
Insert into grafico ("id","uid_usuario","nome_grafico","eixo_y","id_serie","serie") values (4,1,'BKO_APOIO_7054','53',1,'6h');
Insert into grafico ("id","uid_usuario","nome_grafico","eixo_y","id_serie","serie") values (5,1,'BKO_APOIO_7054','135',1,'7h');
Insert into grafico ("id","uid_usuario","nome_grafico","eixo_y","id_serie","serie") values (6,1,'BKO_APOIO_7054','210',1,'8h');
                     