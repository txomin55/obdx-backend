package com.obdx.infrastructure.in.rest.configuration.session.user.type.mocked;

import com.obdx.infrastructure.in.rest.configuration.session.user.DogTrainerAuthorizationExtractor;
import com.obdx.infrastructure.in.rest.configuration.session.user.dto.RequestUserDetails;

import java.util.List;

public class MockedDogTrainerAuthorizationExtractor implements DogTrainerAuthorizationExtractor {

    private final RequestUserDetails details;

    public MockedDogTrainerAuthorizationExtractor(String id, String fullName, List<String> organizations) {
        this.details = new RequestUserDetails(id, fullName, organizations);
    }

    @Override
    public RequestUserDetails getDataFromToken(String authorization) {
        return this.details;
    }
}
