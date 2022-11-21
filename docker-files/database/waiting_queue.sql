create table waiting_queue (
  id serial primary key,
  ticket_number bigint not null,
  arrival_time timestamp default CURRENT_TIMESTAMP,
  status varchar(20) not null
);

insert into waiting_queue (ticket_number, status) values
(1, 'FINISHED'),
(2, 'FINISHED'),
(3, 'FINISHED'),
(4, 'FINISHED'),
(5, 'FINISHED'),
(6, 'FINISHED'),
(7, 'FINISHED'),
(8, 'FINISHED'),
(9, 'FINISHED'),
(10, 'FINISHED'),
(11, 'FINISHED'),
(12, 'FINISHED'),
(13, 'FINISHED'),
(14, 'FINISHED');
