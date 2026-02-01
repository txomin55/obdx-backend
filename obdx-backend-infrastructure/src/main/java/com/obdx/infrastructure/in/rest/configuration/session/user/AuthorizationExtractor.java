package com.obdx.infrastructure.in.rest.configuration.session.user;

import com.obdx.infrastructure.in.rest.configuration.session.user.dto.RequestUserDetails;

public interface AuthorizationExtractor {

    RequestUserDetails getDataFromToken(String authorization);
}
