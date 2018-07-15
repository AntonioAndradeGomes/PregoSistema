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
	`Nome` VARCHAR(500) NOT NULL,
	`Cidade` VARCHAR(70) NULL,
	`Bairro` VARCHAR(70) NULL,
	`Rua` VARCHAR(255) NULL,
	`Complemento` VARCHAR(255) NULL,
	`Telefone1` VARCHAR(14) NULL,
	`Telefone2` VARCHAR(14) NULL,
	`Usuario_UserNome` VARCHAR(500) NOT NULL,
    Primary key (`Nome`),
    UNIQUE INDEX `Usuario_UserNome_UNIQUE` (`Usuario_UserNome` ASC),
	UNIQUE INDEX `NomeDevedor_UNIQUE` (`Nome` ASC),
    FOREIGN KEY (`Usuario_UserNome`)
    REFERENCES `PregoSistema`.`Usuario` (`UserNome`)
    ON DELETE CASCADE -- ao excluir um usuario exclui-se os devedores 
    ON update cascade --  o mesmo de cima só que ao atualizar
)
ENGINE = InnoDB;

create table if not exists `PregoSistema`.`Divida`(
	`NomeDevedor` VARCHAR(500) NOT NULL,
	`Valor` DOUBLE NOT NULL,
	`Especificacao` VARCHAR(255) NULL,
	`Status` VARCHAR(45) NOT NULL,
	`Datadeabertura` DATE NOT NULL, -- data de cadastro da divida
	`Datadefechamento` DATE NULL, -- data que o usuario acredita ser pago
    `DatadePagamento` DATE NULL, -- data em que o usuario muda o status da divida para pago
     Primary key (`NomeDevedor`),
    UNIQUE INDEX `NomeDevedor_UNIQUE` (`NomeDevedor` ASC), -- idDevedor é chave primaria e estrangeira
    FOREIGN KEY (`NomeDevedor`)
    REFERENCES `PregoSistema`.`Devedor` (`Nome`)
	on delete cascade
    on update cascade
)
ENGINE = InnoDB;


insert into `PregoSistema`.`Usuario` (UserNome, senha) values ("Antonio", "1234");

select * from `PregoSistema`.`Usuario`;

select * from `PregoSistema`.`Devedor`;


insert into `PregoSistema`.`Devedor` (Nome, Cidade, Bairro, Rua, Complemento, Telefone1, Telefone2, Usuario_UserNome)
values("Rafael", "Arapiraca", "Arnon de Melo", "Luiz Jose de França", "", "", "", "Antonio");

select * from `PregoSistema`.`Usuario` where `PregoSistema`.`Usuario`.`UserNome` = "Antonio";
select * from `PregoSistema`.`Devedor` where `PregoSistema`.`Devedor`.`Usuario_UserNome` = "Antonio";

DELETE FROM `PregoSistema`.`Usuario` WHERE `UserNome`='Bela' and `Senha` = "123456";
