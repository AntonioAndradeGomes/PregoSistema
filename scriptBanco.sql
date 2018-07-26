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
	`idDevedor` int,
	`Valor` DOUBLE NOT NULL,
	`Especificacao` VARCHAR(255) NULL,
	`Status` VARCHAR(45) NOT NULL,
	`Datadeabertura` DATE NOT NULL, -- data de cadastro da divida
	`Datadefechamento` DATE NULL, -- data que o usuario acredita ser pago
    `DatadePagamento` DATE NULL, -- data em que o usuario muda o status da divida para pago
     Primary key (`idDevedor`),
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