package io.github.observability.filetelemetryinfra.repository;

import io.github.observability.filetelemetrycore.domain.platform.User;

public interface UserRepository {
    void save(User user);
    User findUserByKey(String key);
}
