-- customers

INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('bet_thompson', 'Betty', 'Thompson', NULL, '83 Parker Ave');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('pet_parker', 'Peter', 'Parker', NULL, '1157 May St.');

-- dx
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('fever_low', 'Low Grade Fever', 'a body temperature which is within 1-3 degrees farenheit above typical body temperature for patient');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('fever_high', 'High Grade Fever', 'a body temperature which is 4 or more degrees farenheit above typical body temperature for patient');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('tibia_fracture', 'Fractured Tibia', 'tibia bone has been broken');

-- animals
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('fluffy63','Fluffy', 'DOG', 'Samoyed', 'thowing up, fever of 100F', '1');
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('steve16', 'Steve', 'SNAKE', 'Milk Snake', 'laceration on side, appears infected','2');

-- dx_animals
INSERT INTO dx_animals (dx_animal_id, dx_fk, animal_fk) VALUES ('fluffy63_tibiaFracture', 3, 1);

-- translation: show all records of a specific animal, showing us which dx have been applied
SELECT animals.animal_name, dx.dx_name FROM  FROM animals INNER JOIN dx ON  


