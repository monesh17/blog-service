create table blog
(
    id      uuid not null primary key,
    user_id int not null,
    created_at timestamp not null,
    updated_at timestamp ,
    deleted_at timestamp ,
    content jsonb not null
);
