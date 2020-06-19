drop table if exists USERS;
drop table if exists country;

CREATE TABLE customer_invoice(
  id int not null AUTO_INCREMENT PRIMARY KEY,
  seller_name varchar(100) not null,
  buyer_name varchar(100) not null,
  invoice_number varchar(100),
  invoice_date date,
  status boolean
);

CREATE TABLE invoice_items(
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  invoice_id int,
  product_name varchar(100) not null,
  product_desc varchar(100) not null,
  quantity int,
  price double,
  FOREIGN KEY (invoice_id) references customer_invoice(id)
);