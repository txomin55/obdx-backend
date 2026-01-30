package com.obdx.infrastructure.in.rest.endpoints.user;


import com.obdx.oas.stub.api.GetUserDataApiDelegate;
import com.obdx.oas.stub.model.DogTrainerUserDetails;
import com.obdx.infrastructure.in.rest.configuration.session.user.DogTrainerAuthorizationExtractor;
import com.obdx.infrastructure.in.rest.configuration.session.user.dto.RequestUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetUserData implements GetUserDataApiDelegate {

    private final DogTrainerAuthorizationExtractor tokenExtractor;

    public GetUserData(DogTrainerAuthorizationExtractor tokenExtractor) {
        this.tokenExtractor = tokenExtractor;
    }

    @Override
    public ResponseEntity<DogTrainerUserDetails> getUserData(String authorization) {
        RequestUserDetails user = tokenExtractor.getDataFromToken(authorization);
        return ResponseEntity.ok(new DogTrainerUserDetails(user.getId(), user.getOrganizations()));
    }
}
