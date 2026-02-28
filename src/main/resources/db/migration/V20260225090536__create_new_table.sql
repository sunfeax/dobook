CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(100) NOT NULL UNIQUE,
  phone_number VARCHAR(20) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL DEFAULT 'USER',
  user_type VARCHAR(20) NOT NULL DEFAULT 'CLIENT',
  created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT users_role_chk CHECK (role IN ('USER', 'ADMIN')),
  CONSTRAINT users_user_type_chk CHECK (user_type IN ('CLIENT', 'PROVIDER'))
);

CREATE TABLE venues (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(255),
  description TEXT,
  admin_user_id BIGINT NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_venues_admin_user FOREIGN KEY (admin_user_id) REFERENCES users(id)
);

CREATE TABLE resources (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  type VARCHAR(50) NOT NULL,
  description TEXT,
  capacity INTEGER NOT NULL DEFAULT 1,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  venue_id BIGINT NOT NULL,
  CONSTRAINT fk_resource_venue FOREIGN KEY (venue_id) REFERENCES venues(id),
  CONSTRAINT resources_type_chk CHECK (type IN ('TABLE', 'ROOM', 'WORKSPACE', 'STUDIO')),
  CONSTRAINT resources_capacity_chk CHECK (capacity BETWEEN 1 AND 1000)
);

CREATE TABLE bookings (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL,
  resource_id BIGINT NOT NULL,
  venue_id BIGINT NOT NULL,
  price_amount NUMERIC(12,2) NOT NULL DEFAULT ROUND((10 + random() * 190)::numeric, 2),
  start_date TIMESTAMPTZ NOT NULL,
  end_date TIMESTAMPTZ NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
  payment_method VARCHAR(20) NOT NULL DEFAULT 'ONLINE',
  created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_booking_user FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_booking_resource FOREIGN KEY (resource_id) REFERENCES resources(id),
  CONSTRAINT fk_booking_venue FOREIGN KEY (venue_id) REFERENCES venues(id),
  CONSTRAINT bookings_end_after_start_chk CHECK (end_date > start_date),
  CONSTRAINT bookings_price_amount_non_negative_chk CHECK (price_amount >= 0),
  CONSTRAINT bookings_status_chk CHECK (status IN ('PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED')),
  CONSTRAINT bookings_payment_method_chk CHECK (payment_method IN ('ONLINE', 'ON_SITE'))
);

CREATE TABLE payments (
  id BIGSERIAL PRIMARY KEY,
  booking_id BIGINT NOT NULL UNIQUE,
  amount NUMERIC(12,2) NOT NULL,
  currency CHAR(3) NOT NULL DEFAULT 'EUR',
  status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
  created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT payments_amount_non_negative_chk CHECK (amount >= 0),
  CONSTRAINT payments_status_chk CHECK (status IN ('PENDING', 'PAID', 'FAILED', 'REFUNDED')),
  CONSTRAINT fk_payments_booking FOREIGN KEY (booking_id) REFERENCES bookings(id)
);
