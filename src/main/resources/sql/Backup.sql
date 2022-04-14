CREATE DATABASE `projeto_crud` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- projeto_crud.tb_perfil definition

CREATE TABLE `tb_perfil` (
                             `idPerfil` int NOT NULL AUTO_INCREMENT,
                             `nomePerfil` varchar(45) NOT NULL,
                             PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3

INSERT INTO projeto_crud.tb_perfil (nomePerfil) VALUES('Cliente');
INSERT INTO projeto_crud.tb_perfil (nomePerfil) VALUES('Funcionario');

-- projeto_crud.tb_credenciais definition

CREATE TABLE `tb_credenciais` (
                                  `idUsuario` int NOT NULL AUTO_INCREMENT,
                                  `usuario` text NOT NULL,
                                  `senha` text NOT NULL,
                                  `idPerfil` int NOT NULL DEFAULT '1',
                                  PRIMARY KEY (`idUsuario`),
                                  KEY `idPerfil_idx` (`idPerfil`),
                                  CONSTRAINT `idPerfil` FOREIGN KEY (`idPerfil`) REFERENCES `tb_perfil` (`idPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- projeto_crud.tb_clientes definition

CREATE TABLE `tb_clientes` (
                               `idUsuario` int NOT NULL,
                               `nomeCliente` text NOT NULL,
                               `sobrenome` text NOT NULL,
                               `dataNascimento` date NOT NULL,
                               `telefone` varchar(45) NOT NULL,
                               `cpf` varchar(45) NOT NULL,
                               `rg` varchar(45) NOT NULL,
                               PRIMARY KEY (`idUsuario`),
                               KEY `id_idx` (`idUsuario`) /*!80000 INVISIBLE */,
                               CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `tb_credenciais` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- projeto_crud.tb_enderecos definition

CREATE TABLE `tb_enderecos` (
                                `idEndereco` int NOT NULL AUTO_INCREMENT,
                                `cep` varchar(45) NOT NULL,
                                `nomeEndereco` varchar(200) NOT NULL,
                                `bairro` varchar(45) NOT NULL,
                                `estado` varchar(45) NOT NULL,
                                `isPrincipal` tinyint(1) NOT NULL DEFAULT '0',
                                `idUsuario` int NOT NULL,
                                PRIMARY KEY (`idEndereco`),
                                KEY `idUsuario_idx` (`idUsuario`),
                                CONSTRAINT `idUsuarioEndereco` FOREIGN KEY (`idUsuario`) REFERENCES `tb_clientes` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
