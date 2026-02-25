ALTER TABLE users
  ADD COLUMN role VARCHAR(20) NOT NULL DEFAULT 'USER';

ALTER TABLE users
  ALTER COLUMN created_at TYPE TIMESTAMPTZ
    USING created_at AT TIME ZONE 'UTC',
  ALTER COLUMN created_at SET DEFAULT now(),
  ALTER COLUMN created_at SET NOT NULL;

ALTER TABLE bookings
  ADD COLUMN status VARCHAR(20) NOT NULL DEFAULT 'PENDING';

ALTER TABLE bookings
  RENAME COLUMN booking_date TO start_date;

ALTER TABLE bookings
  ALTER COLUMN start_date TYPE TIMESTAMPTZ
    USING start_date AT TIME ZONE 'UTC',
  ALTER COLUMN start_date SET NOT NULL;

ALTER TABLE bookings
  ADD COLUMN end_date TIMESTAMPTZ NOT NULL;

ALTER TABLE bookings
  ALTER COLUMN user_id SET NOT NULL,
  ALTER COLUMN resource_id SET NOT NULL;

ALTER TABLE bookings
  ADD CONSTRAINT bookings_end_after_start_chk
    CHECK (end_date > start_date);
