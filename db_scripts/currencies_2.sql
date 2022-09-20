CREATE TABLE IF NOT EXISTS public.currencies
(
    id character varying(7),
    nominal integer,
    name character varying(100),
    value numeric(7,4),
    numcode character(3),
    charcode character(3)
)