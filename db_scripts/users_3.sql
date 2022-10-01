CREATE TABLE IF NOT EXISTS public.users
(
    username character varying(15),
    password character varying(100),
    enabled smallint,
    CONSTRAINT users_pkey PRIMARY KEY (username)
)
