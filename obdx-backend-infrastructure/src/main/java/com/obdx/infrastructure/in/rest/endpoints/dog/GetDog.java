package com.obdx.infrastructure.in.rest.endpoints.dog;

import com.obdx.application.dog.command.DogGetCommand;
import com.obdx.application.dog.dto.DogDTO;
import com.obdx.application.dog.port.GetDogServiceCase;
import com.obdx.oas.stub.api.GetDogApiDelegate;
import com.obdx.oas.stub.model.GetDogWeb;
import com.obdx.infrastructure.in.rest.configuration.session.user.AuthorizationExtractor;
import com.obdx.infrastructure.in.rest.configuration.session.user.dto.RequestUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetDog implements GetDogApiDelegate {

    private final GetDogServiceCase getDogService;
    private final AuthorizationExtractor tokenExtractor;

    public GetDog(GetDogServiceCase getDogService, AuthorizationExtractor tokenExtractor) {
        this.getDogService = getDogService;
        this.tokenExtractor = tokenExtractor;

    }

    @Override
    public ResponseEntity<GetDogWeb> getDog(String id, String authorization) {
        RequestUserDetails user = tokenExtractor.getDataFromToken(authorization);

        DogDTO dog = getDogService.getDog(new DogGetCommand(id, user.getId()));

        return ResponseEntity.ok(new GetDogWeb(dog.id(), dog.name(), dog.image()));
    }
}
