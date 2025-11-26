package org.example.mediahandling.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("roleChecker")
public class RoleChecker {

    public boolean hasRole(Authentication authentication, String requiredRole) {
        if (!(authentication.getPrincipal() instanceof Jwt jwt)) {
            return false;
        }

        // extract roles from resource_access
        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess == null) return false;

        Map<String, Object> client = (Map<String, Object>) resourceAccess.get("edufy");
        if (client == null) return false;

        List<String> roles = (List<String>) client.get("roles");
        if (roles == null) return false;

        return roles.contains(requiredRole);
    }
}
