DROP TABLE IF EXISTS ww.distance_formula;

CREATE TABLE ww.distance_formula (
	id uuid NOT NULL,
	cd text NULL,
	from_current_to_yard numeric NULL,
	from_yard_to_current numeric NULL,
	CONSTRAINT distance_formula_pk PRIMARY KEY (id)
);


ALTER TABLE ww.distance_formula ADD create_date timestamp NULL;

INSERT INTO ww.distance_formula
(id, cd, from_current_to_yard, from_yard_to_current, create_date)
VALUES('611a67b9-815b-42d4-a623-48697deac924'::uuid, 'yards', 1, 1, '2023-08-23 12:27:19.798');
INSERT INTO ww.distance_formula
(id, cd, from_current_to_yard, from_yard_to_current, create_date)
VALUES('6bbf1d65-a863-4dce-b7b1-c2771e755ffa'::uuid, 'meters', 1.09361, 0.9144, '2023-08-23 12:27:19.804');
INSERT INTO ww.distance_formula
(id, cd, from_current_to_yard, from_yard_to_current, create_date)
VALUES('01ebfc42-d9cc-420f-826b-f3fea5031308'::uuid, 'inchs', 0.0277778, 36, '2023-08-23 12:27:19.809');
