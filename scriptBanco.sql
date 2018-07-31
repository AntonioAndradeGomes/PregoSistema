CREATE database PregoSistema;
Use PregoSistema;

CREATE TABLE IF NOT EXISTS `PregoSistema`.`Usuario` (
  `UserNome` VARCHAR(500) NOT NULL,
  `Senha` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`UserNome`),
  UNIQUE INDEX `UserNome_UNIQUE` (`UserNome` ASC)
)
ENGINE = InnoDB;

CREATE TABLE  IF NOT EXISTS `PregoSistema`.`Devedor` (
	`idDevedor` int auto_increment,
	`Nome` VARCHAR(500) NOT NULL,
	`Cidade` VARCHAR(70) NULL,
	`Bairro` VARCHAR(70) NULL,
	`Rua` VARCHAR(255) NULL,
	`Complemento` VARCHAR(255) NULL,
	`Telefone1` VARCHAR(14) NULL,
	`Telefone2` VARCHAR(14) NULL,
	`Usuario_UserNome` VARCHAR(500) NOT NULL,
    Primary key (`idDevedor`),
    FOREIGN KEY (`Usuario_UserNome`)
    REFERENCES `PregoSistema`.`Usuario` (`UserNome`)
    ON DELETE CASCADE -- ao excluir um usuario exclui-se os devedores 
    ON update cascade --  o mesmo de cima só que ao atualizar
)
ENGINE = InnoDB;

create table if not exists `PregoSistema`.`Divida`(
	`idDivida` int  auto_increment,
	`idDevedor` int NOT NULL,
	`Valor` DOUBLE NOT NULL,
	`Especificacao` VARCHAR(255) NULL,
	`Status` VARCHAR(45) NOT NULL,
	`Datadeabertura` DATE NOT NULL, -- data de cadastro da divida
	`Datadefechamento` DATE NULL, -- data que o usuario acredita ser pago
    `DatadePagamento` DATE NULL, -- data em que o usuario muda o status da divida para pago
     Primary key (`idDivida`),
    FOREIGN KEY (`idDevedor`)
    REFERENCES `PregoSistema`.`Devedor` (`idDevedor`)
	on delete cascade
    on update cascade
)
ENGINE = InnoDB;

insert into `PregoSistema`.`Usuario` (UserNome, senha) values ("Antonio", "1234");
select * from `PregoSistema`.`Usuario`;

select * from `PregoSistema`.`Devedor`;
select * from `PregoSistema`.`Divida`;
select * from `PregoSistema`.`Divida` where `Divida`.`idDevedor` =  23;

insert into `PregoSistema`.`Devedor` (Nome, Cidade, Bairro, Rua, Complemento, Telefone1, Telefone2, Usuario_UserNome)
values("Rafael", "Arapiraca", "Arnon de Melo", "Luiz Jose de França", "", "", "", "Antonio");


insert into `PregoSistema`.`Usuario` (UserNome, senha) values ("Laura", "1234");

insert into `PregoSistema`.`Usuario` (UserNome, senha) values ("Luana", "1234");

select * from `PregoSistema`.`Devedor` where `Devedor`.`nome` = "Rafael";

select * from `PregoSistema`.`Devedor` where `Devedor`.`nome` Like "Rafael%";

UPDATE `PregoSistema`.`Usuario` SET `UserNome`='Luanna', `Senha`='12345' WHERE `UserNome`='Luana';

select * from `PregoSistema`.`Devedor` where `Devedor`.`nome` = "Rafael" and `Devedor`.`Usuario_UserNome` = "Julio";

