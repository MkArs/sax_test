CREATE TABLE IF NOT EXISTS public.authorities
(
    username character varying(15),
    authority character varying(25),
    CONSTRAINT authorities_username_fkey FOREIGN KEY (username)
        REFERENCES public.users (username)
)