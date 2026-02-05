package io.github.observability.filetelemetryinfra.repository.sqlite;

import io.github.observability.filetelemetrycore.domain.platform.User;
import io.github.observability.filetelemetryinfra.entity.UserEntity;
import io.github.observability.filetelemetryinfra.mapper.UserEntityMapper;
import io.github.observability.filetelemetryinfra.repository.UserRepository;
import io.github.observability.filetelemetryinfra.repository.sqlite.time.TimeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
@Profile("standalone")
public class SqliteUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(User user) {
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }

        jdbcTemplate.update("""
            INSERT INTO users(key, name, role, secret_hash, 
                             export, status, 
                             created_at, updated_at) 
            VALUES(?, ?, ?, ?, ?, ?, ?, ?)
        """, user.getKey(), user.getName() ,user.getUserRole().name(), user.getPassword(),
                user.isCanExport(), user.getStatus().name(),
                TimeConvertor.localDateTimeToEpoch(user.getCreatedAt()),
                TimeConvertor.localDateTimeToEpoch(LocalDateTime.now()));
    }

    public User findUserByKey(String key) {
        UserEntity userEntity = jdbcTemplate.queryForObject("SELECT * FROM users WHERE key = ?",
                new BeanPropertyRowMapper<>(UserEntity.class), key);
        return UserEntityMapper.to(userEntity);
    }
}
