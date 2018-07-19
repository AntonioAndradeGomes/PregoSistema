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