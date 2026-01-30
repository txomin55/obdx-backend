package com.obdx.domain.dog.port;

import com.obdx.domain.dog.model.Dog;

import java.util.List;

public interface GetDogListPersistencePort {

    List<Dog> getDogs(String owner);
}
