
    drop table if exists users;

    create table users (
        user_id integer not null auto_increment,
        email varchar(255),
        password varchar(255),
        user_name varchar(255),
        primary key (user_id)
    ) engine=InnoDB;
