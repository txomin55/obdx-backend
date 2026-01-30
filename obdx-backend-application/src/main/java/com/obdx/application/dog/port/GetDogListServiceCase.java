package com.obdx.application.dog.port;

import com.obdx.application.dog.dto.DogListDTO;
import com.obdx.domain.dog.model.Dog;
import com.obdx.domain.dog.port.GetDogListPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDogListServiceCase {

    private final GetDogListPersistencePort getDogListPersistencePort;

    public GetDogListServiceCase(GetDogListPersistencePort getDogListPersistencePort) {
        this.getDogListPersistencePort = getDogListPersistencePort;
    }

    public List<DogListDTO> getDogs(String owner) {
        List<Dog> dogs = getDogListPersistencePort.getDogs(owner);

        return dogs.stream().map(dog -> new DogListDTO(dog.getId(), dog.getName(), dog.getImage(), dog.getOwner()))
                .toList();
    }
}