DELETE FROM `PregoSistema`.`Devedor` WHERE `PregoSistema`.`Devedor`.`Nome` = "Julia" and `PregoSistema`.`Devedor`.`Usuario_UserNome` = "Antonio";
UPDATE `PregoSistema`.`Devedor` SET `Devedor`.`Complemento`='Em frenete ao mercadinho', `Devedor`.`Telefone1` = "99738774"
 WHERE `idDevedor`='11' and `Usuario_UserNome` = "Antonio";

 -- inserções na tabela devedor

 INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('2', 'João Barroso', 'Palestina', 'Centro', 'Rua Paracatu', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('3', 'Maria do Carmo', 'Jaramataia', 'Igrejinha', 'Santa Rosa', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('4', 'Manoel Santos', 'Major', 'Vila Olímpia', 'Avenida São Jonathas Carvalho', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('5', 'Jonas Santos', 'Santana', 'Casa Grande', 'Travessa Antônio Ferreira', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('6', 'Raquel Cabral', 'Jacare dos Homens', 'Jardim Sumaré', 'Rua Frederico Moura', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('7', 'Marília Rodrigues', 'São Paulo', 'Vila Gomes Cardim', 'Rua Serra de Bragança', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('8', 'Alfredo Nascimento', 'Belo Monte', 'Centro', 'Rua da Imprensa', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('9', 'Aroldo Melo', 'São Miguel ', 'Centro', 'Rua da Imprensa', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('10', 'João Maria', 'Campo Grande', 'Centro', 'Rua Cristiano Olsen', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('11', 'Marcos Souza', 'Belo Horizonte', 'Centro', 'Rua Cândido Portinari', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('12', 'Miguel Barros', 'Cornélio Procópio', 'Centro', 'Rua dos Carijós', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('13', 'Olavo Marciel', 'Gramado', 'Centro', 'Avenida Afonso Pena', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('14', 'Nando Moura', 'Jaramataia', 'Centro', 'Rua das Fiandeiras', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('15', 'Felipe Borges', 'Capanema', 'Centro', 'Rua Arlindo Nogueira', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('16', 'Alexandre Barros', 'Belém', 'Zona Portuária', 'Rua Nova', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('17', 'Bruno de Carvalho', 'Sobral', 'Vila Jardim Rio Claro', 'Rua Novo Mundo', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('18', 'Jadson Vital', 'Araçatuba', 'Parque Imperial', 'Rua Velho Mundo', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('19', 'Jackson Belo', 'Quebrangulo', 'Centro', 'Rua Santa Clara ', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('20', 'Maria Cláudia', 'Palmeira', 'Centro', 'Rua dos Amarais', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('21', 'Pedro Henrique', 'Palmeira', 'Centro', 'Rua dos Pardais', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('22', 'Henrique de Souza', 'Batalha', 'Centro', 'Rua 15', 'Antonio');
INSERT INTO `PregoSistema`.`Devedor` (`idDevedor`, `Nome`, `Cidade`, `Bairro`, `Rua`, `Usuario_UserNome`) VALUES ('23', 'Jefferson FariasM', 'Major', 'Centro', 'Rua Bonfim', 'Antonio');

-- inserções na tabela divida

INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('1', '400', 'SSD', 'Aberta', '2018-07-23', '2018-10-1', '2018-11-1');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('2', '700', 'Bateria de carro', 'Fechada', '2017-09-1', '2017-09-01', '2017-10-17');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('3', '400', 'Pneus', 'Em atraso', '2018-06-10', '2018-07-10', '2018-07-10');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('4', '90', 'Lanches', 'Em atraso', '2018-05-21', '2018-06-11', '2018-06-11');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('5', '230', 'Celular', 'Em atraso', '2018-03-19', '2018-05-14', '2018-05-14');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('6', '678', 'Celular', 'Em atraso', '2018-02-02', '2018-06-11', '2018-11-01');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('7', '838', 'Produtos de limpeza', 'Em atraso', '2017-09-1', '2018-01-01', '2018-09-13');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('8', '80', 'Pizza', 'Em atraso', '2016-09-12', '2016-10-1', '2018-11-15');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('9', '30', 'Jogos', 'Fechada', '2018-03-11', '2018-05-13', '2018-06-13');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('10', '500', 'Jogos', 'Fechada', '2018-05-08', '2018-06-01', '2018-07-01');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('11', '500', 'Gasolina', 'Fechada', '2018-03-10', '2018-05-1', '2018-07-10');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('12', '500', 'Gasolina', 'Fechada', '2018-01-16', '2018-02-11', '2018-03-18');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('13', '239', 'Manutenção do carro', 'Fechada', '2018-02-19', '2018-03-17', '2018-03-19');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('14', '848', 'Manutenção do carro', 'Fechada', '2018-03-09', '2018-04-12', '2018-04-19');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('15', '238', 'Feira', 'Em atraso', '2018-06-18', '2018-06-18', '2018-06-18');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('16', '238', 'Feira', 'Em atraso', '2018-05-13', '2018-07-10', '2018-07-12');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('17', '245', 'Super Mercado', 'Em atraso', '2017-07-1', '2017-09-1', '2017-10-13');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('18', '200', 'Sapato', 'Fechada', '2018-01-13', '2018-03-12', '2018-03-18');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('19', '200', 'Sapato', 'Fechada', '2018-05-16', '2018-07-10', '2018-09-12');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('20', '157', 'Camisetas', 'Fechada', '2018-03-1', '2018-04-1', '2018-05-13');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('21', '157', 'Camisetas', 'Aberta', '2018-08-14', '2018-09-12', '2018-11-14');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('22', '980', 'Viagem', 'Aberta', '2018-08-31', '2018-10-1', '2018-11-09');
INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, `Status`, `Datadeabertura`, `Datadefechamento`, `DatadePagamento`) VALUES ('23', '400', 'Viagem', 'Aberta', '2018-09-01', '2018-10-01', '2018-11-01');

