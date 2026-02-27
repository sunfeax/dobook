-- Additional testing data for all core tables

INSERT INTO venues (name, address, description)
VALUES
  ('Skyline Coworking Hub', '12 Market St, Austin, TX', 'Coworking space with meeting rooms and open desks.'),
  ('Riverside Studio Loft', '85 River Ave, Portland, OR', 'Loft venue for creative teams and media sessions.'),
  ('Central Meeting Point', '200 Main Blvd, Chicago, IL', 'Business venue for team meetings and workshops.'),
  ('Green Garden Hall', '7 Oak Lane, Seattle, WA', 'Quiet venue with indoor and terrace work zones.');

INSERT INTO users (username, email, password, role)
VALUES
  ('anna_petrenko', 'anna.petrenko@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQ8m', 'USER'),
  ('dmitry_sokolov', 'dmitry.sokolov@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQ8m', 'USER'),
  ('olga_ivanova', 'olga.ivanova@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQ8m', 'USER'),
  ('manager_roma', 'roma.manager@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQ8m', 'ADMIN'),
  ('guest_maria', 'maria.guest@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQ8m', 'USER');

INSERT INTO resources (name, type, capacity, description, is_active, venue_id)
VALUES
  ('Skyline Desk 1', 'WORKSPACE', 1, 'Single desk in open coworking area.', TRUE, (SELECT id FROM venues WHERE name = 'Skyline Coworking Hub' ORDER BY id LIMIT 1)),
  ('Skyline Meeting Room', 'ROOM', 8, 'Enclosed meeting room with video conference setup.', TRUE, (SELECT id FROM venues WHERE name = 'Skyline Coworking Hub' ORDER BY id LIMIT 1)),
  ('Skyline Table North', 'TABLE', 6, 'Shared table near north wall power outlets.', TRUE, (SELECT id FROM venues WHERE name = 'Skyline Coworking Hub' ORDER BY id LIMIT 1)),

  ('Riverside Workspace 2', 'WORKSPACE', 1, 'Open-space desk with ergonomic chair.', TRUE, (SELECT id FROM venues WHERE name = 'Riverside Studio Loft' ORDER BY id LIMIT 1)),
  ('Riverside Room Blue', 'ROOM', 12, 'Large room for presentations and planning.', TRUE, (SELECT id FROM venues WHERE name = 'Riverside Studio Loft' ORDER BY id LIMIT 1)),
  ('Riverside Podcast Studio', 'STUDIO', 4, 'Audio-ready studio for recording sessions.', TRUE, (SELECT id FROM venues WHERE name = 'Riverside Studio Loft' ORDER BY id LIMIT 1)),

  ('Central Table 1', 'TABLE', 4, 'Classic four-seat table for meetings.', TRUE, (SELECT id FROM venues WHERE name = 'Central Meeting Point' ORDER BY id LIMIT 1)),
  ('Central Team Room', 'ROOM', 10, 'Team room with projector and board.', TRUE, (SELECT id FROM venues WHERE name = 'Central Meeting Point' ORDER BY id LIMIT 1)),
  ('Central Open Space', 'WORKSPACE', 20, 'Open area for group coworking.', TRUE, (SELECT id FROM venues WHERE name = 'Central Meeting Point' ORDER BY id LIMIT 1)),

  ('Garden Cabin A', 'ROOM', 6, 'Quiet enclosed cabin with garden view.', TRUE, (SELECT id FROM venues WHERE name = 'Green Garden Hall' ORDER BY id LIMIT 1)),
  ('Garden Terrace Table', 'TABLE', 5, 'Outdoor table on a covered terrace.', TRUE, (SELECT id FROM venues WHERE name = 'Green Garden Hall' ORDER BY id LIMIT 1)),
  ('Garden Creative Studio', 'STUDIO', 8, 'Studio room for collaborative creative work.', TRUE, (SELECT id FROM venues WHERE name = 'Green Garden Hall' ORDER BY id LIMIT 1));

INSERT INTO bookings (user_id, resource_id, start_date, end_date, status)
VALUES
  (
    (SELECT id FROM users WHERE username = 'dmitry_sokolov' LIMIT 1),
    (SELECT id FROM resources WHERE name = 'Skyline Meeting Room' LIMIT 1),
    TIMESTAMPTZ '2026-03-02 09:00:00+03',
    TIMESTAMPTZ '2026-03-02 11:00:00+03',
    'PENDING'
  ),
  (
    (SELECT id FROM users WHERE username = 'olga_ivanova' LIMIT 1),
    (SELECT id FROM resources WHERE name = 'Riverside Podcast Studio' LIMIT 1),
    TIMESTAMPTZ '2026-02-20 14:00:00+03',
    TIMESTAMPTZ '2026-02-20 16:00:00+03',
    'COMPLETED'
  ),
  (
    (SELECT id FROM users WHERE username = 'manager_roma' LIMIT 1),
    (SELECT id FROM resources WHERE name = 'Central Team Room' LIMIT 1),
    TIMESTAMPTZ '2026-03-04 15:00:00+03',
    TIMESTAMPTZ '2026-03-04 17:00:00+03',
    'CANCELLED'
  ),
  (
    (SELECT id FROM users WHERE username = 'guest_maria' LIMIT 1),
    (SELECT id FROM resources WHERE name = 'Garden Terrace Table' LIMIT 1),
    TIMESTAMPTZ '2026-03-05 12:30:00+03',
    TIMESTAMPTZ '2026-03-05 14:00:00+03',
    'CONFIRMED'
  ),
  (
    (SELECT id FROM users WHERE username = 'anna_petrenko' LIMIT 1),
    (SELECT id FROM resources WHERE name = 'Central Open Space' LIMIT 1),
    TIMESTAMPTZ '2026-03-07 09:30:00+03',
    TIMESTAMPTZ '2026-03-07 12:30:00+03',
    'CONFIRMED'
  ),
  (
    (SELECT id FROM users WHERE username = 'dmitry_sokolov' LIMIT 1),
    (SELECT id FROM resources WHERE name = 'Garden Creative Studio' LIMIT 1),
    TIMESTAMPTZ '2026-03-08 13:00:00+03',
    TIMESTAMPTZ '2026-03-08 15:30:00+03',
    'PENDING'
  );
