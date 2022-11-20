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
INSERT INTO customers (customer_id, f_name, l_name, phone, address) VALUES ('', '', '', '', '');

-- dx
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('fever_low', 'Low Grade Fever', 'a body temperature which is within 1-3 degrees farenheit above typical body temperature for patient');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('fever_high', 'High Grade Fever', 'a body temperature which is 4 or more degrees farenheit above typical body temperature for patient');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('tibia_fracture', 'Fractured Tibia', 'tibia bone has been broken');
INSERT INTO dx (dx_id, dx_name, dx_description) VALUES ('laceration_small', 'Small Laceration', 'a cut in the animal\'s skin; small');

-- animals
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('fluffy63','Fluffy', 'DOG', 'Samoyed', 'thowing up, fever of 100F', 1);
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('steve16', 'Steve', 'SNAKE', 'Milk Snake', 'laceration on side, appears infected', 2);
INSERT INTO animals (animal_id, animal_name, species, breed, symptoms, customer_fk) VALUES ('sithspawn1', 'Sithspawn', 'CAT', 'Domestic Shorthair', 'wheezing, raspy breath', 3);

-- dx_animals
INSERT INTO dx_animals (dx_animal_id, dx_fk, animal_fk) VALUES ('fluffy63_tibiaFracture', 3, 1);  


