package com.app.backend.dto;

import com.app.backend.enums.Role;

public record AuthUser(String id, String username, Role role) {
}
