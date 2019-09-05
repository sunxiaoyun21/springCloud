DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "id" serial8,
	name VARCHAR(50),
	gender VARCHAR(50),
	mobile VARCHAR(25),
	creation timestamp(6)
);
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");