ALTER TABLE bookings
  ADD COLUMN venue_id BIGINT;

UPDATE bookings b
SET venue_id = r.venue_id
FROM resources r
WHERE b.resource_id = r.id;

ALTER TABLE bookings
  ALTER COLUMN venue_id SET NOT NULL;

ALTER TABLE bookings
  ADD CONSTRAINT fk_booking_venue
    FOREIGN KEY (venue_id) REFERENCES venues(id);

CREATE INDEX idx_bookings_venue_id ON bookings (venue_id);
