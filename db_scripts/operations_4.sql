CREATE TABLE IF NOT EXISTS public.operations
(
    id integer,
    fromcurrency character varying(100),
    tocurrency character varying(100),
    date date,
    sum numeric(20,4),
    result numeric(20,4),
    CONSTRAINT operation_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (id)
        REFERENCES public.users (id)
)
