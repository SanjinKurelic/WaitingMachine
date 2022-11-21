create table entrance_counter (
  id serial primary key,
  counter bigint not null,
  "check_time" timestamp default CURRENT_TIMESTAMP
);
