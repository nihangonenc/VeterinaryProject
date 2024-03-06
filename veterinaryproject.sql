PGDMP      8                |         
   veterinary    16.1    16.1 3    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17369 
   veterinary    DATABASE     ~   CREATE DATABASE veterinary WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE veterinary;
                postgres    false            �            1259    17371    animals    TABLE     H  CREATE TABLE public.animals (
    animal_id bigint NOT NULL,
    animal_breed character varying(255),
    animal_colour character varying(255),
    date_of_birth date,
    animal_gender character varying(255),
    animal_name character varying(255) NOT NULL,
    animal_species character varying(255),
    customer_id bigint
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    17370    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    216            �           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    215            �            1259    17380    appointments    TABLE     �   CREATE TABLE public.appointments (
    appointment_id bigint NOT NULL,
    appointment_date timestamp(6) without time zone,
    animal_id bigint,
    doctor_id bigint
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    17379    appointments_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointments_appointment_id_seq;
       public          postgres    false    218            �           0    0    appointments_appointment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointments_appointment_id_seq OWNED BY public.appointments.appointment_id;
          public          postgres    false    217            �            1259    17387    available_dates    TABLE     t   CREATE TABLE public.available_dates (
    date_id bigint NOT NULL,
    available_date date,
    doctor_id bigint
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    17386    available_dates_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.available_dates_date_id_seq;
       public          postgres    false    220            �           0    0    available_dates_date_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.available_dates_date_id_seq OWNED BY public.available_dates.date_id;
          public          postgres    false    219            �            1259    17394 	   customers    TABLE     "  CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_city character varying(255),
    customer_mail character varying(255),
    customer_name character varying(255) NOT NULL,
    customer_phone character varying(255)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    17393    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    222            �           0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    221            �            1259    17403    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(255),
    doctor_city character varying(255),
    doctor_mail character varying(255),
    doctor_name character varying(255) NOT NULL,
    doctor_phone character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    17402    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    224            �           0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    223            �            1259    17412    vaccines    TABLE       CREATE TABLE public.vaccines (
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(255) NOT NULL,
    vaccine_name character varying(255) NOT NULL,
    protection_finish_date date NOT NULL,
    protection_start_date date NOT NULL,
    animal_id bigint
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    17411    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    226            �           0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    225            3           2604    17374    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    216    215    216            4           2604    17383    appointments appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointments_appointment_id_seq'::regclass);
 J   ALTER TABLE public.appointments ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    217    218    218            5           2604    17390    available_dates date_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN date_id SET DEFAULT nextval('public.available_dates_date_id_seq'::regclass);
 F   ALTER TABLE public.available_dates ALTER COLUMN date_id DROP DEFAULT;
       public          postgres    false    220    219    220            6           2604    17397    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    221    222    222            7           2604    17406    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    223    224    224            8           2604    17415    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    225    226    226            �          0    17371    animals 
   TABLE DATA           �   COPY public.animals (animal_id, animal_breed, animal_colour, date_of_birth, animal_gender, animal_name, animal_species, customer_id) FROM stdin;
    public          postgres    false    216   �=       �          0    17380    appointments 
   TABLE DATA           ^   COPY public.appointments (appointment_id, appointment_date, animal_id, doctor_id) FROM stdin;
    public          postgres    false    218   �>       �          0    17387    available_dates 
   TABLE DATA           M   COPY public.available_dates (date_id, available_date, doctor_id) FROM stdin;
    public          postgres    false    220   ?       �          0    17394 	   customers 
   TABLE DATA              COPY public.customers (customer_id, customer_address, customer_city, customer_mail, customer_name, customer_phone) FROM stdin;
    public          postgres    false    222   s?       �          0    17403    doctors 
   TABLE DATA           q   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_mail, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    224   %@       �          0    17412    vaccines 
   TABLE DATA           �   COPY public.vaccines (vaccine_id, vaccine_code, vaccine_name, protection_finish_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    226   �@       �           0    0    animals_animal_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animals_animal_id_seq', 8, true);
          public          postgres    false    215            �           0    0    appointments_appointment_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.appointments_appointment_id_seq', 12, true);
          public          postgres    false    217            �           0    0    available_dates_date_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.available_dates_date_id_seq', 13, true);
          public          postgres    false    219            �           0    0    customers_customer_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.customers_customer_id_seq', 6, true);
          public          postgres    false    221            �           0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 6, true);
          public          postgres    false    223            �           0    0    vaccines_vaccine_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 13, true);
          public          postgres    false    225            :           2606    17378    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    216            <           2606    17385    appointments appointments_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    218            >           2606    17392 $   available_dates available_dates_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (date_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    220            @           2606    17401    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    222            B           2606    17410    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    224            D           2606    17419    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    226            F           2606    17425 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    216    218    4666            E           2606    17420 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    222    4672    216            I           2606    17440 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    4666    216    226            G           2606    17430 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(doctor_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    218    4674    224            H           2606    17435 +   available_dates fknb419ilm71d71rm584rk460pk    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fknb419ilm71d71rm584rk460pk FOREIGN KEY (doctor_id) REFERENCES public.doctors(doctor_id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fknb419ilm71d71rm584rk460pk;
       public          postgres    false    4674    220    224            �   �   x�3��IL*JL�/�tJ�L��420��50"Nע��l΀���lN���
�#.SΠ�����̜�"������#C-U��%�y=�`��p�����8]2�����)-(���NM��4�2�N��/�,��t/�)6�*���]��YQl����� o�8�      �   V   x�U��	� ���d�.��h�Y���b���}�p�Tԓh.��#��ėؔ�,)S�K�8CvTb����S����Of��I �      �   X   x�U�A�0D�u�.50�h����!M����g�PhUXŊ��lIڢj��$Ηm�׺rGR�*��Y�bc:�h��g܋C���=� �      �   �   x�]�A
�@Eי�5q���	��À�:B��<�W���ޫ2mE�I>^�sx=BϾ��&�('CߵV2ӵp�H�&}D�Pw�m���]�~o$9�����^C��^*��<
4"U�9J�שּׂ�v/$�i)�4\B���VN�����7	.�(5�eJ�7>A\�      �   �   x�U�M
�0F�3�L&�m�tS�A7ӘB�'��^�+�w���)h<���i6�]�Cg���#�j8�р�JQB)
ȹ�/hm�~�o��l $IL�gm��{�Kn���g@�R����Ɗ܌7�y���p�@f+�m��0��S��!�� Q�      �   �   x����
!����S���u�KP�N]�փ`�nP϶�}�F"h!���ʨA�ah�2+E���䚌,F�ާ��������L�"W��iъ6�kb��G��
1�����'�{��z��ŵP��-���16�p�d��{t[�u�_p��	�ϫ�1�KD|�SI     