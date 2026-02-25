-- what we book (e.g. "Table 1")
CREATE TABLE resources (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- appointment (date)
CREATE TABLE bookings (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES users (id),
  resource_id BIGINT REFERENCES resources (id),
  booking_date TIMESTAMP NOT NULL
);

-- Test data
INSERT INTO resources (name) VALUES ('Table 1'), ('Table 2'), ('Table 3'), ('VIP room');

INSERT INTO users (username, email, password) VALUES (
  'vlad_admin',
  'vlad@example.com',
  '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQ8m'
);
