CREATE TABLE paciente
(
   codigo_pessoa int PRIMARY KEY auto_increment,
   nome varchar(50),
   cpf varchar(30),
   email varchar(50),
   telefone char(15),
   dataNascimento date
) ENGINE=InnoDB;

CREATE TABLE medico
(
   nome varchar(50),
   cpf varchar(30),
   email varchar(50),
   telefone char(15),
   dataNascimento date,
   flag boolean,
   especialidade varchar(50)
) ENGINE=InnoDB;

CREATE TABLE agenda
(
   nome varchar(50),
   email varchar(50),
   especialidade varchar(50),
   nomeMedico varchar(50),
   especialidade varchar(50),
   dataConsulta date,
   horarioConsulta int
) ENGINE=InnoDB;

INSERT INTO medico VALUES ('medico 1', '111.111.111-11', 'medico1@mail.com', '4444-4444', '18/25/1982', 'True', 'Cardiologista')
INSERT INTO medico VALUES ('medico 2', '222.222.222-222', 'medico2@mail.com', '2222-2222', '18/25/1982', 'True', 'Cardiologista')
INSERT INTO medico VALUES ('medico 3', '333.333.333-33', 'medico3@mail.com', '8888-8888', '18/25/1982', 'True', 'Cardiologista')
INSERT INTO medico VALUES ('medico 4', '999.999.999-99', 'medico9@mail.com', '7777-6666', '18/25/1982', 'True', 'Ortopedista')