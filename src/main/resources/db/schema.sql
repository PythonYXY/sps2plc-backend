create table iomap
(
    id         int auto_increment
        primary key,
    io_name    varchar(255) null,
    io_number  varchar(255) null,
    project_id int          not null
)
    charset = utf8;

create table requirement
(
    id                int auto_increment
        primary key,
    disabled          tinyint(1)   not null,
    error_description text         null,
    project           int          not null,
    state             varchar(255) not null,
    text              text         not null
)
    charset = utf8;

create table task
(
    project_id   int          not null
        primary key,
    code         text         null,
    description  varchar(255) null,
    requirements text         null,
    status       varchar(255) null,
    timestamp    timestamp    not null
)
    charset = utf8;



create table project
(
    id          int auto_increment
        primary key,
    description text         null,
    name        varchar(255) not null,
    userId      int          not null,
    constraint project_user_id_fk
        foreign key (userId) references user (id)
)
    charset = utf8;

create table user
(
    id       int auto_increment
        primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint user_username_uindex
        unique (username)
);