package com.adrian.eady.security;

import java.time.Duration;
import java.time.Instant;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service 
public class JwtService {
    
    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(Authentication authentication) {

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .subject(authentication.getName())
            .issuedAt(now)
            .expiresAt(now.plus(Duration.ofHours(2)))
            .claim(
                "roles",
                authentication.getAuthorities()
                    .stream()
                    .map(authority -> authority.getAuthority())
                    .filter(authority -> authority.startsWith("ROLE_"))
                    .toList()
            )
            .build();

        return jwtEncoder
            .encode(JwtEncoderParameters.from(claims))
            .getTokenValue();
    }
}
