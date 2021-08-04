create table blog
(
    id      uuid not null primary key,
    userId int not null,
    createdAt timestamp not null,
    updatedAt timestamp ,
    deletedAt timestamp ,
    content jsonb not null
);
