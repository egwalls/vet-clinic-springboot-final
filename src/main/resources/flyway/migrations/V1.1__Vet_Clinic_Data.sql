-- customers

INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('bet_thompson', 'Betty', 'Thompson', NULL, '83 Parker Ave');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('pet_parker', 'Peter', 'Parker', NULL, '1157 May St.');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('cod_vhett', 'Cody', 'Vhett', '212-720-3920', '501 Mandalore Ave.');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('ril_poole', 'Riley', 'Poole', '948-393-3940', '23 Washington St.');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('ann_chase', 'Annabeth', 'Chase', '392-304-1920', NULL);
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('jil_hartley', 'Jillian', 'Hartley', NULL, '81 Pearl Ct.');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('tay_stephan', 'Taylorlyn', 'Stephan', '781-283-3942', '390 Barnstable Road');
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('jak_peralta', 'Jake', 'Peralta', '293-493-0099', NULL);
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('jus_mcelroy', 'Justin', 'McElroy', '392-794-0182', '78 Hunter Lane');

-- dx
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('fever_low', 'Low Grade Fever', 'a body temperature which is within 1-3 degrees farenheit above typical body temperature for patient');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('fever_high', 'High Grade Fever', 'a body temperature which is 4 or more degrees farenheit above typical body temperature for patient');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('tibia_fracture', 'Fractured Tibia', 'tibia bone has been broken');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('laceration_small', 'Small Laceration', 'a cut in the animal\'s skin; small');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('dehydration_moderate', 'Moderate dehydration', 'Dehydration where the patient can safely rehydrate by drinking on their own');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('asthma', 'Asthma', 'A condition where the throat constricts making it difficult to breathe');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('eye_infection', 'Eye Infection', 'A condition where there is an infection in the eye');

-- animals
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('fluffy63','Fluffy', 'DOG', 'Samoyed', 'thowing up, fever of 100F', 1);
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('steve16', 'Steve', 'SNAKE', 'Milk Snake', 'laceration on side, appears infected', 2);
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('sithspawn1', 'Sithspawn', 'CAT', 'Domestic Shorthair', 'wheezing, raspy breath', 3);
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('hector2', 'Hector', 'GECKO', NULL, 'pus around the eye', 4);

-- dx_animals
INSERT INTO dx_animal (dx_animal_id, animal_fk, dx_fk) VALUES ('fluffy63_feverLow', 1, 1);  
INSERT INTO dx_animal (dx_animal_id, animal_fk, dx_fk) VALUES ('fluffy63_dehydrationModerate', 1, 5);
INSERT INTO dx_animal (dx_animal_id, animal_fk, dx_fk) VALUES ('steve16_lacerationSmall', 2, 4);
INSERT INTO dx_animal (dx_animal_id, animal_fk, dx_fk) VALUES ('sithspawn1', 3, 6);
INSERT INTO dx_animal (dx_animal_id, animal_fk, dx_fk) VALUES ('hector2', 4, 7);


