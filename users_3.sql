CREATE TABLE IF NOT EXISTS public.users
(
    id integer,
    login character varying(100),
    password character varying(100),
    CONSTRAINT user_pkey PRIMARY KEY (id)
)
