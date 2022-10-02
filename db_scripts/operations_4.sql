CREATE TABLE IF NOT EXISTS public.operations
(
    id SERIAL,
    fromcurrency character varying(100),
    tocurrency character varying(100),
    date date,
    sum numeric(20,4),
    result numeric(20,4),
    username character varying(15),
    CONSTRAINT operation_pkey PRIMARY KEY (id),
    CONSTRAINT operations_username_fkey FOREIGN KEY (username)
        REFERENCES public.users (username)
)
