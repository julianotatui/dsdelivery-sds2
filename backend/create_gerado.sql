create table tb_order (id bigint generated by default as identity, address varchar(255), latitude double not null, longitude double not null, moment timestamp, status integer, primary key (id));
create table tb_order_product (order_id bigint not null, product_id bigint not null, primary key (order_id, product_id));
create table tb_product (id bigint generated by default as identity, description varchar(255), image_uri varchar(255), name varchar(255), price double not null, primary key (id));
alter table tb_order_product add constraint FKsu03ywlcvyqg5y78qey2q25lc foreign key (product_id) references tb_product;
alter table tb_order_product add constraint FK40anaevs16kmc2tbh7wc511fq foreign key (order_id) references tb_order;
