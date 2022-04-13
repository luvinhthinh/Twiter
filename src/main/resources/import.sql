INSERT INTO MESSAGE (id, content, email) VALUES (1, 'test1', 'test1@test.com');
INSERT INTO MESSAGE (id, content, email) VALUES (2, 'test2', 'test2@test.com');

INSERT INTO EMO (code, name) VALUES ('\uD83D\uDE04', 'grinning face');
INSERT INTO EMO (code, name) VALUES ('\uD83D\uDE0A', 'grinning face with sweat');
INSERT INTO EMO (code, name) VALUES ('\uD83D\uDE03', 'thumbs up');

INSERT INTO REACTION (msg_id, emo, email) values (1, '\uD83D\uDE04', 'test3@test.com')