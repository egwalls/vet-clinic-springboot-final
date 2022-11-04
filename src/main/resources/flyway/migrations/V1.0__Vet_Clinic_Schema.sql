DROP TABLE IF EXISTS dx_animal;
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS dx;
DROP TABLE IF EXISTS customers;


-- should breed be an enum? seems like a real world database would have that
-- as enum so there is 'bull dog' vs bulldog etc but setting as enum
-- the amount of breeds for all the animals I have is way beyond project scope

CREATE TABLE customers (
  customer_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
  customer_id varchar(60) NOT NULL,
  f_name varchar(45) NOT NULL,
  l_name varchar(45) NOT NULL,
  phone varchar(20),
  address varchar(150),
  PRIMARY KEY (customer_pk),
  UNIQUE KEY (customer_id)
  
);

CREATE TABLE dx (
  dx_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
  dx_id varchar(60) NOT NULL,
  dx_name varchar(60) NOT NULL,
  dx_description text NOT NULL,
  PRIMARY KEY (dx_pk),
  UNIQUE KEY (dx_id)
);

CREATE TABLE animals (
  animal_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
  animal_id varchar(40) NOT NULL,
  animal_name varchar(45) NOT NULL,
  species enum ('DOG', 'CAT', 'BIRD', 'HORSE', 'MONKEY', 'FISH', 'SNAKE', 'IGUANA', 'GECKO', 'RABBIT', 'CHICKEN', 'DUCK', 'TURKEY', 'HAMSTER', 'GUINEA PIG', 'MOUSE', 'RAT', 'GERBIL', 'FERRET', 'GOAT', 'HEDGEHOG', 'PIG', 'SHEEP', 'OTHER') NOT NULL,
  breed varchar(45),
  symptoms text,
  customer_fk int UNSIGNED,
  PRIMARY KEY (animal_pk),
  UNIQUE KEY (animal_id),
  FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);


CREATE TABLE dx_animal (
  dx_animal_pk int UNSIGNED NOT NULL AUTO_INCREMENT,
  dx_animal_id varchar(60) NOT NULL,
  dx_fk int UNSIGNED NOT NULL,
  animal_fk int UNSIGNED NOT NULL,
  PRIMARY KEY (dx_animal_pk),
  FOREIGN KEY (dx_fk) REFERENCES dx (dx_pk) ON DELETE CASCADE,
  FOREIGN KEY (animal_fk) REFERENCES animals (animal_pk) ON DELETE CASCADE
);

