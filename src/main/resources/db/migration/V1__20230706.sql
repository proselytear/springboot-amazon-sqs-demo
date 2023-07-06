CREATE TABLE IF NOT EXISTS notifications (
    id            VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    subject       VARCHAR(255) NOT NULL,
    text          TEXT,
    recipient_uid VARCHAR(36)
);
