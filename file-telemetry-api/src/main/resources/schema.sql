CREATE TABLE IF NOT EXISTS files (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    filename    TEXT,
    created_at  DATETIME DEFAULT (DATETIME('now', 'localtime')),
    updated_at  DATETIME DEFAULT (DATETIME('now', 'localtime'))
);