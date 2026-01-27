PRAGMA foreign_keys = ON;

CREATE TABLE users (
    user_id TEXT PRIMARY KEY,
    user_key TEXT UNIQUE NOT NULL,
    user_role TEXT,
    user_name TEXT,
    client_id TEXT,
    client_secret_hash TEXT,
    can_export INTEGER, -- 0 or 1
    status TEXT,
    created_at DATETIME,
    last_login_at DATETIME
);

CREATE TABLE subscriptions (
    subscription_id TEXT PRIMARY KEY,
    user_id TEXT NOT NULL,
    channel_type TEXT,
    channel_key TEXT,
    status TEXT,
    created_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE traces (
    trace_id TEXT PRIMARY KEY,
    user_id TEXT NOT NULL,
    trace_key TEXT,
    start_time DATETIME,
    end_time DATETIME,
    status TEXT,
    created_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE files (
    file_id TEXT PRIMARY KEY,
    trace_id TEXT NOT NULL,
    user_id TEXT,
    file_key TEXT,
    file_name TEXT,
    file_size INTEGER,
    file_extension TEXT,
    status TEXT,
    created_at DATETIME,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE derived_data (
    data_id TEXT PRIMARY KEY,
    trace_id TEXT NOT NULL,
    user_id TEXT,
    name TEXT,
    data_type TEXT,
    status TEXT,
    created_at DATETIME,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE entity_relations (
    relation_id TEXT PRIMARY KEY,
    trace_id TEXT NOT NULL,
    from_type TEXT,
    from_id TEXT,
    to_type TEXT,
    to_id TEXT,
    relation_type TEXT,
    created_at DATETIME,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id)
);

CREATE TABLE telemetry (
    log_id TEXT PRIMARY KEY,
    trace_id TEXT,
    user_id TEXT,
    entity_type TEXT,
    entity_id TEXT,
    event_type TEXT,
    message TEXT,
    created_at DATETIME,
    FOREIGN KEY (trace_id) REFERENCES traces(trace_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE storage (
    storage_id TEXT PRIMARY KEY,
    name TEXT,
    type TEXT,
    path TEXT,
    created_at DATETIME
);

CREATE TABLE stored_file (
    stored_file_id TEXT PRIMARY KEY,
    storage_id TEXT NOT NULL,
    user_id TEXT NOT NULL,
    name TEXT,
    compressed INTEGER,
    size INTEGER,
    stored_at DATETIME,
    FOREIGN KEY (storage_id) REFERENCES storage(storage_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE batch_summaries (
    summary_id TEXT PRIMARY KEY,
    time_window TEXT,
    trace_count INTEGER,
    file_count INTEGER,
    data_count INTEGER,
    dropped_files INTEGER,
    created_at DATETIME
);

--CREATE INDEX idx_subscriptions_user_id ON subscriptions(user_id);
--CREATE INDEX idx_traces_user_id ON traces(user_id);
--CREATE INDEX idx_files_trace_id ON files(trace_id);
--CREATE INDEX idx_files_user_id ON files(user_id);
--CREATE INDEX idx_derived_data_trace_id ON derived_data(trace_id);
--CREATE INDEX idx_entity_relations_trace_id ON entity_relations(trace_id);
--CREATE INDEX idx_telemetry_trace_id ON telemetry(trace_id);
--CREATE INDEX idx_telemetry_user_id ON telemetry(user_id);
--CREATE INDEX idx_stored_file_storage_id ON stored_file(storage_id);
