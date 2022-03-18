-- init event data
INSERT INTO tbl_event
  ( title, event_date )
VALUES
  ('Tech talk', DATE '2022-03-21'),
  ('Company trip', DATE '2022-03-22'),
  ('Team building', DATE '2022-03-26'),
  ('Hackathon', DATE '2022-03-28'),
  ('Company trip', DATE '2022-03-28'),
  ('Knowledge sharing', DATE '2022-03-29');

-- init user data
INSERT INTO tbl_user
  ( name, email )
VALUES
  ('Alice', 'alice@email.com'),
  ('Bob', 'bob@email.com'),
  ('Cindy', 'cindy@email.com'),
  ('Danny', 'danny@email.com'),
  ('Edgar', 'edgar@email.com'),
  ('Frank', 'frank@email.com'),
  ('George', 'george@email.com'),
  ('Helen', 'helen@email.com'),
  ('Illidan', 'illidan@email.com'),
  ('Jack',  'jack@email.com');

-- init ticket data
--INSERT INTO tbl_ticket
--  ( event_id, user_id, category, place )
--VALUES
--  (1, 1, 'STANDARD', 1),
--  (1, 2, 'PREMIUM', 3),
--  (1, 3, 'BAR', 2),
--  (2, 4, 'STANDARD', 1),
--  (2, 1, 'STANDARD', 2),
--  (3, 1, 'PREMIUM', 5),
--  (4, 1, 'STANDARD', 1),
--  (4, 1, 'STANDARD', 1),
--  (4, 10, 'PREMIUM', 1),
--  (5, 8, 'PREMIUM', 1),
--  (5, 4, 'PREMIUM', 5),
--  (5, 1, 'STANDARD', 4),
--  (5, 2, 'STANDARD', 3);
