DROP TABLE IF EXISTS "public"."apply_up_channel";
CREATE TABLE "public"."apply_up_channel" (
                                           "id" serial8,
                                           channel_id int2,
                                           user_id int2,
                                           creation_time timestamp(6),
                                           modify_time timestamp(6)
);
COMMENT ON COLUMN "public"."apply_up_channel"."id" IS '主键id';
COMMENT ON COLUMN "public"."apply_up_channel"."channel_id" IS '频道id';
COMMENT ON COLUMN "public"."apply_up_channel"."user_id" IS '用户Id';
COMMENT ON COLUMN "public"."apply_up_channel"."creation_time" IS '创建时间';
COMMENT ON TABLE "public"."apply_up_channel" IS '用户报名表';
ALTER TABLE "public"."apply_up_channel" ADD CONSTRAINT "apply_up_channel_pkey" PRIMARY KEY ("id");

ALTER TABLE channel_resume_template add COLUMN abbreviation VARCHAR(25);
