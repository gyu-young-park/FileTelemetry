package io.github.observability.filetelemetryapi.service;

import io.github.observability.filetelemetrycore.domain.platform.User;
import io.github.observability.filetelemetryinfra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // TODO auth logic by secret

    public User saveUser(User user) {
        userRepository.save(user);
        return userRepository.findUserByKey(user.getKey());
    }
}
