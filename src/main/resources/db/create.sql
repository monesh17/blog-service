create table blog
(
    id         uuid      not null primary key,
    name       varchar   not null,
    tags       jsonb,
    user_name  varchar   not null,
    created_at timestamp not null,
    updated_at timestamp,
    deleted_at timestamp,
    content    jsonb     not null
);
