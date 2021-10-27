create schema tarefas;
use tarefas;

create table colaborador(
id                    int not null auto_increment primary key,
nome                Varchar(30) not null,
data_nascimento        Date
);


create table tarefa(
id                    int not null auto_increment primary key,
id_colaborador        int not null,
descricao            Varchar(50),
data_inicio            Date,
data_fim            Date,
status                Varchar(15),
prioridade            Varchar(15)
);


alter table tarefa add foreign key (id_colaborador)
                    references colaborador(id);

alter table colaborador modify column nomeColaborador Varchar(30);

desc colaborador;
desc tarefa;

select * from colaborador;
select * from tarefa t ;