package com.obdx.infrastructure.out.inmemory.dog.adapter;

import com.obdx.domain.commons.entitystatemachine.EntityStateMachine;
import com.obdx.domain.dog.model.Dog;
import com.obdx.domain.dog.port.GetDogPersistencePort;
import com.obdx.infrastructure.out.inmemory.dog.entity.DogEntity;

import java.util.Map;

public class GetDogInMemoryAdapter implements GetDogPersistencePort {

    private final Map<String, DogEntity> simulatedDogMap;

    public GetDogInMemoryAdapter(Map<String, DogEntity> simulatedDogMap) {
        this.simulatedDogMap = simulatedDogMap;
    }

    @Override
    public Dog getDog(String id) {

        DogEntity dog = simulatedDogMap.get(id);
        if(dog == null){
            return new Dog();
        }
        return new Dog(dog.getId(), dog.getName(), dog.getImage(), dog.getOwner(), EntityStateMachine.valueOfState(dog.getState()), dog.getLastUpdate());
    }
}
