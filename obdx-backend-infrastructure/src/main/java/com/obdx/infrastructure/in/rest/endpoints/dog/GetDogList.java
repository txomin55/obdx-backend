package com.obdx.infrastructure.in.rest.endpoints.dog;

import com.obdx.application.dog.dto.DogListDTO;
import com.obdx.application.dog.port.GetDogListServiceCase;
import com.obdx.oas.stub.api.GetDogsApiDelegate;
import com.obdx.oas.stub.model.GetDogListWeb;
import com.obdx.infrastructure.in.rest.configuration.session.user.DogTrainerAuthorizationExtractor;
import com.obdx.infrastructure.in.rest.configuration.session.user.dto.RequestUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDogList implements GetDogsApiDelegate {

    private final GetDogListServiceCase getDogListService;
    private final DogTrainerAuthorizationExtractor tokenExtractor;

    public GetDogList(GetDogListServiceCase getDogListService, DogTrainerAuthorizationExtractor tokenExtractor) {
        this.getDogListService = getDogListService;
        this.tokenExtractor = tokenExtractor;
    }

    @Override
    public ResponseEntity<List<GetDogListWeb>> getDogs(String authorization) {
        RequestUserDetails user = tokenExtractor.getDataFromToken(authorization);

        List<DogListDTO> dogs = getDogListService.getDogs(user.getId());

        List<GetDogListWeb> mappedDogs = dogs.stream()
                .map(dog -> new GetDogListWeb(dog.id(), dog.name(), dog.image()))
                .toList();

        return ResponseEntity.ok(mappedDogs);
    }
}
