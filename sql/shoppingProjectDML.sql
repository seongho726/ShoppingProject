insert into shoppinguser values(shoppinguser_id_seq.nextval, 'A', 'Admin', 'aaaaa','admin@example.com', '010-000-0000', 'Korea');
insert into shoppinguser values(shoppinguser_id_seq.nextval, 'C', 'Customer1', 'bbbbb','customer1@example.com', '010-000-0001', 'Korea');
insert into shoppinguser values(shoppinguser_id_seq.nextval, 'C', 'Customer2', 'ccccc','customer2@example.com', '010-000-0002', 'Korea');

insert into shoppingproduct values(1, 'Phone', 'iPhone12', 'The most advanced phone in the universe.', 2000, 100);
insert into shoppingproduct values(2, 'Phone', 'Galaxy20', 'The most beautiful phone in the universe.', 1000, 50);
insert into shoppingproduct values(3, 'Earphone', 'Galaxybuds', 'The most advanced earphone in the universe.', 100, 20);

commit;
