package com.ecommerce.user.service;

import com.ecommerce.user.dto.RegisterRequest;
import com.ecommerce.user.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void createUserSuccessfully() {
        RegisterRequest request = RegisterRequest.builder()
                .username("testuser")
                .email("test@example.com")
                .password("password123")
                .firstName("Test")
                .lastName("User")
                .build();

        UserDto created = userService.createUser(request);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getUsername()).isEqualTo("testuser");
        assertThat(created.getEmail()).isEqualTo("test@example.com");
        assertThat(created.getFirstName()).isEqualTo("Test");
        assertThat(created.getIsActive()).isTrue();
    }

    @Test
    void getUserByUsernameWorks() {
        RegisterRequest request = RegisterRequest.builder()
                .username("finduser")
                .email("find@example.com")
                .password("password123")
                .build();

        userService.createUser(request);
        UserDto found = userService.getUserByUsername("finduser");

        assertThat(found.getUsername()).isEqualTo("finduser");
    }
}
