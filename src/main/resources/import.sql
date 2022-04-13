INSERT INTO MESSAGE (id, content, email) VALUES (1, 'test1', 'test1@test.com');
INSERT INTO MESSAGE (id, content, email) VALUES (2, 'test2', 'test2@test.com');

INSERT INTO EMO (code, name) VALUES ('U+1F600', 'grinning face');
INSERT INTO EMO (code, name) VALUES ('U+1F605', 'grinning face with sweat');
INSERT INTO EMO (code, name) VALUES ('U+1F44D', 'thumbs up');

INSERT INTO REACTION (msg_id, emo, email) values (1, 'U+1F600', 'test3@test.com')