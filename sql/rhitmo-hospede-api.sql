CREATE TABLE "booking" (
                           "id" int4 NOT NULL GENERATED ALWAYS AS IDENTITY (
                               INCREMENT 1
                               MINVALUE  1
                               MAXVALUE 2147483647
                               ),
                           "check_in" timestamp NOT NULL,
                           "check_out" timestamp NOT NULL,
                           "total_amount" decimal(10,2) NOT NULL,
                           "room_id" int4 NOT NULL,
                           "user_id" int4 NOT NULL,
                           "status" int2 NOT NULL,
                           PRIMARY KEY ("id")
);

CREATE TABLE "room" (
                        "id" int4 NOT NULL GENERATED ALWAYS AS IDENTITY (
                            INCREMENT 1
                            MINVALUE  1
                            MAXVALUE 2147483647
                            ),
                        "amount" decimal(10,2) NOT NULL,
                        "description" varchar(255) NOT NULL,
                        "available" bool NOT NULL,
                        PRIMARY KEY ("id")
);

CREATE TABLE "user" (
                        "id" int4 NOT NULL GENERATED ALWAYS AS IDENTITY (
                            INCREMENT 1
                            MINVALUE  1
                            MAXVALUE 2147483647
                            ),
                        "name" varchar(255) NOT NULL,
                        "email" varchar(255) NOT NULL,
                        "cpf" varchar(255) NOT NULL,
                        PRIMARY KEY ("id")
);

ALTER TABLE "booking" ADD CONSTRAINT "user_id_fk" FOREIGN KEY ("user_id") REFERENCES "user" ("id") ON DELETE RESTRICT ON UPDATE NO ACTION;
ALTER TABLE "booking" ADD CONSTRAINT "room_id_fk" FOREIGN KEY ("room_id") REFERENCES "room" ("id") ON DELETE RESTRICT ON UPDATE NO ACTION;

