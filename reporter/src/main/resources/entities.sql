create table if not exists users (
    id serial primary key,
    login varchar(32) unique not null
);
insert into users(login) select concat('name-', floor(random() * 10000));


create table if not exists house (
    id serial primary key,
    user_id int references users(id) not null,
    name varchar(32) unique not null
);
insert into house(user_id, name) SELECT currval('users_id_seq'), concat('house-', floor(random() * 10000));

create table if not exists device_type (
    id serial primary key,
    name varchar(32) unique not null
);
insert into device_type(name) select concat('type-', floor(random() * 10000));

create table if not exists modules (
    id serial primary key,
    name varchar(32) unique not null
);
insert into modules(name) select concat('module-', floor(random() * 10000));

create table if not exists device (
    id serial primary key,
    type_id int references device_type(id) not null,
    house_id int references house(id) not null,
    modules_id int references modules(id) not null,
    serial_number varchar(32) not null,
    name varchar(32) unique not null
);
insert into device(type_id, house_id, modules_id, serial_number, name)
select currval('device_type_id_seq'), currval('house_id_seq'), currval('modules_id_seq'),
concat('serial-', floor(random() * 10000)), concat('device-', floor(random() * 10000));

create table if not exists telemetry_data (
    id bigserial primary key,
    device_id int references device(id) not null,
    stream text,
    temperature float,
    ins timestamp default current_timestamp
);