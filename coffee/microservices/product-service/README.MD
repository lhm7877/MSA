create table product.product
(
product_id serial not null
constraint product_pk
primary key,
name       varchar(64),
price      numeric,
content    varchar(200)
);

alter table product.product
owner to postgres;

