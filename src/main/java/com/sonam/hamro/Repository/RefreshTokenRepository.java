package com.sonam.hamro.Repository;

import com.sonam.hamro.models.RefreshToken;

public interface RefreshTokenRepository extends BaseRepository<RefreshToken, Long> {

    RefreshToken getRefreshTokenByToken(String token);
}
