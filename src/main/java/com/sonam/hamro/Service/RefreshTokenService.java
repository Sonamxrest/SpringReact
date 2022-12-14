package com.sonam.hamro.Service;

import com.sonam.hamro.models.RefreshToken;
import com.sonam.hamro.models.User;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken(User user);
}
