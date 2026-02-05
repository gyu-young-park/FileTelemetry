package io.github.observability.filetelemetryapi.controller;

import io.github.observability.filetelemetryapi.data.dto.user.CreateAppUserRequest;
import io.github.observability.filetelemetryapi.data.dto.user.CreateAppUserResponse;
import io.github.observability.filetelemetryapi.data.mapper.UserMapper;
import io.github.observability.filetelemetryapi.service.UserService;
import io.github.observability.filetelemetrycore.domain.platform.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/platform/user")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping("/app-register")
    public ResponseEntity<CreateAppUserResponse> createAppUser(@RequestBody CreateAppUserRequest createAppUserRequest) {
        User user = userService.saveUser(userMapper.to(createAppUserRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.to(user));
    }
}
