create table if not exists subscriptions (
    id serial primary key,
    userId bigint NOT NULL,
    serviceName varchar(1000) NOT NULL
);