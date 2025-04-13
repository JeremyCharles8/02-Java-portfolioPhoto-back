BEGIN;

DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS "album";
DROP TABLE IF EXISTS "photo_metadata";

CREATE TABLE "user" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "email" text NOT NULL UNIQUE,
  "password" text NOT NULL,
  "created_at" timestamptz NOT NULL DEFAULT now(),
  "updated_at" timestamptz
);

CREATE TABLE "album" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "name" text NOT NULL UNIQUE,
  "created_at" timestamptz NOT NULL DEFAULT now(),
  "updated_at" timestamptz
);

CREATE TABLE "photo_metadata" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "file_name" text NOT NULL UNIQUE,
  "title" text UNIQUE,
  "caption" text,
  "img_url" text NOT NULL UNIQUE,
  "img_thumbnail_url" text NOT NULL UNIQUE,
  "album_id" int REFERENCES "album" ("id") ON DELETE SET NULL,
  "created_at" timestamptz NOT NULL DEFAULT now(),
  "updated_at" timestamptz
);

COMMIT;