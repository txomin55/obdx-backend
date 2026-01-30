package com.obdx.application.dog.port;

import com.obdx.application.dog.command.DogGetCommand;
import com.obdx.application.dog.dto.DogDTO;
import com.obdx.domain.commons.exception.DomainException;
import com.obdx.domain.commons.exception.error.ErrorEnum;
import com.obdx.domain.dog.model.Dog;
import com.obdx.domain.dog.port.GetDogPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class GetDogServiceCase {

    private final GetDogPersistencePort getDogPersistencePort;

    public GetDogServiceCase(GetDogPersistencePort getDogPersistencePort) {
        this.getDogPersistencePort = getDogPersistencePort;
    }

    public DogDTO getDog(DogGetCommand command) {
        Dog dog = getDogPersistencePort.getDog(command.id());

        if (!dog.belongsToSameOwner(command.owner())) {
            throw new DomainException(ErrorEnum.UNAUTHORIZED_RESOURCE_ERROR);
        }

        return new DogDTO(dog.getId(), dog.getName(), dog.getImage(), dog.getOwner());
    }
}
