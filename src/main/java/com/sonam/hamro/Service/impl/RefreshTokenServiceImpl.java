package com.sonam.hamro.Service.impl;

import com.sonam.hamro.Repository.RefreshTokenRepository;
import com.sonam.hamro.Service.RefreshTokenService;
import com.sonam.hamro.models.RefreshToken;
import com.sonam.hamro.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public RefreshToken generateRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setExpiration(Instant.now().plusMillis(500000));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken getRefreshTokenFromToken(String token) {
        return refreshTokenRepository.getRefreshTokenByToken(token);
    }
}
