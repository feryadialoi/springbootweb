create table products
(
    id       bigint auto_increment primary key,
    name     varchar(255),
    price    decimal(19, 2),
    quantity decimal(19, 2)
);