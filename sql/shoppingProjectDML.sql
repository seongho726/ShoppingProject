insert into shoppinguser values('admin', 'A', 'Admin', '11','admin@example.com', '010-000-0000', 'Korea');
insert into shoppinguser values('customer1', 'C', 'Customer1', '22','customer1@example.com', '010-000-0001', 'Korea');
insert into shoppinguser values('customer2', 'C', 'Customer2', '33','customer2@example.com', '010-000-0002', 'Korea');

insert into shoppingproduct values(shoppingproduct_id_seq.nextval, 'Phone', 'iPhone12', 'The most advanced phone in the universe.', 2000, 100);
insert into shoppingproduct values(shoppingproduct_id_seq.nextval, 'Phone', 'Galaxy20', 'The most beautiful phone in the universe.', 1000, 50);
insert into shoppingproduct values(shoppingproduct_id_seq.nextval, 'Earphone', 'Galaxybuds', 'The most advanced earphone in the universe.', 100, 20);

commit;
