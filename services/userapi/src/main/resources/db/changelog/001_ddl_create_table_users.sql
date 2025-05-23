create table if not exists users (
    id serial primary key,
    name varchar(2000) NOT NULL unique,
    password varchar(2000) NOT NULL,
    email varchar(1000) NOT NULL
);