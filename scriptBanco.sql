CREATE database PregoSistema;
Use PregoSistema;

CREATE TABLE IF NOT EXISTS `PregoSistema`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC)
)
ENGINE = InnoDB;


CREATE TABLE  IF NOT EXISTS `PregoSistema`.`Devedor` (
	`idDevedor` INT NOT NULL AUTO_INCREMENT,
	`Nome` VARCHAR(255) NOT NULL,
	`Cidade` VARCHAR(45) NULL,
	`Bairro` VARCHAR(45) NULL,
	`Rua` VARCHAR(255) NULL,
	`Complemento` VARCHAR(255) NULL,
	`Telefone1` VARCHAR(14) NULL,
	`Telefone2` VARCHAR(14) NULL,
	`Usuario_idUsuario` INT NOT NULL,
    Primary key (`idDevedor`),
    UNIQUE INDEX `idDevedor_UNIQUE` (`idDevedor` ASC),
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `PregoSistema`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE -- ao excluir um usuario exclui-se os devedores 
    ON update cascade --  o mesmo de cima só que ao atualizar
)
ENGINE = InnoDB;

create table if not exists `PregoSistema`.`Divida`(
	`idDevedor` INT NOT NULL,
	`Valor` DOUBLE NOT NULL,
	`Especificacao` VARCHAR(255) NULL,
	`Status` VARCHAR(45) NOT NULL,
	`Datadeabertura` DATE NOT NULL, -- data de cadastro da divida
	`Datadefechamento` DATE NULL, -- data que o usuario acredita ser pago
    `DatadePagamento` DATE NULL, -- data em que o usuario muda o status da divida para pago
     Primary key (`idDevedor`),
    UNIQUE INDEX `idDevedor_UNIQUE` (`idDevedor` ASC), -- idDevedor é chave primaria e estrangeira
    FOREIGN KEY (`idDevedor`)
    REFERENCES `PregoSistema`.`Devedor` (`idDevedor`)
	on delete cascade
    on update cascade
)
ENGINE = InnoDB;

-- ----------------------------------------------------------------------------------------------------
-- TESTES

insert into `PregoSistema`.`Usuario` (nome) values ("Antonio");

select * from `PregoSistema`.`Usuario`;

select * from `PregoSistema`.`Devedor`;



delete from `PregoSistema`.`Usuario` where `Usuario`.`idUsuario` = 2;


