package com.obdx.infrastructure.out.inmemory.configuration.dog;

import com.obdx.domain.commons.entitystatemachine.EntityStateMachine;
import com.obdx.domain.dog.port.GetDogListPersistencePort;
import com.obdx.domain.dog.port.GetDogPersistencePort;
import com.obdx.infrastructure.out.inmemory.dog.adapter.GetDogInMemoryAdapter;
import com.obdx.infrastructure.out.inmemory.dog.adapter.GetDogListInMemoryAdapter;
import com.obdx.infrastructure.out.inmemory.dog.entity.DogEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "obdx-backend.deploy.tech", havingValue = "in-memory")
public class DogInMemoryAdapterConfiguration {

    @Bean
    public Map<String, DogEntity> simulatedDogMap() {
        Map<String, DogEntity> dogMap = new HashMap<>();
        dogMap.put("0", new DogEntity("0", "Dog 1", "0", "1", EntityStateMachine.DRAFT.name(), System.currentTimeMillis()));
        dogMap.put("1", new DogEntity("1", "Dog 2", "1", "1", EntityStateMachine.DRAFT.name(), System.currentTimeMillis()));
        return dogMap;
    }

    @Bean
    public GetDogListPersistencePort getDogListPersistencePort() {
        return new GetDogListInMemoryAdapter(simulatedDogMap());
    }

    @Bean
    public GetDogPersistencePort getDogPersistencePort() {
        return new GetDogInMemoryAdapter(simulatedDogMap());
    }
}
