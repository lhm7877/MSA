create table order_goods (id bigint not null, discount_percent decimal(5,2), discounted_price decimal(5,2), menu_id bigint not null, original_price decimal(5,2), parent_menu_id bigint, orders_history_id bigint, orders_id bigint, order_goods_id bigint, primary key (id))
create table ordersEntity (id bigint not null, created_date timestamp, last_modified_date timestamp, cancel_reason varchar(255), cancel_yn boolean not null, discount_percent decimal(5,2), discounted_price decimal(5,2), member_id bigint not null, original_price decimal(5,2), payment_type varchar(255), primary key (id))
create table orders_history (id bigint not null, created_date timestamp, last_modified_date timestamp, cancel_yn boolean not null, discount_percent decimal(5,2), discounted_price decimal(5,2), member_id bigint not null, order_id bigint, original_price decimal(5,2), payment_type varchar(255), primary key (id))
create index IDXl0y916r9eio4o71bifle7salj on order_goods (menu_id)
create index IDXbo59bkocqki6yk1ivm4w4po7w on ordersEntity (member_id)
create index IDX90cpwi0n7pnkdgd1i8vq8d1ns on ordersEntity (payment_type)
alter table order_goods add constraint FK3otsn9q5p9g2rldqocj8qp4ht foreign key (orders_history_id) references orders_history
alter table order_goods add constraint FKfqbiq57qj8pvhf4d5en6fn4e3 foreign key (orders_id) references ordersEntity
alter table order_goods add constraint FKo53ncoc00uggmbx15bkawghlb foreign key (order_goods_id) references order_goods