PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY,
    user_key TEXT UNIQUE NOT NULL,
    user_role TEXT,
    user_name TEXT,
    client_id TEXT,
    client_secret_hash TEXT,
    can_export INTEGER,
    status TEXT,
    created_at INTEGER,
    updated_at INTEGER,
    last_login_at INTEGER
);

CREATE TABLE IF NOT EXISTS subscriptions (
    id INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL,
    channel_type TEXT,
    channel_key TEXT,
    status TEXT,
    created_at INTEGER,
    updated_at INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS traces (
    id INTEGER PRIMARY KEY,
    user_name TEXT,
    trace_key TEXT,
    status TEXT,
    start_time INTEGER,
    end_time INTEGER,
    created_at INTEGER,
    updated_at INTEGER
);

CREATE TABLE IF NOT EXISTS files (
    id INTEGER PRIMARY KEY,
    trace_id INTEGER NOT NULL,
    user_id INTEGER,
    file_key TEXT,
    file_name TEXT,
    file_size INTEGER,
    file_extension TEXT,
    status TEXT,
    created_at INTEGER,
    updated_at INTEGER,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS derived_data (
    id INTEGER PRIMARY KEY,
    trace_id INTEGER NOT NULL,
    user_id INTEGER,
    name TEXT,
    data_type TEXT,
    status TEXT,
    created_at INTEGER,
    updated_at INTEGER,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS entity_relations (
    id INTEGER PRIMARY KEY,
    trace_id INTEGER NOT NULL,
    from_type TEXT,
    from_id INTEGER,
    to_type TEXT,
    to_id INTEGER,
    relation_type TEXT,
    created_at INTEGER,
    updated_at INTEGER,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id)
);

CREATE TABLE IF NOT EXISTS telemetry (
    id INTEGER PRIMARY KEY,
    trace_id INTEGER,
    user_id INTEGER,
    entity_type TEXT,
    entity_id INTEGER,
    event_type TEXT,
    message TEXT,
    created_at INTEGER,
    updated_at INTEGER,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS storage (
    id INTEGER PRIMARY KEY,
    name TEXT,
    type TEXT,
    path TEXT,
    created_at INTEGER,
    updated_at INTEGER
);

CREATE TABLE IF NOT EXISTS stored_file (
    id INTEGER PRIMARY KEY,
    storage_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    name TEXT,
    compressed INTEGER,
    size INTEGER,
    stored_at INTEGER,
    updated_at INTEGER,
    FOREIGN KEY (storage_id) REFERENCES storage(storage_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS batch_summaries (
    id INTEGER PRIMARY KEY,
    time_window TEXT,
    trace_count INTEGER,
    file_count INTEGER,
    data_count INTEGER,
    dropped_files INTEGER,
    created_at INTEGER,
    updated_at INTEGER
);
