ALTER TABLE IF EXISTS recipe ADD COLUMN IF NOT EXISTS number_of_persons INTEGER;
ALTER TABLE IF EXISTS recipe ADD COLUMN IF NOT EXISTS preparation_time INTEGER;
ALTER TABLE IF EXISTS recipe ADD COLUMN IF NOT EXISTS cooking_time INTEGER;
ALTER TABLE IF EXISTS recipe ADD COLUMN IF NOT EXISTS number_of_stars INTEGER;