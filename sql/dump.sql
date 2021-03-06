PGDMP     9            	        y           scootercritic #   12.6 (Ubuntu 12.6-0ubuntu0.20.04.1) #   12.6 (Ubuntu 12.6-0ubuntu0.20.04.1)     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24577    scootercritic    DATABASE        CREATE DATABASE scootercritic WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE scootercritic;
                fpw    false            ?            1259    24678    monopattino    TABLE     ?   CREATE TABLE public.monopattino (
    id integer NOT NULL,
    nome character varying(20),
    modello character varying(20),
    descrizione character varying(250),
    prezzo double precision,
    foto character varying(200)
);
    DROP TABLE public.monopattino;
       public         heap    fpw    false            ?            1259    24676    monopattino_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.monopattino_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.monopattino_id_seq;
       public          fpw    false    204            ?           0    0    monopattino_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.monopattino_id_seq OWNED BY public.monopattino.id;
          public          fpw    false    203            ?            1259    24695 
   recensione    TABLE     ?   CREATE TABLE public.recensione (
    id integer NOT NULL,
    voto integer,
    commento character varying(250),
    data timestamp without time zone,
    num_like integer,
    utente_id character varying(20),
    monopattino_id bigint
);
    DROP TABLE public.recensione;
       public         heap    fpw    false            ?            1259    24693    recensione_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.recensione_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.recensione_id_seq;
       public          fpw    false    206            ?           0    0    recensione_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.recensione_id_seq OWNED BY public.recensione.id;
          public          fpw    false    205            ?            1259    24711    segnalazione    TABLE     ?   CREATE TABLE public.segnalazione (
    id integer NOT NULL,
    oggetto character varying(100),
    testo character varying(250),
    data timestamp without time zone,
    utente_id character varying(20)
);
     DROP TABLE public.segnalazione;
       public         heap    fpw    false            ?            1259    24709    segnalazione_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.segnalazione_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.segnalazione_id_seq;
       public          fpw    false    208            ?           0    0    segnalazione_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.segnalazione_id_seq OWNED BY public.segnalazione.id;
          public          fpw    false    207            ?            1259    24671    utente    TABLE     ?   CREATE TABLE public.utente (
    username character varying(20) NOT NULL,
    password character varying(20),
    nome character varying(50),
    cognome character varying(50),
    email character varying(50),
    foto character varying(200)
);
    DROP TABLE public.utente;
       public         heap    fpw    false                       2604    24681    monopattino id    DEFAULT     p   ALTER TABLE ONLY public.monopattino ALTER COLUMN id SET DEFAULT nextval('public.monopattino_id_seq'::regclass);
 =   ALTER TABLE public.monopattino ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    203    204    204                       2604    24698    recensione id    DEFAULT     n   ALTER TABLE ONLY public.recensione ALTER COLUMN id SET DEFAULT nextval('public.recensione_id_seq'::regclass);
 <   ALTER TABLE public.recensione ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    206    205    206                        2604    24714    segnalazione id    DEFAULT     r   ALTER TABLE ONLY public.segnalazione ALTER COLUMN id SET DEFAULT nextval('public.segnalazione_id_seq'::regclass);
 >   ALTER TABLE public.segnalazione ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    208    207    208            ?          0    24678    monopattino 
   TABLE DATA           S   COPY public.monopattino (id, nome, modello, descrizione, prezzo, foto) FROM stdin;
    public          fpw    false    204   ?#       ?          0    24695 
   recensione 
   TABLE DATA           c   COPY public.recensione (id, voto, commento, data, num_like, utente_id, monopattino_id) FROM stdin;
    public          fpw    false    206   ?$       ?          0    24711    segnalazione 
   TABLE DATA           K   COPY public.segnalazione (id, oggetto, testo, data, utente_id) FROM stdin;
    public          fpw    false    208   H%       ?          0    24671    utente 
   TABLE DATA           P   COPY public.utente (username, password, nome, cognome, email, foto) FROM stdin;
    public          fpw    false    202   ?%       ?           0    0    monopattino_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.monopattino_id_seq', 4, true);
          public          fpw    false    203            ?           0    0    recensione_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.recensione_id_seq', 5, true);
          public          fpw    false    205            ?           0    0    segnalazione_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.segnalazione_id_seq', 4, true);
          public          fpw    false    207            $           2606    24692    monopattino monopattino_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.monopattino
    ADD CONSTRAINT monopattino_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.monopattino DROP CONSTRAINT monopattino_pkey;
       public            fpw    false    204            &           2606    24723    recensione recensione_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT recensione_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.recensione DROP CONSTRAINT recensione_pkey;
       public            fpw    false    206            (           2606    24716    segnalazione segnalazione_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.segnalazione
    ADD CONSTRAINT segnalazione_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.segnalazione DROP CONSTRAINT segnalazione_pkey;
       public            fpw    false    208            "           2606    24675    utente utente_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (username);
 <   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_pkey;
       public            fpw    false    202            *           2606    24704 )   recensione recensione_monopattino_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT recensione_monopattino_id_fkey FOREIGN KEY (monopattino_id) REFERENCES public.monopattino(id) ON UPDATE CASCADE;
 S   ALTER TABLE ONLY public.recensione DROP CONSTRAINT recensione_monopattino_id_fkey;
       public          fpw    false    204    206    2852            )           2606    24699 $   recensione recensione_utente_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.recensione
    ADD CONSTRAINT recensione_utente_id_fkey FOREIGN KEY (utente_id) REFERENCES public.utente(username) ON UPDATE CASCADE;
 N   ALTER TABLE ONLY public.recensione DROP CONSTRAINT recensione_utente_id_fkey;
       public          fpw    false    202    2850    206            +           2606    24717 (   segnalazione segnalazione_utente_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.segnalazione
    ADD CONSTRAINT segnalazione_utente_id_fkey FOREIGN KEY (utente_id) REFERENCES public.utente(username) ON UPDATE CASCADE;
 R   ALTER TABLE ONLY public.segnalazione DROP CONSTRAINT segnalazione_utente_id_fkey;
       public          fpw    false    208    2850    202            ?   ?   x?]?=N?@?k??Q?????b?U@THh?X`iv^???p????
????O?G:!F}'t?6%u????E??x??͹?%ga/,??M??0?k?5?m????v?KĞi?!p	???Բ^??sG?1?7f?<4????Yh?]R?H??Ų??U????U?R?h?OM?^??p͚pQ?????6?f.?.A??W?m->???۩?^???~)Nq?      ?   ?   x?M??
!???S?l??t?Ν?ᖄ?;??=??~??????c??? Ij?v?ZHy?(H??m`5(l?/uKN??s?+????in_A?~5???$;#x??4?F??5????>,O?w:v?a.?£??#"~,?6?      ?   ?   x?E?A
?0??ur??@%i?
??2???L:m6??V?¿x>o
>#(E?9	?0?+?׃f??7??S?)?(˲),??2????k?P$?BjZ?????k???7????s?;?yn???ը?e?6??ʘ	Mp?'Cӹ]F?,??^????:4      ?   ?   x?M?M?0Dϓ??x????I??.4ٲ???mB
=?????p?t??$??f????S֥???Ҩ[?𫣧ЫF>?M?jW?qI?N:B.?7eSm?"d??2??`?1?X:\??lhB???5.Λ?R䍙?1X?9,ɍ???	?x#???VJ??X?     