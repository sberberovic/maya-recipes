CREATE TABLE recipe
(
  id bigint PRIMARY KEY,
  name varchar(255) NOT NULL,
  category varchar(255) NOT NULL
);
CREATE UNIQUE INDEX recipe_id_unique_index ON recipe (id);
CREATE SEQUENCE IF NOT EXISTS recipe_id_seq START 1000000;