drop table eng;
drop table rus;
create table rus
(
    id int not null generated always as identity(start with 1, increment by 1),
    rus varchar(255) primary key,
    constraint uk_rus_id unique (id)
);


create table Eng
(
    id int not null generated always as identity(start with 1, increment by 1),
    eng varchar(40) not null,
    rus int,
    constraint fk_eng_rus foreign key (rus) references rus(id),
    constraint uk_eng_id unique (id),
    constraint pk_eng primary key (eng)
);

insert into rus(rus) values('стол');