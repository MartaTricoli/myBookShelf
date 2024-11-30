


    alter table authors 
       drop 
       foreign key FK8nii7qawljvkdmydl5gs68kfe;

    alter table authors 
       drop 
       foreign key FKay0a8ugtrye0pl9aj3m1gsee0;

    alter table authors_read 
       drop 
       foreign key FKc6j94yn6dsdn5v6aslil7nhv4;

    alter table authors_read 
       drop 
       foreign key FKjkfiqvk6ise57kd4vqk821mlq;

    alter table books 
       drop 
       foreign key FK4ih38omjrl63dv9509hddgyia;

    alter table books 
       drop 
       foreign key FKi8maj9nicexval075vmojs5y9;

    alter table books 
       drop 
       foreign key FKmg0386dhfml5469mum743bg9a;

    alter table books_read 
       drop 
       foreign key FKmndknyikl0qdijpvh8o5nhflg;

    alter table books_read 
       drop 
       foreign key FKr4fp5w113jbsth8y5xac7wnep;

    drop table if exists authors;

    drop table if exists authors_read;

    drop table if exists books;

    drop table if exists books_read;

    drop table if exists countries;

    drop table if exists error_messages;

    drop table if exists genres;

    drop table if exists languages;

    drop table if exists sex;

    drop table if exists users;

    create table authors (
        id integer not null auto_increment,
        id_country integer,
        id_sex integer,
        last_name varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table authors_read (
        id_author integer not null,
        user_id integer not null
    ) engine=InnoDB;

    create table books (
        id integer not null auto_increment,
        id_author integer,
        id_genres integer,
        id_original_language integer,
        year_of_publication integer,
        original_title varchar(255),
        title varchar(255),
        url_image varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table books_read (
        id integer not null auto_increment,
        id_book integer not null,
        n_readings integer,
        user_id integer not null,
        end_reading varchar(255),
        start_reading varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table countries (
        id integer not null auto_increment,
        description varchar(250),
        primary key (id)
    ) engine=InnoDB;

    create table error_messages (
        codice varchar(255) not null,
        message varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table genres (
        id integer not null auto_increment,
        description varchar(250),
        primary key (id)
    ) engine=InnoDB;

    create table languages (
        id integer not null auto_increment,
        description varchar(250),
        primary key (id)
    ) engine=InnoDB;

    create table sex (
        id integer not null auto_increment,
        description varchar(250),
        primary key (id)
    ) engine=InnoDB;

    create table users (
        user_id integer not null auto_increment,
        email varchar(255),
        password varchar(255),
        user_name varchar(255),
        primary key (user_id)
    ) engine=InnoDB;

    alter table authors 
       add constraint FK8nii7qawljvkdmydl5gs68kfe 
       foreign key (id_country) 
       references countries (id);

    alter table authors 
       add constraint FKay0a8ugtrye0pl9aj3m1gsee0 
       foreign key (id_sex) 
       references sex (id);

    alter table authors_read 
       add constraint FKc6j94yn6dsdn5v6aslil7nhv4 
       foreign key (user_id) 
       references users (user_id);

    alter table authors_read 
       add constraint FKjkfiqvk6ise57kd4vqk821mlq 
       foreign key (id_author) 
       references authors (id);

    alter table books 
       add constraint FK4ih38omjrl63dv9509hddgyia 
       foreign key (id_author) 
       references authors (id);

    alter table books 
       add constraint FKi8maj9nicexval075vmojs5y9 
       foreign key (id_genres) 
       references genres (id);

    alter table books 
       add constraint FKmg0386dhfml5469mum743bg9a 
       foreign key (id_original_language) 
       references languages (id);

    alter table books_read 
       add constraint FKmndknyikl0qdijpvh8o5nhflg 
       foreign key (user_id) 
       references users (user_id);

    alter table books_read 
       add constraint FKr4fp5w113jbsth8y5xac7wnep 
       foreign key (id_book) 
       references books (id);
