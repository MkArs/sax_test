INSERT INTO users (username, password, enabled)
VALUES
	('zaur', '{noop}zaur', 1),
	('elena', '{noop}elena', 1),
	('ivan', '{noop}ivan', 1);
    
INSERT INTO authorities (username, authority)
VALUES
	('zaur', 'ROLE_USER'),
	('elena', 'ROLE_USER'),
    ('ivan', 'ROLE_USER');
    
    