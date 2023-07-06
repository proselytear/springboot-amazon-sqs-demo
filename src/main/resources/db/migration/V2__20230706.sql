CREATE TABLE IF NOT EXISTS recipients (
    id            VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    channel       VARCHAR(255) NOT NULL,
    address          VARCHAR(1024),
    full_name VARCHAR(1000)
);

ALTER TABLE notifications ADD CONSTRAINT fk_notifications_recipient_uid
FOREIGN KEY (recipient_uid) REFERENCES recipients(id);
