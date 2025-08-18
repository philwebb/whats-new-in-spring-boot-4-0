CREATE TABLE stuffie_owner (
	stuffie INT NOT NULL,
	owner INT NOT NULL,
	PRIMARY KEY (stuffie, owner)
);

ALTER TABLE stuffie_owner ADD CONSTRAINT fk_stuffie_owner_stuffie FOREIGN KEY (stuffie) REFERENCES stuffie;
ALTER TABLE stuffie_owner ADD CONSTRAINT fk_stuffie_owner_owner FOREIGN KEY (owner) REFERENCES owner;

INSERT INTO stuffie_owner (stuffie, owner) SELECT id, owner from stuffie;
INSERT INTO stuffie_owner (stuffie, owner) VALUES (0, 2);

ALTER TABLE stuffie DROP COLUMN owner;
