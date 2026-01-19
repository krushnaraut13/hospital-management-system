package com.example.HospitalManagementSystem.util;

import com.example.HospitalManagementSystem.exception.UnauthorizedException;

public class AuthorizationUtil {

    public static void checkRole(String role, String... allowedRoles) {
        for (String allowed : allowedRoles) {
            if (allowed.equalsIgnoreCase(role)) {
                return;
            }
        }
        throw new UnauthorizedException("Access Denied for role: " + role);
    }
}
