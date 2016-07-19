CREATE TABLE "user"
(
  username text NOT NULL,
  password text,
  email text,
  CONSTRAINT user_pk_username PRIMARY KEY (username),
  CONSTRAINT user_unique_email UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "user"
  OWNER TO ${owner};