package com.obdx.infrastructure.in.rest.configuration.session.user;

import com.obdx.infrastructure.in.rest.configuration.session.user.dto.RequestUserDetails;

public interface DogTrainerAuthorizationExtractor {

    RequestUserDetails getDataFromToken(String authorization);
}
