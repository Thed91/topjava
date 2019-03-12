DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
# ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER TABLE users AUTO_INCREMENT = 100000;
ALTER TABLE meals AUTO_INCREMENT = 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (dateTime, description, calories, user_id) VALUES
('2019-01-01 7:00:00', 'Diner', 500, 100000),
('2019-01-01 10:00:00', 'Lunch', 1000, 100000),
('2019-01-01 7:00:00', 'Diner', 700, 100001),
('2019-01-01 10:00:00', 'Lunch', 1000, 100001);
